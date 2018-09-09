package com.company.algorythms;

import java.util.Random;

public class CardanoGrid {
    int[][] grid;
    int size=4;
    final String alphabet="абвгдеёжзийклмнопрстуфхцчшщъыьэюя +-";

    public CardanoGrid() {
        //this.size=size;
        generateGrid();
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
        char[][][] encryptedSquare=new char[squares][size][size];
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
        int ones=countOnes();
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

}
