import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Questions {


    private static String currentCategory;
    private String category;
    private String question;
    private String answer;
    public static ArrayList<Questions> finalQuestionList;

    public static Questions currentQuestionObject;
    public static ArrayList<String> answerList;


    public static void fillList() {
        answerList = new ArrayList<String>();
        answerList.add("weiblich");
        answerList.add("alive");
        answerList.add("aktiv");
        answerList.add("haare");


    }

    public static String answerOneAfterTheOther() {

        String tempString;
        if (answerList.size() == 0) {
            fillList();
            tempString = answerList.get(0);

        }
        else {
            tempString = answerList.get(0);
        }
        answerList.remove(0);
        return tempString;
    }




    public Questions() {
    }

    public Questions(String Kategorie, String Frage, String answer) {
        this.category = Kategorie;
        this.question = Frage;
        this.answer = answer;

    }

    public static void createQuestions() {

        fillList();

        String category;
        String question;
        String answer;

        ArrayList<Questions> questionList = new ArrayList();


        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("jsonData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray questionsArray = (JSONArray) jsonObject.get("questions");
            for (Object objInArr : questionsArray) {
                JSONObject jsonQuestion = (JSONObject) objInArr;

                category = (String) jsonQuestion.get("Kategorie");
                question = (String) jsonQuestion.get("Frage");
                answer = (String) jsonQuestion.get("Antwort");

                Questions questions = new Questions(category, question, answer);
                questionList.add(questions);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int i = 0;

        finalQuestionList = (ArrayList<Questions>) questionList;
        currentQuestionObject = finalQuestionList.get(0);

         /*for (Object objInArr : questionList) {

            Questions questionPrint = questionList.get(i);
            System.out.println(questionPrint.category);
            System.out.println(questionPrint.question);
            i++;
        }

          */



    }

    public static ArrayList<Questions> getCurrentQuestion(String category) {
        return finalQuestionList;
    }

    public static void setFinalQuestionList(String category) {



        List<Questions> tempQuestions = Questions.getQuestionsArr()
                .stream()
                .filter(Questions -> !Questions.currentCategory.equals(category))
                .collect(Collectors.toList());
        finalQuestionList = (ArrayList<Questions>) tempQuestions;


        
    }

    /*
    public static void setPoliticianList(String category, boolean answer, String answerString) {


        if (answer) {
            List<politicians2> weiblichePolitiker = politicians2.getPoliticiansArr()
                    .stream()
                    .filter(politicians2 -> politicians2.getCategory(category).equals(answerString))
                    .collect(Collectors.toList());
            finalPoliticianList = (ArrayList<politicians2>) weiblichePolitiker;
        }
    }

     */
    public static ArrayList<Questions> getQuestionsArr() {
        return finalQuestionList;
    }

    public static int getQuestionsLeft() {
        int x = 0;

       return finalQuestionList.size();
    }

    /*public static int getProbability() {

        String alive;
        String name;
        String geschlecht;
        String aktiv;
        String haare;

        List<politicians2> tempList = politicians2.getPoliticiansArr();
        int limit = politicians2.getPoliticiansLeft();

        for (int i = 0; i < limit; i++) {
            politicians2 tempPolitician = tempList.get(i);
            alive = tempPolitician.getAlive();
            geschlecht = tempPolitician.getGeschlecht();
            aktiv = tempPolitician.getAktiv();
            haare = tempPolitician.getHaare();

            if ()

        }



        return 0;
    }

     */

    public static String getNewQuestion(int x) {

        String category;
        String question;
        String answer;



        //für kontrollierte fragenausgabe:
        // finalQuestionList.indexOf(Object x)

        Questions questionPrint = finalQuestionList.get(x);
        currentQuestionObject = questionPrint;
        currentCategory = questionPrint.category;
        System.out.println(questionPrint.question);
        finalQuestionList.remove(questionPrint);


        return questionPrint.question;
    }

    public static Questions getQuestionObject() {
        return currentQuestionObject;

    }

    public static String giveCategory() {
        return currentQuestionObject.category;
    }

    public static String giveQuestion() {
        return currentQuestionObject.question;
    }

    public static String giveAnswer() {
        return currentQuestionObject.answer;
    }


    public static String getQuestion(String category) {


        String question = "";
        String key = category;

        for (Object objInArr : finalQuestionList) {
            Questions questionPrint = finalQuestionList.iterator().next();
            if (questionPrint.category.equals(key)) {
                question = questionPrint.question.toString();
            }
        }
        return question;

        /*List<Questions> filteredList = List.stream()
                .filter(category -> Questions.finalQuestionList(0));
        }
        */
    }

    public static String getCategory(String category) {
        String answer = "";
        String key = category;

        for (Object objInArr : finalQuestionList) {
            Questions questionPrint = finalQuestionList.iterator().next();
            if (questionPrint.category.equals(key)) {
                answer = questionPrint.answer;
            }
        }
        return answer;
    }

    public static String getCategory(int x) {
        int i = 0;
        String question = "";


        while (i < x) {
            Questions questionPrint = finalQuestionList.iterator().next();
            question = questionPrint.category;
            i++;
        }


        /*for (Object objInArr : finalQuestionList) {
            Questions questionPrint = finalQuestionList.iterator().next();




            if (i == x) {
                question = questionPrint.category;;
            }
            i++;
        }

         */
        return question;
    }


}
