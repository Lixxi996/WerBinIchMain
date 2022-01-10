

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    //personarray[]
    //questionarray[]
    //
    public static String lastPolitician;

    public static boolean endOfGame() {

        int x = politicians2.getPoliticiansLeft();

        if (x == 1 || x == 0) {

            lastPolitician = politicians2.getLastPolitician();

            return false;

        }
        else {
            return true;
        }

    }


    public static void askQuestion(int x) throws IOException {
        System.out.println(reader.giveItAll(x,0));
        //questionarray[x] = null;
    }

    public static void main(String[] args) throws IOException {
        int i = 0;
        boolean isGameOn = true;
        String category = "";
        boolean answer;
        Scanner scanner = new Scanner(System.in);
        int input;
        String einString = "";
        int probability;



        politicians2.createPoliticians();
        Questions.createQuestions();


        System.out.println("************** UNSER MAINLOOP *******************");

        //aktuellster MainLoop
        while (isGameOn) {

            while (isGameOn) {

                System.out.println("Die Frage lautet:");
                probability = politicians2.getNewProbability();
                Questions.getNewQuestion();
                input = scanner.nextInt();

                if (input == 1) {
                    answer = true;

                }
                else {
                    answer = false;
                }
                politicians2.setPoliticianList(Questions.giveCategory(), answer, Questions.giveAnswer());
                i++;

                isGameOn = endOfGame();

            }
        }

        System.out.println("Deine Wahl ist auf " + lastPolitician + " gefallen.");

        System.out.println("***************** BIS HIERHER UND NICHT WEITER *********************");

        /*

        Questions question = new Questions();

        int questionsLeft = Questions.getQuestionsLeft();

        for (i = 0; i < questionsLeft; i++) {

            Questions.getNewQuestion(i);

        }

        System.out.println(Questions.getQuestionsLeft());



        System.out.println("New TRY");
        System.out.println(Questions.getQuestion("alive"));
        System.out.println(Questions.getQuestion(Questions.getCategory(0)));

        politicians2.setPoliticianList("alive", true, "alive");

        while (isGameOn) {
            for (i = 0; i < 10; i++) {
                System.out.println("Die Frage lautet: ");
                System.out.println(Questions.getQuestion(Questions.getCategory(i)));
                input = scanner.nextInt();
                einString = Questions.getCategory(Questions.getCategory(i));
                if (input == 1) {
                    answer = true;

                }
                else {
                    answer = false;
                }

                politicians2.setPoliticianList(Questions.getCategory(i), answer, einString);

                //politicians2.setPoliticianList();
                if (jsonReader.endOfGame()) {
                    isGameOn = false;
                    break;
                }
                else {
                    continue;
                }
            }
            break;
        }
        */

        //politicians2.setPoliticianList("geschlecht", "maennlich");
        //politicians2.setPoliticianList("alive", "dead");




        //int x = reader.getRows();
        //int y = reader.getCols();

        //jsonReader.jsonReader();
        //jsonReader.getQuestion("alive");
        /*System.out.println(jsonReader.getQuestion("aktiv"));
        System.out.println(jsonReader.getNumberOfQuestions());
        System.out.println(jsonReader.getNumberOfPoliticians());

         */



        /*
        while(isGameOn){

            for (i = 0; i < jsonReader.getNumberOfQuestions(); i++) {
                System.out.println("Die Frage lautet: ");
                System.out.println(jsonReader.getQuestion(jsonReader.getCategory(i)));
                input = scanner.nextInt();
                if (input == 1) {
                    answer = false;
                }
                else {
                    answer = true;
                }
                jsonReader.changeStatus(jsonReader.getCategory(i), answer);
                if (jsonReader.endOfGame()) {
                    isGameOn = false;
                    break;
                }
                else {
                    continue;
                }
            }
            break;

        }

        /*
        System.out.println(x);
        System.out.println(y);

        // Wenn wir eine Frage/Eigenschaft wollen
        for (i = 0; i < x; i++) {
            System.out.println(reader.giveItAll(i, 0));
        }
        // Wenn wir eine Person haben wollen
        for (i = 0; i < (y - 1); i++) {
            System.out.println(reader.giveItAll(0, i));
        }

        while (isGameOn) {
            askQuestion(3);
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            if (input == 1) {
                for (i = 0; i < (y - 1); i++) {
                    if (reader.giveItAll(1, i) != "ja"){
                        //personarray[i] = null;


                    }
                }



            }
        } */










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
        jsonReader.resetStatus();
        */

    }






}