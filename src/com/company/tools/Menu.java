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
            Validator validator=new Validator();
            switch (menu) {
                case 1:
                    String strToEncrypt="";
                    //считывание данных из файла
                    System.out.println("Введите имя файла для шифрования: ");
                    String fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);
                    String tmpStr="";
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        while((tmpStr =br.readLine())!=null) {
                            strToEncrypt+= tmpStr;
                        }
                        //strToEncrypt = br.readLine();
                        //шифрование и дефишрования с помощью шифра Цезаря
                        Caesar testCaesar = new Caesar();
                        if (!validator.validateText(strToEncrypt,testCaesar.getAlphabet())) {
                            System.out.println("Исходная строка: "+strToEncrypt);
                            System.out.println("Используйте символы алфавита");
                            System.out.println(testCaesar.getAlphabet());
                            break;
                        }
                        //int shift=-1;
                        testCaesar.setShift(-1);
                        System.out.println("Введите сдвиг");
                        while (!validator.validateShift(testCaesar.getAlphabet(),testCaesar.getShift())) {
                            System.out.println("Сдвиг должен быть положительным целым числом");
                            testCaesar.setShift(in.nextInt());
                            in.nextLine();
                        }
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
                    String strToDecrypt="";
                    Caesar testCaesar = new Caesar();
                    //считывание данных из файла
                    System.out.println("Введите имя файла для дешифрования: ");
                    fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);
                   tmpStr="";
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        while((tmpStr =br.readLine())!=null) {
                            strToDecrypt+= tmpStr;
                        }
                        //strToDecrypt = br.readLine();
                        System.out.println("Исходная строка:" + strToDecrypt);
                        if (!validator.validateText(strToDecrypt,testCaesar.getAlphabet())) {
                            //System.out.println("Исходная строка: "+strToEncrypt);
                            System.out.println("Используйте символы алфавита");
                            System.out.println(testCaesar.getAlphabet());
                            break;
                        }
                        testCaesar.setShift(-1);
                        System.out.println("Введите сдвиг");
                        while (!validator.validateShift(testCaesar.getAlphabet(),testCaesar.getShift())) {
                            System.out.println("Сдвиг должен быть положительным целым числом");
                            testCaesar.setShift(in.nextInt());
                            in.nextLine();
                        }
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
        Validator validator=new Validator();
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
                    String strToEncrypt="";
                    //считывание данных из файла
                    System.out.println("Введите имя файла для шифрования: ");
                    String fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);
                    String tmpStr="";
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        while((tmpStr =br.readLine())!=null) {
                            strToEncrypt+= tmpStr;
                        }
                        //strToEncrypt = br.readLine();
                        Slogan testSlogan = new Slogan();
                        if (!validator.validateText(strToEncrypt,testSlogan.getAlphabet())) {
                            System.out.println("Исходная строка: "+strToEncrypt);
                            System.out.println("Используйте символы алфавита");
                            System.out.println(testSlogan.getAlphabet());
                            break;
                        }

                        System.out.println("Введите кодовое слово для шифрования (слоган): ");
                        testSlogan.setKeyword(in.nextLine());
                        while (!validator.validateText(testSlogan.getKeyword(),testSlogan.getAlphabet())) {
                            //System.out.println("Исходная строка: "+strToEncrypt);
                            System.out.println("Используйте символы алфавита");
                            testSlogan.setKeyword(in.nextLine());
                            break;
                        }
                        testSlogan.setShiftedAlphabet();
                        //System.out.println("новый алфавит: "+testSlogan.getShiftedAlphabet());
                        System.out.println("Исходная строка:" + strToEncrypt);
                        if (!validator.validateText(strToEncrypt,testSlogan.getAlphabet())) {
                            //System.out.println("Исходная строка: "+strToEncrypt);
                            System.out.println("Используйте символы алфавита");
                            System.out.println(testSlogan.getAlphabet());
                            break;
                        }
                        String encryptedString=testSlogan.doEncrypt(strToEncrypt);
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
                    String strToDecrypt="";
                    Slogan testSlogan = new Slogan();
                    //считывание данных из файла
                    System.out.println("Введите имя файла для дешифрования: ");
                    fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);
                    tmpStr="";
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        while((tmpStr =br.readLine())!=null) {
                            strToDecrypt+= tmpStr;
                        }
                        //strToDecrypt = br.readLine();
                        System.out.println("Исходная строка:" + strToDecrypt);
                        if (!validator.validateText(strToDecrypt,testSlogan.getAlphabet())) {
                            //System.out.println("Исходная строка: "+strToEncrypt);
                            System.out.println("Используйте символы алфавита");
                            System.out.println(testSlogan.getAlphabet());
                            break;
                        }
                        System.out.println("Введите кодовое слово(слоган):");
                        testSlogan.setKeyword(in.nextLine());
                        while (!validator.validateText(testSlogan.getKeyword(),testSlogan.getAlphabet())) {
                            //System.out.println("Исходная строка: "+strToEncrypt);
                            System.out.println("Используйте символы алфавита");
                            testSlogan.setKeyword(in.nextLine());
                            break;
                        }
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
        Validator validator=new Validator();
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
                    String strToEncrypt="";

                    //считывание данных из файла
                    System.out.println("Введите имя файла для шифрования: ");
                    String fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);
                    String tmpStr="";
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        while((tmpStr =br.readLine())!=null) {
                            strToEncrypt+= tmpStr;
                        }
                        //strToEncrypt = br.readLine();
                        PolybiusSquare testPoly=new PolybiusSquare();
                        testPoly.printAlphabet();
                        System.out.println("Исходная строка: "+strToEncrypt);
                        if (!validator.validateText(strToEncrypt,testPoly.getTmp_alphabet())) {
                            //System.out.println("Исходная строка: "+strToEncrypt);
                            System.out.println("Используйте символы алфавита");
                            System.out.println(testPoly.getTmp_alphabet());
                            break;
                        }
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
                    String strToDecrypt="";
                    PolybiusSquare testPoly=new PolybiusSquare();
                    //считывание данных из файла
                    System.out.println("Введите имя файла для дешифрования: ");
                    fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);
                    tmpStr="";
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        while((tmpStr =br.readLine())!=null) {
                            strToDecrypt+= tmpStr;
                        }
                        //strToDecrypt = br.readLine();
                        System.out.println("Исходная строка:" + strToDecrypt);
                        if (!validator.validateText(strToDecrypt,testPoly.getTmp_alphabet())) {
                            //System.out.println("Исходная строка: "+strToEncrypt);
                            System.out.println("Используйте символы алфавита");
                            System.out.println(testPoly.getTmp_alphabet());
                            break;
                        }
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
        int menu = 0;
        Validator validator=new Validator();
        while (menu != 3) {
            System.out.println("Шифрование и дешифрование при помощи решетки Кардано");
            System.out.println("Введите 1 для шифрования");
            System.out.println("Введите 2 для дешифрования");
            System.out.println("Введите 3 для выхода");
            System.out.println("Введите число:");
            menu = in.nextInt();
            in.nextLine();
            switch (menu) {
                case 1:
                    CardanoGrid testCardano1 = new CardanoGrid();
                    testCardano1.setSize(-1);
                    System.out.println("Введите размер решетки:");
                    while (!validator.validateGridSize(testCardano1.getSize())){
                        System.out.println("Размер решетки должен положительным и четным");
                        testCardano1.setSize(in.nextInt());
                        in.nextLine();
                    }
                    testCardano1.generateGrid1();
                    int[] gridBin=testCardano1.getGridBin();
                    int[] gridDec=testCardano1.binToDec(gridBin);
                    System.out.println("Была сгенерирована следующая сетка:");
                    testCardano1.printGrid();
                    /*for (int i=0;i<testCardano1.getGrid().length;i++){
                        System.out.print(gridDec[i]+" ");
                    }*/
                    //System.out.println();

                    System.out.println("Введите имя файла для сохранения сгенерированной решетки");
                    String FileName = in.nextLine();
                    for (int i=0;i<testCardano1.getGrid().length;i++) {
                        for (int j=0;j<testCardano1.getGrid()[i].length;j++){
                            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileName))) {
                                for (int k = 0; k < gridBin.length; k++) {
                                    bw.write(String.valueOf(gridBin[k]));
                                    bw.newLine();
                                }
                                bw.flush();
                                //bw.close();
                            }
                            catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    }

                    testCardano1.setGridBin(gridBin);
                    System.out.println("Введите имя файла с текстом для шифрования:");
                    String fileToEnc=in.nextLine();
                    String strToEncypt="";
                    String tmpStr;
                    try (BufferedReader br1 = new BufferedReader(new FileReader(fileToEnc))) {
                        while ((tmpStr=br1.readLine())!=null) {
                            strToEncypt +=tmpStr;
                        }
                    }
                    catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    if(!validator.validateText(strToEncypt,testCardano1.getAlphabet())){
                        System.out.println("Используйте символы алфавита");
                        System.out.println(testCardano1.getAlphabet());
                        break;
                    }
                    char[][][] encr = testCardano1.doEncrypt(strToEncypt);
                    testCardano1.printEncGrid();
                    System.out.println("Введите имя файла для сохранения зашифрованной решетки");
                    String FileName2 = in.next();
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileName2))) {
                        for (int i=0;i<encr.length;i++){
                            for (int j=0;j<encr[i].length;j++){
                                for (int k=0;k<encr[i][j].length;k++){
                                    bw.write(encr[i][j][k]);
                                    bw.newLine();
                                }
                                    //System.out.println();
                            }
                                //System.out.println();
                        }
                    }
                    catch (IOException ex){
                        System.out.println(ex.getMessage());
                    }

                    break;
                case 2:
                    //расшифрование

                    System.out.println("Введите имя файла с решеткой: ");
                    String fileName1 = in.nextLine();
                    CardanoGrid testCard = new CardanoGrid();
                    if (testCard.getGridFromFile(fileName1)!=0) {
                        break;
                    }
                    testCard.printGrid();
                    //считывание данных из файла
                    System.out.println("Введите имя файла для дешифрования: ");
                    String fileName = in.nextLine();
                    String strToDecrypt="";
                    String str_tmp="";
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        //str_tmp=br.readLine();
                        while((str_tmp = br.readLine()) != null){
                            strToDecrypt+= str_tmp;
                            //System.out.println(str_tmp);
                        }
                    }
                    catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    if (!validator.validateText(strToDecrypt,testCard.getAlphabet())){
                        System.out.println("Используйте символы алфавита");
                        System.out.println(testCard.getAlphabet());
                        break;
                    }
                    testCard.getInfoFromFile(strToDecrypt);
                    if (!validator.validateEncodedGrid(testCard.getEncryptedSquare(),testCard.getSize(),testCard.getAlphabet())){
                        break;
                    }
                    testCard.printEncGrid();
                    String decText=testCard.doDecrypt(testCard.getEncryptedSquare());
                    System.out.println("Расшифрованный текст: "+decText);
                    //fileName = in.nextLine();
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

    public static void GamblingMenu(Scanner in){
        int menu = 0;
        Validator validator=new Validator();
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
                    String strToEncrypt="";
                    //считывание данных из файла
                    System.out.println("Введите имя файла для шифрования: ");
                    String fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);
                    String tmpStr="";
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        while((tmpStr =br.readLine())!=null) {
                            strToEncrypt+= tmpStr;
                        }
                        Gambling testGambl=new Gambling();

                        System.out.println("Исходная строка: "+strToEncrypt);
                        System.out.println("Сгенерированный ключ: ");
                        testGambl.generateKey(strToEncrypt);
                        System.out.println(testGambl.getKey());
                        System.out.println("Вы хотите изменить ключ? (1-да, 2-нет)");
                        int mod=in.nextInt();
                        in.nextLine();
                        switch (mod) {
                            case 1:
                                System.out.println("Введите новый ключ");
                                String keyInput = in.nextLine();
                                while (keyInput.length()>strToEncrypt.length()){
                                    System.out.println("Длина ключа превышает длину исходной строки");
                                    keyInput=in.nextLine();
                                }
                                System.out.println("Новый ключ: "+keyInput);
                                testGambl.setKey(keyInput);
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("Введите 1 или 2");
                                break;
                        }
                        System.out.println("Введите имя файла для сохранения ключа: ");
                        String fileName1 = in.nextLine();
                        try (BufferedWriter bw1 = new BufferedWriter(new FileWriter(fileName1))) {
                            //чтение построчно
                            bw1.write(testGambl.getKey());
                        }
                        catch (IOException ex){
                            System.out.println(ex.getMessage());
                        }

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
                    String strToDecrypt="";
                    //считывание данных из файла
                    System.out.println("Введите имя файла для дешифрования: ");
                    fileName = in.nextLine();
                    System.out.println("Вы ввели: " + fileName);
                    tmpStr="";
                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        //чтение построчно
                        while((tmpStr =br.readLine())!=null) {
                            strToDecrypt+= tmpStr;
                        }
                        System.out.println("Исходная строка:" + strToDecrypt);
                        System.out.println("Введите имя файла ключа для дешифрования: ");
                        fileName = in.nextLine();
                        Gambling testGambl=new Gambling();
                        String key="";
                        try (BufferedReader br1 = new BufferedReader(new FileReader(fileName))) {
                            //чтение построчно
                            key = br1.readLine();
                        }
                        catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        testGambl.setKey(key);
                        System.out.println("Ключ: "+key);
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
