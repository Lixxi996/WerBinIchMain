

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        //reader.readIt() = new String;

        int i = 0;
        int zeilennummer = 0;
        Scanner scanner = new Scanner(System.in);

        Politicians PamRendiWagner = new Politicians(reader.readItRows(2) );
        //Properties RandomQ = new Properties(properties.readItQuestions());
        System.out.println(PamRendiWagner.gender);
        System.out.println(reader.readItRows(2));



        //reader.readerToArray();
        System.out.println();
        boolean isGameOn = true;



        while (isGameOn) {
            System.out.println(properties.readItQuestions(i));
            i++;


            if (i == 3){
                isGameOn = false;
            }


        }




        //loop, der eine zeile liest, und dann mit der zeile einen neuen politiker erstellt
        //und im besten fall diesen politiker in ein array reinhaut


        /*while(true) {

            reader.splitIt(reader.readIt(), i);
            i++;
            zeilennummer++;
            if (reader.splitIt(reader.readIt(), i) == null) {
                break;
            }

         */
    }

    // ist deine person männlich?
    // for each
    // if reader.readIt(i, j) == w;
    // boolean reader.readIt(xy) == false;



        /*String fileName = "";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            //process the line
            System.out.println(line);
        } */



        /*while(isGameOn){
            System.out.println(properties.getQ(count));
            count++;
        }
        */

}



