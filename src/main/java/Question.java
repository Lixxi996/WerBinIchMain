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

public class Question {


    private static String currentCategory;
    private String category;
    private String question;
    private String answer;
    public static ArrayList<Question> finalQuestionList;

    public static Question currentQuestionObject;
    public static ArrayList<String> answerList;


    public static void fillList() {

        // Eine Methode, die den Fragen zugehörigen Kategorien in eine List speichert.
        // Die Liste wird in Politician.getProbability abgearbeitet und wird dazu verwendet,
        // eine geeignete Frage den übrigen Personen entsprechend zu berechnen. (Möglichst nahe an 50:50)

        answerList = new ArrayList<String>();
        answerList.add("weiblich");
        answerList.add("alive");
        answerList.add("aktiv");
        answerList.add("haare");
    }

    public static String answerOneAfterTheOther() {

        // Siehe auch Kommentar von fillList()
        // Die Methode arbeitet die Liste der Antworten ab
        // und gibt eine nach der anderen aus.
        // Wird ebenfalls in Politician.getProbability verwendet.

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

    public Question() {
        // Ich bin ein Konstruktor
    }

    public Question(String Kategorie, String Frage, String answer) {
        // Ich bin noch ein Konstruktor
        this.category = Kategorie;
        this.question = Frage;
        this.answer = answer;
    }

    public static void createQuestions() {

        // Diese Methode wird zu Beginn des Programms aufgerufen.
        // Es erstellt aus den Einträgen des JSON Files eine Arraylist aus den Objekten (Kategorie z.B. m/w, der Fragenstring und die Antwort z.B. "weiblich")


        fillList();
        // Da die Liste der Antworten sofort für die Fragenfindung verwendet wird, muss einmal die Liste befüllt werden.

        String category;
        String question;
        String answer;

        ArrayList<Question> questionList = new ArrayList();

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

                Question questions = new Question(category, question, answer);
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

        finalQuestionList = (ArrayList<Question>) questionList;
        currentQuestionObject = finalQuestionList.get(0);

    }

    public static ArrayList<Question> getCurrentQuestion(String category) {
        return finalQuestionList;
    }

    public static void setFinalQuestionList(String category) {

        List<Question> tempQuestions = Question.getQuestionsArr()
                .stream()
                .filter(Question -> !Question.currentCategory.equals(category))
                .collect(Collectors.toList());
        finalQuestionList = (ArrayList<Question>) tempQuestions;
    }

    public static ArrayList<Question> getQuestionsArr() {
        return finalQuestionList;
    }

    public static int getQuestionsLeft() {

       return finalQuestionList.size();
    }

    public static String getNewQuestion() {

        // Arbeitet die in createQuestions() erstellte Fragenliste ab.
        // Soll in weiterer Folge den Index der Frage übergeben bekommen,
        // der in Politician.getProbability() errechnet wird.

        Question questionPrint = finalQuestionList.get(0);
        currentQuestionObject = questionPrint;
        currentCategory = questionPrint.category;
        System.out.println(questionPrint.question);
        finalQuestionList.remove(questionPrint);

        return questionPrint.question;
    }

    public static Question getQuestionObject() {
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

}
