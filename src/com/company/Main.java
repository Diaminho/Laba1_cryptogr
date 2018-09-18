package com.company;


import com.company.tools.Menu;

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
    }
}

