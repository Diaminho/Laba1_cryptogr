package com.company.algorythms;

public class Caesar implements ReplacementCode {
    int shift;
    final String alphabet="абвгдеёжзийклмнопрстуфхцчшщъыьэюя +-";
    //StringBuffer shiftedAlphabet=new StringBuffer();


    public String doEncrypt(String strToEncrypt) {
        StringBuffer encryptedString=new StringBuffer();
        for (int i=0;i<strToEncrypt.length();i++) {
            encryptedString.insert(i,alphabet.charAt((alphabet.indexOf(strToEncrypt.charAt(i))+shift)%alphabet.length()));
        }
        return encryptedString.toString();
    };
    public String doDecrypt(String strToDecrypt) {
        StringBuffer decryptedString=new StringBuffer();
        int tmp_ind;
        for (int i=0;i<strToDecrypt.length();i++) {
            if (alphabet.indexOf(strToDecrypt.charAt(i))-shift<0) {
                tmp_ind=alphabet.length()+alphabet.indexOf(strToDecrypt.charAt(i))-shift;
                System.out.println(tmp_ind);
            }
            else  {
                tmp_ind=alphabet.indexOf(strToDecrypt.charAt(i))-shift;
            }
            decryptedString.insert(i,alphabet.charAt((tmp_ind)));
        }
        return decryptedString.toString();
    };


    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public Caesar() {
        this.shift = 0;
    }

    public String getAlphabet() {
        return alphabet;
    }

}
