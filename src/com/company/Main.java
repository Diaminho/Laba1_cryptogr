package com.company;


import com.company.algorythms.Caesar;
import com.company.algorythms.CardanoGrid;
import com.company.tools.Menu;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int out_menu=0;
        while (out_menu!=6){
            System.out.println("Главное меню");
            System.out.println("Введите 1 для шифрования/дешифрования с помощью шифра Цезаря");
            System.out.println("Введите 2 для шифрования/дешифрования с помощью слогана");
            System.out.println("Введите 3 для шифрования/дешифрования с помощью квадрата Полибия");
            System.out.println("Введите 4 для шифрования/дешифрования с помощью решетки Кардано");
            System.out.println("Введите 5 для шифрования/дешифрования с помощью однократного Гаммирования");
            System.out.println("Введите 6 для выхода");
            System.out.println("Введите число:");
            out_menu = in.nextInt();
            in.nextLine();
            switch(out_menu) {
                case 1:
                    Menu.CaesarMenu(in);
                    break;
                case 2:
                    Menu.SloganMenu(in);
                    break;
                case 3:
                    Menu.PolybiusMenu(in);
                    break;
                case 4:
                    Menu.CardanoMenu(in);
                    break;
                case 5:
                    Menu.GamblingMenu(in);
                    break;
                case 6:
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Нет такой опции");
                    break;


            }

        }





        //слогановый шифр
        /*
        Slogan testSlogan = new Slogan();
        testSlogan.setKeyword("гдея.");
        testSlogan.setShiftedAlphabet();
        System.out.println("новый алфавит: "+testSlogan.getShiftedAlphabet());
        String encryptedString=testSlogan.doEncrypt("слово");
        System.out.println("Зашифрованное слово:"+encryptedString);
        String decryptedString=testSlogan.doDecrypt(encryptedString);
        System.out.println("Расшифрованное слово:"+decryptedString);
        */

        //квадрат Полибия
        /*
        PolybiusSquare testPoly=new PolybiusSquare();
        testPoly.printAlphabet();
        String str=" +-";
        System.out.println("Исходная строка: "+str);
        String encStr=testPoly.doEncrypt(str);
        System.out.println("Зашифрованная строка: "+encStr);
        String decStr=testPoly.doDecrypt(encStr);
        System.out.println("Расшифрованная строка: "+decStr);
        */
        //System.out.println(encStr);

       //Гаммирование
        /*
        Gambling test_gambl=new Gambling();
        test_gambl.setKey("ключ");
        String str=test_gambl.doEncrypt("текст для шифрования");
        System.out.println(str);
        str=test_gambl.doDecrypt(str);
        System.out.println(str);
        */

        //Кардано
        /*CardanoGrid testCardano=new CardanoGrid();
        char[][][] encr=testCardano.doEncrypt("строкаюяафыфаыфа ааа");
        for (int m=0;m<encr.length;m++) {
            for (int i = 0; i < encr[m].length; i++) {
                for (int j = 0; j < encr[m][i].length; j++)
                    System.out.print(encr[m][i][j]);
                System.out.println();
            }
            System.out.println();
        }
        String decr=testCardano.doDecrypt(encr);
        System.out.println("Расшифрованная строка: "+decr);
        */
    }
}

