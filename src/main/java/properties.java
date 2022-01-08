import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class properties {

    /*FileReader fr = new FileReader("questions.txt");
    BufferedReader br = new BufferedReader(fr);

    public String attribut;
    public String question;

     */



    public static int getNumberOfQuestions() throws IOException {

        int zeilenAnzahl = 0;
        FileReader fr = new FileReader("questions.txt");
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


    /*public properties(String attribut, String question, int y) throws IOException {
        this.attribut = reader.splitIt(readItQuestions(y), 0);;
        this.question = reader.splitIt(readItQuestions(y), 1);
    }

    public properties (Object readIt) throws IOException {
        //this.attribut = reader.splitIt(readItQuestions(), 0);
        //this.question = reader.splitIt(readItQuestions(), 1);
    }

     */

    public static void propertiesQuestions() throws IOException {
        ArrayList<String> list = new ArrayList<String>();

        FileReader fr = new FileReader("questions.txt");
        BufferedReader br = new BufferedReader(fr);


        String line = br.readLine(); while (line != null)
        {
            list.add(line);
            line = br.readLine();
        }
        br.close();

        System.out.println("Using For Loop\n ");
        for (int i = 0; i < list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }
    public String getQustionEasy(int x) throws FileNotFoundException {
        FileReader fr = new FileReader("questions.txt");
        BufferedReader br = new BufferedReader(fr);



        return null;



    }

    public String getQuestion(String toSplit, String attribut) throws FileNotFoundException {
        String[] arrString = toSplit.split(",");
        // attribut ->


        switch(attribut){
            case "geschlecht":
                return arrString[0].toString();
            case "lebendig":
                return arrString[1].toString();
            case "aktiv":
                return arrString[2].toString();
            default:
                return null;
        }


    }

    public static String readItQuestions(int zeilenAnzahl) throws IOException {

        FileReader fr = new FileReader("questions.txt");
        BufferedReader br = new BufferedReader(fr);



        String zeile = "";

        for (int i = 0; i < zeilenAnzahl; i++) {
            zeile = br.readLine();
        }

        String[] arrString = zeile.split(",");

        switch (zeilenAnzahl) {
            case 0:
                return arrString[0];
            case 1:
                return arrString[1];
            default:
                return null;
        }

    }





}
