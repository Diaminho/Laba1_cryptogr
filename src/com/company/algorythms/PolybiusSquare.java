package com.company.algorythms;

public class PolybiusSquare {
   char[][] alphabet;

    void setAlphabet() {
        String tmp_alphabet="абвгдеёжзийклмнопрстуфхцчшщъыьэюя +-";
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

    public void printAlphabet(){
        System.out.println("Алфавит для квадрата Полибия");
        for (int i=0;i<alphabet.length;i++) {
            for (int j=0;j<alphabet[i].length;j++) {
                System.out.print(alphabet[i][j]+" ");
            }
            System.out.println();
        }
    }

    int getLetter(char letter) {
        for (int i=0;i<alphabet.length;i++) {
            for (int j=0;j<alphabet[i].length;j++) {
                if (alphabet[i][j]==letter) {
                    return i*10+j;
                }
            }
        }
        return -1;
    }

    int[] getEncryptedAxis(int number) {
        int[] axis=new int[2];
        if ((int)number/10>4) {
            axis[0]=0;
            axis[1]=number%10;
            return axis;
        }

        else {
            axis[0]=(int)number/10+1;
            axis[1]=number%10;
            return axis;
        }
    }

    int[] getDecryptedAxis(int number) {
        int[] axis=new int[2];
        if ((int)number/10<1) {
            axis[0]=5;
            axis[1]=number%10;
            return axis;
        }

        else {
            axis[0]=(int)number/10-1;
            axis[1]=number%10;
            return axis;
        }
    }

    public PolybiusSquare(){
        setAlphabet();
    }

    public String doEncrypt(String strToEncrypt) {
        StringBuffer encryptedString=new StringBuffer();
        int number;
        int[] axis=new int[2];
        for (int i=0;i<strToEncrypt.length();i++){
            number=getLetter(strToEncrypt.charAt(i));
            axis=getEncryptedAxis(number);
            encryptedString.insert(i,alphabet[axis[0]][axis[1]]);
        }
        return encryptedString.toString();
    }

    public String doDecrypt(String strToDecrypt) {
        StringBuffer decryptedString=new StringBuffer();
        int number;
        int[] axis=new int[2];
        for (int i=0;i<strToDecrypt.length();i++){
            number=getLetter(strToDecrypt.charAt(i));
            axis=getDecryptedAxis(number);
            decryptedString.insert(i,alphabet[axis[0]][axis[1]]);
        }
        return decryptedString.toString();
    }
}
