package com.company;


import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Шифрование и дешифрование при помощи метода шифра Цезаря");
        System.out.println("Введите 1 для шифрования");
        System.out.println("Введите 2 для дешифрования");
        System.out.println("Введите число:");
        int menu = in.nextInt();
        in.nextLine();
        switch (menu) {
            case 1:
                String strToEncrypt;
                //считывание данных из файла
                System.out.println("Введите имя файла для шифрования: ");
                String fileName=in.nextLine();
                System.out.println("Вы ввели: "+fileName);
                try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    //чтение построчно
                    strToEncrypt = br.readLine();
                    //шифрование и дефишрования с помощью шифра Цезаря
                    Caesar testCaesar = new Caesar();
                    int shift;
                    System.out.println("Введите сдвиг");
                    shift= in.nextInt();
                    in.nextLine();
                    testCaesar.setShift(shift);
                    //String strToDecrypt="здесь была строка";
                    System.out.println("Исходная строка:" + strToEncrypt);

                    //шифрование
                    String encryptedString = testCaesar.doEncrypt(strToEncrypt);
                    System.out.println("Зашифрованная строка:" + encryptedString);

                    //Запись зашифрованной строки в файл1
                    System.out.println("Введите имя файла для записи результатов шифрования");
                    String newFileName=in.nextLine();
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName))) {
                        bw.write(encryptedString);
                    } catch (IOException ex) {

                        System.out.println(ex.getMessage());
                    }

                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }

                break;
            case 2:
                //расшифрование
                String strToDecrypt;
                Caesar testCaesar = new Caesar();
                //считывание данных из файла
                System.out.println("Введите имя файла для дешифрования: ");
                fileName=in.nextLine();
                System.out.println("Вы ввели: "+fileName);

                try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    //чтение построчно
                    strToDecrypt = br.readLine();
                    System.out.println("Исходная строка:" + strToDecrypt);

                    System.out.println("Введите сдвиг:");
                    int shift=in.nextInt();
                    in.nextLine();
                    testCaesar.setShift(shift);
                    //расшифрование
                    String decryptedString = testCaesar.doDecrypt(strToDecrypt);
                    System.out.println("Расшифрованная строка:" + decryptedString);
                    System.out.println("Введите имя файла для записи результатов дешифрования");
                    String newFileName=in.next();
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName))) {
                        bw.write(decryptedString);
                    } catch (IOException ex) {

                        System.out.println(ex.getMessage());
                    }
                }
                catch(IOException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            default:
                System.out.println("Нет такой опции");
                break;
        }




        /*

        ////////
        String strToEncrypt;
        //считывание данных из файла
        try(BufferedReader br = new BufferedReader(new FileReader("./input_text.txt")))
        {
            //чтение построчно
            strToEncrypt=br.readLine();

            //шифрование и дефишрования с помощью шифра Цезаря
            Caesar testCaesar=new Caesar();
            testCaesar.setShift(3);
            //String strToDecrypt="здесь была строка";
            System.out.println("Исходная строка:"+strToEncrypt);

            //шифрование
            String encryptedString=testCaesar.doEncrypt(strToEncrypt);
            System.out.println("Зашифрованная строка:"+encryptedString);

            //Запись зашифрованной строки в файл
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("./out_file.txt")))
            {
                bw.write(encryptedString);
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }


            //расшифрование

            String decryptedString=testCaesar.doDecrypt(encryptedString);
            System.out.println("Расшифрованная строка:"+decryptedString);

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }





        */
    }
}
