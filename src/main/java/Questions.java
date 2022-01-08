import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Questions {


    private String category;
    private String question;
    private String answer;
    public static Iterable<Questions> finalQuestionList;



    public Questions() {
    }

    public Questions(String Kategorie, String Frage, String answer) {
        this.category = Kategorie;
        this.question = Frage;
        this.answer = answer;

    }

    public static void createQuestions() {

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

        finalQuestionList = questionList;

        for (Object objInArr : questionList) {

            Questions questionPrint = questionList.get(i);
            System.out.println(questionPrint.category);
            System.out.println(questionPrint.question);
            i++;
        }



    }

    public static void getProbability() {

        String category;

        //ArrayList<politicians2> politiciansList

        for (Object objInArr : finalQuestionList) {
            Questions questionPrint = finalQuestionList.iterator().next();
            category = questionPrint.category;

            for (Object obj2InArr : politicians2.getPoliticansArr()) {

            }


        }

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
