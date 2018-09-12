package com.company.algorythms;

import java.util.ArrayList;
import java.util.Random;

public class Gambling {
    final String alphabet="абвгдеёжзийклмнопрстуфхцчшщъыьэюя +-";
    //int alphabet_bin;
    String key;



    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void createKey() {

        this.key = key;
    }

    public Gambling(){

    }

    public String doEncrypt(String strToEncrypt) {
        StringBuffer encryptedString=new StringBuffer();
        for (int i=0;i<strToEncrypt.length();i++) {
            encryptedString.insert(i,(char)((int)key.charAt(i%key.length())^(int)strToEncrypt.charAt(i)));
        }
        return encryptedString.toString();
    }

    public String doDecrypt(String strToDecrypt) {
        StringBuffer decryptedString=new StringBuffer();
        for (int i=0;i<strToDecrypt.length();i++) {
            decryptedString.insert(i,(char)((int)key.charAt(i%key.length())^(int)strToDecrypt.charAt(i)));
        }
        return decryptedString.toString();
    }

    public ArrayList<String> strToBin(String str) {
        ArrayList<String> strArr = new ArrayList<String>();
        for (int i=0;i<str.length();i++)
            //System.out.println(Integer.parseInt(Integer.toString((int)str.charAt(i),2)));
            //System.out.println((int)str.charAt(i));
            strArr.add(Integer.toBinaryString((int)str.charAt(i)));

        return strArr;
    }

    public String binToStr(ArrayList ar) {
        String info="";
        for (int i=0;i<ar.size();i++)
            info = info + (char)Integer.parseInt(ar.get(i).toString(),2);

        //System.out.println("info :"+info);
        return info;
    }

    public ArrayList<String> strToHex(String str) {
        ArrayList<String> strArr = new ArrayList<String>();
        for (int i=0;i<str.length();i++)
            //System.out.println(Integer.parseInt(Integer.toString((int)str.charAt(i),2)));
            //System.out.println((int)str.charAt(i));
            strArr.add(Integer.toString((int)str.charAt(i),16));

        return strArr;
    }

    public void generateKey(String str){
        String nkey=new String();
        Random rnd = new Random(System.currentTimeMillis());
        for (int i=0;i<str.length();i++){
            nkey=nkey+alphabet.charAt(rnd.nextInt(alphabet.length()));
        }
        key=nkey;
    }

    public String hexToStr(ArrayList ar) {
        String info=" ";
        for (int i=0;i<ar.size();i++)
            info = info + (char)Integer.parseInt(ar.get(i).toString(),16);
        //System.out.println("info :"+info);
        return info;
    }
}
