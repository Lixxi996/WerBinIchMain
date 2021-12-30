import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class reader {

    public static String splitIt(String toSplit, int x) {
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

    public int getRows() throws IOException {

        int zeilenAnzahl = 0;
        FileReader fr = new FileReader("firstFile.txt");
        BufferedReader br = new BufferedReader(fr);

        String zeile = "";

        do
        {
            zeile = br.readLine();
            System.out.println(zeile);
            zeilenAnzahl++;
        }
        while (zeile != null);

        return zeilenAnzahl;
    }

    public static String readItRows(int zeilenAnzahl) throws IOException {

        FileReader fr = new FileReader("firstFile.txt");
        BufferedReader br = new BufferedReader(fr);

        String zeile = "";

        for (int i = 0; i < zeilenAnzahl; i++) {
            zeile = br.readLine();
        }

        return zeile;
    }

    public static String readIt() throws IOException {

        FileReader fr = new FileReader("firstFile.txt");
        BufferedReader br = new BufferedReader(fr);



        String zeile = "";


        zeile = br.readLine();



        br.close();


        return zeile;

        /*    public Person(String zeichenkette) {
        String[] arrString = zeichenkette.split(":", 5);
        this.first = arrString[0];
        this.last = arrString[1];
        this.mobile = arrString[2];
        this.age = Integer.parseInt(arrString[3]);
        this.note = arrString[4]; */


    }


}
