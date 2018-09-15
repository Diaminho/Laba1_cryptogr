package com.company.tools;

import com.company.algorythms.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

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
        while (menu != 4) {
            System.out.println("Шифрование и дешифрование при помощи решетки Кардано");
            System.out.println("Введите 1 для шифрования");
            System.out.println("Введите 2 для дешифрования");
            System.out.println("Введите 3 для генерации и просмотра решетки");
            System.out.println("Введите 4 для выхода");
            System.out.println("Введите число:");
            menu = in.nextInt();
            in.nextLine();
            switch (menu) {
                case 1:
                    CardanoGrid testCardano1 = new CardanoGrid();
                    System.out.println("Введите размер решетки:");
                    testCardano1.setSize(in.nextInt());
                    in.nextLine();
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
                    try (BufferedReader br1 = new BufferedReader(new FileReader(fileToEnc))) {
                        strToEncypt=br1.readLine();
                    }
                    catch (IOException ex) {
                        System.out.println(ex.getMessage());
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
                    testCard.getGridFromFile(fileName1);
                    testCard.printGrid();
                    //считывание данных из файла
                    System.out.println("Введите имя файла для дешифрования: ");
                    String fileName = in.nextLine();
                    //CardanoGrid testCard = new CardanoGrid();
                    //testCard.setSize(6);
                    String strToDecrypt="";
                    //System.out.println("Вы ввели: " + fileName);
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
                    //System.out.println(strToDecrypt);
                    testCard.getInfoFromFile(strToDecrypt);
                    testCard.printEncGrid();
                    String decText=testCard.doDecrypt(testCard.getEncryptedSquare());
                    System.out.println("Расшифрованный текст: "+decText);
                    //fileName = in.nextLine();
                    break;
                case 4:
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
                        System.out.println("Сгенерированный ключ: ");
                        testGambl.generateKey(strToEncrypt);
                        System.out.println(testGambl.getKey());
                        System.out.println("Введите имя файла для сохранения ключа: ");
                        String fileName1 = in.nextLine();
                        try (BufferedWriter bw1 = new BufferedWriter(new FileWriter(fileName1))) {
                            //чтение построчно
                            bw1.write(testGambl.getKey());
                        }
                        catch (IOException ex){
                            System.out.println(ex.getMessage());
                        }

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
