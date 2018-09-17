package com.company.tools;

public class Validator {
    public Validator(){

    }
    //validators for Caesar
    public boolean validateShift(String alphabet, int shift){
        if (shift>=0 && shift<alphabet.length()) {
            return true;
        }
        else
            return  false;
    }

    ///common for several types of encoding
    public boolean validateText(String text, String alphabet){
        for (int i=0;i<text.length();i++){
            if(alphabet.indexOf(text.charAt(i))==-1){
                return false;
            }
        }
        return true;
    }
    //

    //validators for Slogan
    public boolean validateSlogan(String slogan, String alphabet){
        for (int i=0;i<slogan.length();i++) {
            if (alphabet.indexOf(slogan.charAt(i))==-1) {
                return false;
            }
        }
        return  true;
    }
    //

    //validators for CardanoGrid
    public boolean validateGridSize(int size) {
        if (size>0 && size%2==0){
            return true;
        }
        else
            return false;
    }

    public boolean validateGridFromFile(String grid){
        String alphabet="01";
        for (int i=0;i<grid.length();i++){
            if (alphabet.indexOf(grid.charAt(i))==-1){
                return false;
            }
        }
        return true;
    }

    public boolean validateGrid(int[][] grid){
        int[][] tmp_grid=grid;
        if (grid.length!=grid[0].length){
            System.out.println("решетка должна быть квадратной");
            return false;
        }
       int k=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if (grid[i][j]==1){
                    //System.out.println("grid i j"+ grid[i][j]);
                    while (k<3){
                        tmp_grid=getRotateArr(tmp_grid);
                        if (tmp_grid[i][j]==1){
                            //System.out.println("tmp_grid i j"+ tmp_grid[i][j]+"i "+i+" j "+j);
                            System.out.println("Решетка заполнена неверно. Есть пересекающиеся вырезы.");
                            return false;
                        }
                        k++;
                    }
                    tmp_grid=getRotateArr(tmp_grid);
                }
            }
        }

        return true;
    }

    public boolean validateEncodedGrid(char[][][] encodedGrid, int size, String alphabet){
        if (encodedGrid[0].length!=encodedGrid[0][0].length) {
            System.out.println("закодированная решетка не квадратная");
            return false;
        }
        if (encodedGrid[0].length!=size){
            System.out.println("Размер закодированной решетки не совпадает с размером решетки");
            return false;
        }
        for (int i=0;i<encodedGrid.length;i++){
            for (int j=0;j<encodedGrid[i].length;j++){
                for (int k=0;k<encodedGrid[i][j].length;k++){
                    if (alphabet.indexOf(encodedGrid[i][j][k])==-1){
                        System.out.println("В зашифрованной решетке используется символы не из алфавита");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    int [][] getRotateArr(int [][] sourceArr) {
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

    //
}
