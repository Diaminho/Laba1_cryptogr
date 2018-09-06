package com.company;

public class PolybiusSquare {
   char[][] alphabet;

    public void setAlphabet() {
        String tmp_alphabet="абвгдеёжзийклмнопрстуфхцчшщъыьэюя +-,.";
        alphabet =new char[6][6];
        for (int i=0;i<alphabet.length;i++) {
            for (int j=0;j<alphabet[i].length;j++) {
                alphabet[i][j]=tmp_alphabet.charAt(i*alphabet.length+j);
            }
        }
    }

    public char[][] getAlphabet() {
        return alphabet;
    }

    public PolybiusSquare(){
        setAlphabet();
    }

    public String doEncrypt(String strToEncrypt) {
        StringBuffer encryptedString=new StringBuffer();
        for (int i=0;i<strToEncrypt.length();i++){
            //encryptedString.insert(i,shiftedAlphabet.charAt((alphabet.indexOf(strToEncrypt.charAt(i)))));
        }
        return encryptedString.toString();
    }
}
