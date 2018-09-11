package com.company.tools;

import com.company.algorythms.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void CaesarMenu(Scanner in) {
        int menu = 0;
        while (menu != 3) {
            System.out.println("Шифрование и дешифрование при помощи метода шифра Цезаря");
            System.out.println("Введите 1 для шифрования");
            System.out.println("Введите 2 для дешифрования");
            System.out.println("Введите 3 для выхода");
            System.out.println("Введите число:");
            menu = in.nextInt();
            in.nextLine();
            switch (menu) {
                case 1:
                    String strToEncrypt;
                    //считывание данных из файла
                    System.out.println("Введите имя файла для шифрования: ");
                    String fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        strToEncrypt = br.readLine();
                        //шифрование и дефишрования с помощью шифра Цезаря
                        Caesar testCaesar = new Caesar();
                        int shift;
                        System.out.println("Введите сдвиг");
                        shift = in.nextInt();
                        in.nextLine();
                        testCaesar.setShift(shift);
                        //String strToDecrypt="здесь была строка";
                        System.out.println("Исходная строка:" + strToEncrypt);

                        //шифрование
                        String encryptedString = testCaesar.doEncrypt(strToEncrypt);
                        System.out.println("Зашифрованная строка:" + encryptedString);

                        //Запись зашифрованной строки в файл1
                        System.out.println("Введите имя файла для записи результатов шифрования");
                        String newFileName = in.nextLine();
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName))) {
                            bw.write(encryptedString);
                        } catch (IOException ex) {

                            System.out.println(ex.getMessage());
                        }

                    } catch (IOException ex) {

                        System.out.println(ex.getMessage());
                    }

                    break;
                case 2:
                    //расшифрование
                    String strToDecrypt;
                    Caesar testCaesar = new Caesar();
                    //считывание данных из файла
                    System.out.println("Введите имя файла для дешифрования: ");
                    fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);

                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        strToDecrypt = br.readLine();
                        System.out.println("Исходная строка:" + strToDecrypt);

                        System.out.println("Введите сдвиг:");
                        int shift = in.nextInt();
                        in.nextLine();
                        testCaesar.setShift(shift);
                        //расшифрование
                        String decryptedString = testCaesar.doDecrypt(strToDecrypt);
                        System.out.println("Расшифрованная строка:" + decryptedString);
                        System.out.println("Введите имя файла для записи результатов дешифрования");
                        String newFileName = in.next();
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName))) {
                            bw.write(decryptedString);
                        } catch (IOException ex) {

                            System.out.println(ex.getMessage());
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Нет такой опции");
                    break;
            }
        }
    }

    public static void SloganMenu(Scanner in) {
        int menu = 0;
        while (menu != 3) {
            System.out.println("Шифрование и дешифрование при помощи слогана");
            System.out.println("Введите 1 для шифрования");
            System.out.println("Введите 2 для дешифрования");
            System.out.println("Введите 3 для выхода");
            System.out.println("Введите число:");
            menu = in.nextInt();
            in.nextLine();
            switch (menu) {
                case 1:
                    String strToEncrypt;
                    //считывание данных из файла
                    System.out.println("Введите имя файла для шифрования: ");
                    String fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        strToEncrypt = br.readLine();
                        Slogan testSlogan = new Slogan();
                        System.out.println("Введите кодовое слово для шифрования (слоган): ");
                        String slogan=in.nextLine();
                        testSlogan.setKeyword(slogan);
                        testSlogan.setShiftedAlphabet();
                        //System.out.println("новый алфавит: "+testSlogan.getShiftedAlphabet());
                        String encryptedString=testSlogan.doEncrypt(strToEncrypt);
                        System.out.println("Исходная строка:" + strToEncrypt);
                        System.out.println("Зашифрованная строка:"+encryptedString);
                        //Запись зашифрованной строки в файл1
                        System.out.println("Введите имя файла для записи результатов шифрования");
                        String newFileName = in.nextLine();
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName))) {
                            bw.write(encryptedString);
                        } catch (IOException ex) {

                            System.out.println(ex.getMessage());
                        }

                    } catch (IOException ex) {

                        System.out.println(ex.getMessage());
                    }

                    break;
                case 2:
                    //расшифрование
                    String strToDecrypt;
                    Slogan testSlogan = new Slogan();
                    //считывание данных из файла
                    System.out.println("Введите имя файла для дешифрования: ");
                    fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);

                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        strToDecrypt = br.readLine();
                        System.out.println("Исходная строка:" + strToDecrypt);

                        System.out.println("Введите кодовое слово(слоган):");
                        String slogan = in.nextLine();
                        testSlogan.setKeyword(slogan);
                        testSlogan.setShiftedAlphabet();
                        //расшифрование
                        String decryptedString=testSlogan.doDecrypt(strToDecrypt);
                        System.out.println("Расшифрованное слово:"+decryptedString);
                        System.out.println("Введите имя файла для записи результатов дешифрования");
                        String newFileName = in.next();
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName))) {
                            bw.write(decryptedString);
                        } catch (IOException ex) {

                            System.out.println(ex.getMessage());
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Нет такой опции");
                    break;
            }
        }
    }

    public static void PolybiusMenu(Scanner in) {
        int menu = 0;
        while (menu != 3) {
            System.out.println("Шифрование и дешифрование при помощи квадрата Полибия");
            System.out.println("Введите 1 для шифрования");
            System.out.println("Введите 2 для дешифрования");
            System.out.println("Введите 3 для выхода");
            System.out.println("Введите число:");
            menu = in.nextInt();
            in.nextLine();
            switch (menu) {
                case 1:
                    String strToEncrypt;
                    //считывание данных из файла
                    System.out.println("Введите имя файла для шифрования: ");
                    String fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        strToEncrypt = br.readLine();
                        PolybiusSquare testPoly=new PolybiusSquare();
                        testPoly.printAlphabet();
                        System.out.println("Исходная строка: "+strToEncrypt);
                        String encryptedString=testPoly.doEncrypt(strToEncrypt);
                        System.out.println("Зашифрованная строка: "+encryptedString);
                      //Запись зашифрованной строки в файл1
                        System.out.println("Введите имя файла для записи результатов шифрования");
                        String newFileName = in.nextLine();
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName))) {
                            bw.write(encryptedString);
                        } catch (IOException ex) {

                            System.out.println(ex.getMessage());
                        }

                    } catch (IOException ex) {

                        System.out.println(ex.getMessage());
                    }

                    break;
                case 2:
                    //расшифрование
                    String strToDecrypt;
                    PolybiusSquare testPoly=new PolybiusSquare();
                    //считывание данных из файла
                    System.out.println("Введите имя файла для дешифрования: ");
                    fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);

                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        strToDecrypt = br.readLine();
                        System.out.println("Исходная строка:" + strToDecrypt);
                        //расшифрование
                        String decryptedString=testPoly.doDecrypt(strToDecrypt);
                        System.out.println("Расшифрованная строка: "+decryptedString);
                        System.out.println("Введите имя файла для записи результатов дешифрования");
                        String newFileName = in.next();
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName))) {
                            bw.write(decryptedString);
                        } catch (IOException ex) {

                            System.out.println(ex.getMessage());
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Нет такой опции");
                    break;
            }
        }

    }


    public static void CardanoMenu(Scanner in) {
        CardanoGrid testCardano=new CardanoGrid();
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
    }

    public static void GamblingMenu(Scanner in){
         int menu = 0;
        while (menu != 5) {
            System.out.println("Шифрование и дешифрование при помощи однократного гаммирования");
            System.out.println("Введите 1 для шифрования");
            System.out.println("Введите 2 для дешифрования");
            System.out.println("Введите 3 для просмотра информации в двоичном виде");
            System.out.println("Введите 4 для просмотра информации в шестнадацатеричном виде");
            System.out.println("Введите 5 для выхода");
            System.out.println("Введите число:");
            menu = in.nextInt();
            in.nextLine();
            switch (menu) {
                case 1:
                    String strToEncrypt;
                    //считывание данных из файла
                    System.out.println("Введите имя файла для шифрования: ");
                    String fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        strToEncrypt = br.readLine();
                        Gambling testGambl=new Gambling();
                        System.out.println("Введите ключ: ");
                        testGambl.setKey(in.nextLine());
                        System.out.println("Исходная строка: "+strToEncrypt);
                        String encryptedString=testGambl.doEncrypt(strToEncrypt);
                        System.out.println("Зашифрованная строка: "+encryptedString);
                        //Запись зашифрованной строки в файл1
                        System.out.println("Введите имя файла для записи результатов шифрования");
                        String newFileName = in.nextLine();
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName))) {
                            bw.write(encryptedString);
                        } catch (IOException ex) {

                            System.out.println(ex.getMessage());
                        }

                    } catch (IOException ex) {

                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    //расшифрование
                    String strToDecrypt;
                    //считывание данных из файла
                    System.out.println("Введите имя файла для дешифрования: ");
                    fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);

                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        strToDecrypt = br.readLine();
                        System.out.println("Исходная строка:" + strToDecrypt);
                        System.out.println("Введите ключ для дешифрования: ");
                        Gambling testGambl=new Gambling();
                        testGambl.setKey(in.nextLine());
                        //расшифрование
                        String decryptedString=testGambl.doDecrypt(strToDecrypt);
                        System.out.println("Расшифрованная строка: "+decryptedString);
                        System.out.println("Введите имя файла для записи результатов дешифрования");
                        String newFileName = in.next();
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName))) {
                            bw.write(decryptedString);
                        } catch (IOException ex) {

                            System.out.println(ex.getMessage());
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Введите имя файла для перевода в двоичную систему: ");
                    fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        String strToBin = br.readLine();
                        System.out.println("Исходная строка:" + strToBin);
                        Gambling testGambl=new Gambling();
                        ArrayList bin=testGambl.strToBin(strToBin);
                        System.out.println("В двоичной системе: "+bin);
                        System.out.println("Исходный текст: "+testGambl.binToStr(bin));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Введите имя файла для перевода в шестнадцатеричную систему: ");
                    fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);

                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        String strToBin = br.readLine();
                        System.out.println("Исходная строка:" + strToBin);
                        Gambling testGambl=new Gambling();
                        ArrayList hex=testGambl.strToHex(strToBin);
                        System.out.println("В шестнадцатеричной системе: "+hex);
                        System.out.println("Исходный текст: "+testGambl.hexToStr(hex));
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Нет такой опции");
                    break;
            }
        }
    }

}
