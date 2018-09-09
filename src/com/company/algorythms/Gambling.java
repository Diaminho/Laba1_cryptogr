package com.company.algorythms;

public class Gambling {
    //final String alphabet="абвгдеёжзийклмнопрстуфхцчшщъыьэюя +-";
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
    };
}
