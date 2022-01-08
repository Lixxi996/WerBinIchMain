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


public class politicians2 {

    private String alive;
    private String name;
    private String geschlecht;
    private String aktiv;
    private String haare;

    public static ArrayList<politicians2> finalPoliticianList;

    public politicians2(String name, String geschlecht, String alive, String aktiv, String haare) {
        this.name = name;
        this.geschlecht = geschlecht;
        this.alive = alive;
        this.aktiv = aktiv;
        this.haare = haare;
    }

    public String getCategory(String category) {



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

    public politicians2() {

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




        if (answer) {
            List<politicians2> weiblichePolitiker = politicians2.getPoliticansArr()
                    .stream()
                    .filter(politicians2 -> politicians2.getCategory(category).equals(answerString))
                    .collect(Collectors.toList());
            finalPoliticianList = (ArrayList<politicians2>) weiblichePolitiker;
        }

        else {
            List<politicians2> weiblichePolitiker =politicians2.getPoliticansArr()
                    .stream()
                    .filter(politicians2 -> !politicians2.getCategory(category).equals(category))
                    .collect(Collectors.toList());
            finalPoliticianList = (ArrayList<politicians2>) weiblichePolitiker;
        }

    }



    public static void createPoliticians() {

        String alive;
        String name;
        String geschlecht;
        String aktiv;
        String haare;

        ArrayList<politicians2> politiciansList = new ArrayList();

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

                politicians2 politician = new politicians2(name, geschlecht, alive, aktiv, haare);
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



        /*for (Object objInArr : politiciansList) {

            politicians2 politicianPrint = politiciansList.get(i);
            System.out.println(politicianPrint.name);
            System.out.println(politicianPrint.geschlecht);
            i++;
        }

         */


        /*Iterator iterator;
        Iterator<politicians2> iter
                = politiciansList.iterator();


        int i = 0;
        while(iter.hasNext()) {
            System.out.println(iter.next().toString());
            System.out.println(politiciansList.get(i).toString());

        }
        */


        /*
        for (int i = 0; i < politiciansList.size(); i++) {
            System.out.println(politiciansList<i>);
        }

         */

    }

    public static ArrayList<politicians2> getPoliticansArr() {

        return finalPoliticianList;
    }




}
