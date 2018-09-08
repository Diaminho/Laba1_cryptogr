package com.company;

public class CardanoGrid {
    int[][] grid;
    int size;
    final String alphabet="абвгдеёжзийклмнопрстуфхцчшщъыьэюя +-";

    void generateGrid() {
        grid = new int[size][size];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = 0;
                grid[i][j] = 1;
            }
        }
    }

    public String doEncrypt(String strToEncrypt) {
        return "111";
    }

    public String doDecrypt(String strToDecrypt) {
        return "111";
    }

}
