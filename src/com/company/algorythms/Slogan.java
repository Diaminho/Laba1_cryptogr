package com.company.algorythms;

import java.util.HashSet;
import java.util.Set;

public class Slogan {
    final String alphabet="абвгдеёжзийклмнопрстуфхцчшщъыьэюя +-";
    String shiftedAlphabet;
    String keyword;

    public String getShiftedAlphabet() {
        return shiftedAlphabet;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


    String delDuplicates(String str) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray())
        {
            if (!set.contains(c))
            {
                set.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void setShiftedAlphabet(){
        String newKeyword=delDuplicates(this.keyword);
        shiftedAlphabet=delDuplicates(newKeyword+alphabet);
    }

    public Slogan() {

    }

    public String doEncrypt(String strToEncrypt) {
        StringBuffer encryptedString=new StringBuffer();
        for (int i=0;i<strToEncrypt.length();i++){
            encryptedString.insert(i,shiftedAlphabet.charAt((alphabet.indexOf(strToEncrypt.charAt(i)))));
        }
        return encryptedString.toString();
    }

    public String doDecrypt(String strToDecrypt) {
        StringBuffer decryptedString=new StringBuffer();
        for (int i=0;i<strToDecrypt.length();i++){
            decryptedString.insert(i,alphabet.charAt((shiftedAlphabet.indexOf(strToDecrypt.charAt(i)))));
        }
        return decryptedString.toString();

    }
}
