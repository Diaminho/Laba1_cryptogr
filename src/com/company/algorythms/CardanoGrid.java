package com.company.algorythms;

import java.io.*;
import java.util.Random;

public class CardanoGrid {
    int[][] grid;

    char[][][] encryptedSquare;

    int size;
    int gridBin[];
    final String alphabet="абвгдеёжзийклмнопрстуфхцчшщъыьэюя +.";


    public char[][][] getEncryptedSquare() {
        return encryptedSquare;
    }


    public CardanoGrid() {
        //this.size=size;
        //generateGrid();
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    public void setGridBin(int[] gridBin) {
        this.gridBin = gridBin;
    }


    public int[] getGridBin() {
        return gridBin;
    }

    public int[][] getGrid() {
        return grid;
    }


    int countOnes() {
        int summ=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]==1)
                    summ++;
            }
        }
        return summ;
    }

    public int [][] getRotateArr(int [][] sourceArr) {
        int [][] retArr = new int[sourceArr[0].length][sourceArr.length];
        int retArrI = 0;
        int retArrJ = sourceArr.length - 1;
        for (int [] srI : sourceArr){
            for (int srJ : srI)
                retArr[retArrI++][retArrJ] = srJ;
            retArrI = 0;
            retArrJ--;
        }
        return retArr;
    }


    public char[][][] doEncrypt(String strToEncrypt) {
        int ones=countOnes();
        int[][] tmp_grid=grid;
        int k=0;
        int squares=(int)Math.ceil((double)strToEncrypt.length()/(4*ones));
        encryptedSquare=new char[squares][size][size];
        for (int l=0;l<encryptedSquare.length;l++){
            for (int i = 0; i < encryptedSquare[l].length; i++) {
                for (int j = 0; j < encryptedSquare[l][i].length; j++) {
                    encryptedSquare[l][i][j] = '>';
                }
            }
        }

        Random rnd = new Random(System.currentTimeMillis());
        // Получаем случайное число в диапазоне от min до max (включительно)
        //0
        for (int m = 0; m < encryptedSquare.length; m++) {
            for (int l=0;l<4;l++) {
                for (int i = 0; i < encryptedSquare[m].length; i++) {
                    for (int j = 0; j < encryptedSquare[m][i].length; j++) {
                        if (tmp_grid[i][j] == 1) {
                            if (k < strToEncrypt.length()) {
                                encryptedSquare[m][i][j] = strToEncrypt.charAt(k);
                                k++;
                            } else {
                                encryptedSquare[m][i][j] = alphabet.charAt(0 + rnd.nextInt(alphabet.length() - 0 ));
                                k++;
                            }
                        } else {
                            if (encryptedSquare[m][i][j] == '>')
                                encryptedSquare[m][i][j] = alphabet.charAt(0 + rnd.nextInt(alphabet.length() - 0 ));
                        }
                    }
                }
                tmp_grid = getRotateArr(tmp_grid);
            }
        }
        return encryptedSquare;
    }

    public String doDecrypt(char[][][] encryptedSquare) {
        //int ones=countOnes();
        int[][] tmp_grid=grid;
        int k=0;
        StringBuffer decr=new StringBuffer();
        for (int m = 0; m < encryptedSquare.length; m++) {
            for (int l=0;l<4;l++) {
                for (int i = 0; i < encryptedSquare[m].length; i++) {
                    for (int j = 0; j < encryptedSquare[m][i].length; j++) {
                        if (tmp_grid[i][j] == 1) {
                            decr.insert(k, encryptedSquare[m][i][j]);
                            k++;
                        }
                    }
                }
                tmp_grid = getRotateArr(tmp_grid);
            }
        }
        return decr.toString();
    }

    public void generateGrid1(){
        int[][] tmp_grid = new int[size][size];
        int[][] index=new int[size][size];
        for (int i = 0; i < tmp_grid.length; i++) {
            for (int j = 0; j < tmp_grid.length; j++) {
                tmp_grid[i][j]=0;
                index[i][j]=0;
            }
        }

        Random rnd = new Random(System.currentTimeMillis());
        int ind1,ind2;

        for (int l=0;l<rnd.nextInt(tmp_grid.length)+1;l++) {
            ind1=rnd.nextInt(tmp_grid.length);
            ind2=rnd.nextInt(tmp_grid.length);
            while (index[ind1][ind2]==-1)
                ind1=rnd.nextInt(tmp_grid.length);
                ind2=rnd.nextInt(tmp_grid.length);
            tmp_grid[ind1][ind2]=1;
            int mm=0;
            while (mm<4) {
                index[ind1][ind2]=-1;
                index = getRotateArr(index);
                mm++;
            }

        }
        grid=tmp_grid;
        gridBin =new int[size];
        int tmp_num=0;
        for (int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[i].length; j++) {
                tmp_num=tmp_num*10+grid[i][j];
            }
            gridBin[i]=tmp_num;
            tmp_num=0;
        }

        for (int i = 0; i< gridBin.length; i++)
            System.out.println(gridBin[i]);

    }


    public int[] binToDec(int[] bin) {
        int[] dec=new int[bin.length];
        for (int i=0;i<dec.length;i++)
            dec[i]=Integer.parseInt(bin[i]+"",2);
        return dec;
    }

    void generateGrid() {
        grid = new int[size][size];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(i==0 && j==0) {
                    grid[i][j] = 1;
                }

                else if (i==1 && j==1) {
                    grid[i][j]=1;
                }

                else {
                    grid[i][j] = 0;
                }
            }
        }
    }


    public String asBitString(String value, int stringSize) {
        String str="";
        for (int i = 0; i < stringSize-value.length(); i++) {
            str+='0';
        }
        return str+value;
    }

    public void getGridFromFile(String fileName1){
        //System.out.println("Введите имя файла с решеткой: ");
        //String fileName1 = in.nextLine();
        //CardanoGrid testCard = new CardanoGrid();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName1))) {
            //while (br.readLine()) != null){
            this.setSize(this.countLines(fileName1));
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        String[] tgrid=new String[this.getSize()];
        String tmpStr="";
        int k=0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName1))) {
            while ((tmpStr=br.readLine()) != null) {
                tgrid[k]=tmpStr;
                k++;
            }
        }

        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(tgrid[1]);
        String[] ngrid=new String[tgrid.length];
        System.out.println(tgrid.length);
        for (int i=0;i<tgrid.length;i++){
            ngrid[i]=this.asBitString(tgrid[i],tgrid.length);
        }
        System.out.println(ngrid[1]);

        this.grid=new int[ngrid.length][ngrid.length];
        for (int i=0;i<this.grid.length;i++){
            for (int j=0;j<this.grid[i].length;j++){
                this.grid[i][j]=Character.getNumericValue(ngrid[i].charAt(j));
            }
        }
    }

    public void getInfoFromFile(String info){
        encryptedSquare=new char[(info.length())/(size*size)][size][size];
        System.out.println("size:"+info.length()/(size*size)+", size"+size);
        int l=0;
        for (int i=0;i<encryptedSquare.length;i++){
            for (int j=0;j<encryptedSquare[i].length;j++){
                for(int k=0;k<encryptedSquare[i][j].length;k++){
                    encryptedSquare[i][j][k]=info.charAt(l);
                    l++;
                }
            }
        }

    }

    public int countLines(String filename) {
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(filename));
            try {
                byte[] c = new byte[1024];
                int count = 0;
                int readChars = 0;
                boolean empty = true;
                while ((readChars = is.read(c)) != -1) {
                    empty = false;
                    for (int i = 0; i < readChars; ++i) {
                        if (c[i] == '\n') {
                            ++count;
                        }
                    }
                }
                return (count == 0 && !empty) ? 1 : count;
            } finally {
                is.close();
            }

        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        return -1;
    }


    public void printGrid(){
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void printEncGrid(){
        for (int i=0;i<encryptedSquare.length;i++){
            for (int j=0;j<encryptedSquare[i].length;j++){
                for (int k=0;k<encryptedSquare[i][j].length;k++) {
                    System.out.print(encryptedSquare[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}
