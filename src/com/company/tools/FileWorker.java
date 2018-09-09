package com.company.tools;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.*;
import java.util.Scanner;

public class FileWorker {

    public String ReadFile(String fileName){
        String info="";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            //чтение построчно
            info = br.readLine();

        }
        catch (IOException E) {
            System.out.println(E);
        }
        return info;
    }

    public void WriteToFile(String info, String fileName){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(info);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
