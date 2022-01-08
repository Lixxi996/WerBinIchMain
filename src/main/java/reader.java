import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class reader {

    public static String giveItAll(int x, int y) throws IOException {
        FileReader fr = new FileReader("firstFile.txt");
        BufferedReader br = new BufferedReader(fr);

        String newX = "";

        String newY = "";

        int zeilenAnzahl = 0;

        for (int i = 0; i <= x; i++) {
            newX = br.readLine();
            zeilenAnzahl++;
        }
        String[] arrString = newX.split(",");
        newY = arrString[y];
        return newY;
    }

    public static int getRows() throws IOException {

        int zeilenAnzahl = 0;
        FileReader fr = new FileReader("firstFile.txt");
        BufferedReader br = new BufferedReader(fr);

        String zeile = "";

        do
        {
            zeile = br.readLine();
            zeilenAnzahl++;
        }
        while (zeile != null);

        return zeilenAnzahl - 1;
    }

    public static int getCols() throws IOException {
        int spaltenAnzahl = 0;
        FileReader fr = new FileReader("firstFile.txt");
        BufferedReader br = new BufferedReader(fr);

        String zeile = br.readLine();
        String[] arrString = zeile.split(",");
        System.out.println(zeile.split(",").length);
        spaltenAnzahl = zeile.split(",").length;


        return spaltenAnzahl;
    }

    /*public static String splitIt(String toSplit, int x) {
        String[] arrString = toSplit.split(",");


        switch (x) {
            case 0:
                return arrString[0];
            case 1:
                return arrString[1];
            case 2:
                return arrString[2];
            case 3:
                return arrString[3];
            default:
                return null;
        }
    }

     */

    public static void readerToArray(int x) throws IOException {
        ArrayList<String> list = new ArrayList<String>();

        FileReader fr = new FileReader("firstFile.txt");
        BufferedReader br = new BufferedReader(fr);


        String line = br.readLine(); while (line != null)
        {
            list.add(line);
            line = br.readLine();
        }
        br.close();


        System.out.println(list.get(x));

    }

    /*public static int getRows() throws IOException {

        int zeilenAnzahl = 0;
        FileReader fr = new FileReader("firstFile.txt");
        BufferedReader br = new BufferedReader(fr);

        String zeile = "";

        do
        {
            zeile = br.readLine();
            zeilenAnzahl++;
        }
        while (zeile != null);

        return zeilenAnzahl;
    }

     */

    /*public static int getCols() throws IOException {
        int spaltenAnzahl = 0;
        FileReader fr = new FileReader("firstFile.txt");
        BufferedReader br = new BufferedReader(fr);

        String zeile = br.readLine();
        String[] arrString = zeile.split(",");

        do
        {
            String iwas = arrString[spaltenAnzahl];

            spaltenAnzahl++;
        }
        while (arrString[spaltenAnzahl] != null);

        return spaltenAnzahl;
    }

     */

    public static String readItRows(int zeilenAnzahl) throws IOException {

        FileReader fr = new FileReader("firstFile.txt");
        BufferedReader br = new BufferedReader(fr);

        String zeile = "";

        for (int i = 0; i < zeilenAnzahl; i++) {
            zeile = br.readLine();
        }

        return zeile;
    }




}
