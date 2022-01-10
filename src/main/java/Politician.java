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


public class Politician {

    private String alive;
    private String name;
    private String geschlecht;
    private String aktiv;
    private String haare;

    public static ArrayList<Politician> finalPoliticianList;
    public static String lastPolitician;
    public static ArrayList<String> categoryList;

    public static void fillList() {

        // Eine Methode, die den Politikern zugehörigen Kategorien in eine List speichert.
        // Die Liste wird in getProbability() abgearbeitet und wird dazu verwendet,
        // eine geeignete Frage den übrigen Personen entsprechend zu berechnen. (Möglichst nahe an 50:50)

        categoryList = new ArrayList<String>();
        categoryList.add("geschlecht");
        categoryList.add("alive");
        categoryList.add("aktiv");
        categoryList.add("haare");
    }

    public Politician(String name, String geschlecht, String alive, String aktiv, String haare) {

        // Ich bin ein Konstruktor

        this.name = name;
        this.geschlecht = geschlecht;
        this.alive = alive;
        this.aktiv = aktiv;
        this.haare = haare;
    }

    public static int getPoliticiansLeft() {

        return finalPoliticianList.size();
    }

    public static String getLastPolitician() {

        // wird am Ende des Spiels aufgerufen und gibt einfach den Namen der letzten Person aus

        lastPolitician = finalPoliticianList.get(0).name;
        return lastPolitician;
    }

    public String getCategory(String category) {

        // Wird verwendet um eine bestimmte Eigenschaft des aktuellen Objekts auszugeben

        switch (category) {
            case "name":
                return name;
            case "geschlecht":
                return geschlecht;
            case "alive":
                return alive;
            case "aktiv":
                return aktiv;
            case "haare":
                return haare;

            default:
                return haare;
        }
    }

    public Politician() {

        // Ich bin ein Konstruktor
    }

    public String getName() {
        return name;
    }

    public String getAktiv() {
        return aktiv;
    }

    public String getHaare() {
        return haare;
    }

    public String getAlive() {
        return alive;
    }

    public String getAnswer() {
        return geschlecht;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public static void setPoliticianList(String category, boolean answer, String answerString) {

        // Bearbeitet je nach Antwort die Liste der verbleibenden Politiker
        // Es wird anhand der Kategorie der aktuellen Frage nach Attributen gefiltert
        // und die Ergebnisse in eine neue Arraylist gespeichert

        if (answer) {
            List<Politician> weiblichePolitiker = Politician.getPoliticiansArr()
                    .stream()
                    .filter(Politician -> Politician.getCategory(category).equals(answerString))
                    .collect(Collectors.toList());
            finalPoliticianList = (ArrayList<Politician>) weiblichePolitiker;
        }

        else {
            List<Politician> weiblichePolitiker = Politician.getPoliticiansArr()
                    .stream()
                    .filter(Politician -> !Politician.getCategory(category).equals(answerString))
                    .collect(Collectors.toList());
            finalPoliticianList = (ArrayList<Politician>) weiblichePolitiker;
        }
    }

    public static String categoryOneAfterTheOther() {

        // Siehe auch Kommentar von fillList()
        // Die Methode arbeitet die Liste der Kategorien ab
        // und gibt eine nach der anderen aus.
        // Wird ebenfalls in Politician.getProbability verwendet.

        String tempString;
        if (categoryList.size() == 0) {
            fillList();
            tempString = categoryList.get(0);
        }
        else {
            tempString = categoryList.get(0);
        }
        categoryList.remove(0);
        return tempString;
    }

    public static int getNewProbability() {

        // tbd
        // Sollte am Ende die Frage berechnen, die am ehesten zu einem 50:50 Ergebnis führt

        double x;
        double y;

        ArrayList<Question> testList = Question.getQuestionsArr();
        Question tempQuestion = Question.currentQuestionObject;

        int toReturn = 0;
        double tempInt = 0;
        double bestProbability = 0;

        x = finalPoliticianList.size();

        for (int i = 0; i < finalPoliticianList.size(); i++) {

            String tempCategory = categoryOneAfterTheOther();
            String tempAnswer = Question.answerOneAfterTheOther();

            List<Politician> tempList = Politician.getPoliticiansArr()
                    .stream()
                    .filter(Politician -> Politician.getCategory(tempCategory).equals(tempAnswer))
                    .collect(Collectors.toList());
            y = tempList.size();

            if (tempList.size() == 0 || tempList.size() == tempList.size()) {
                continue;
            }
            else {
                tempQuestion = Question.currentQuestionObject;
            }

            if (y < x - y) {
                y = x - y;
            }

            tempInt = x / y;

            if (tempInt > bestProbability) {
                bestProbability = tempInt;

                toReturn = testList.indexOf(tempQuestion);
            }

        }

        return toReturn;
    }

    public static void createPoliticians() {

        // Diese Methode wird zu Beginn des Programms aufgerufen.
        // Es erstellt aus den Einträgen des JSON Files eine Arraylist aus den Objekten (Politikern) (name, geschlecht, ...)

        fillList();

        // Da die Liste der Antworten sofort für die Fragenfindung verwendet wird, muss einmal die Liste befüllt werden.

        String alive;
        String name;
        String geschlecht;
        String aktiv;
        String haare;

        ArrayList<Politician> politiciansList = new ArrayList();

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("jsonData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray politiciansArray = (JSONArray) jsonObject.get("politicians");
            for (Object objInArr : politiciansArray) {
                JSONObject jsonPolitician = (JSONObject) objInArr;
                name = (String) jsonPolitician.get("name");
                geschlecht = (String) jsonPolitician.get("geschlecht");
                alive = (String) jsonPolitician.get("alive");
                aktiv = (String) jsonPolitician.get("aktiv");
                haare = (String) jsonPolitician.get("haare");

                Politician politician = new Politician(name, geschlecht, alive, aktiv, haare);
                politiciansList.add(politician);

                }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int i = 0;

        finalPoliticianList = politiciansList;

    }

    public static ArrayList<Politician> getPoliticiansArr() {

        return finalPoliticianList;
    }

}
