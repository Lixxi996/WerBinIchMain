import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;


import org.json.simple.parser.ParseException;


public class jsonReader {



    public static boolean endOfGame() {
        int count = 0;
        boolean x = false;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("jsonData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray politiciansArray = (JSONArray) jsonObject.get("politicians");
            for (Object objInArr : politiciansArray) {
                JSONObject jsonPolitician = (JSONObject) objInArr;
                x = (boolean) jsonPolitician.get("inTheGame");
                if (x) {
                    count++;
                }
            }

            if (count == 1) {
                x = true;
            }
            else if (count == 0) {
                x = false;
            }
            else {
                x = false;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return x;
    }

    public static void resetStatus() {

        //noch nicht überprüft, sollte am Ende vom Game die "InTheGame" von den Politikern wieder auf True setzen

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("jsonData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray politiciansArray = (JSONArray) jsonObject.get("politicians");
            for (Object objInArr : politiciansArray) {
                JSONObject jsonPolitician = (JSONObject) objInArr;
                jsonPolitician.put("InTheGame", true);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



    public static void changeStatus(String category, boolean answer) {
        String categoryString = "";

        // noch nicht überprüft,sollte am nach Eingabe "InTheGame" eigenschaft der jeweiligen Politiker auf false setzen

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("jsonData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray politiciansArray = (JSONArray) jsonObject.get("politicians");
            for (Object objInArr : politiciansArray) {
                JSONObject jsonPolitician = (JSONObject) objInArr;
                categoryString = (String) jsonPolitician.get(category);


                if (answer && category.equals(categoryString)) {
                    jsonPolitician.replace("inTheGame", true, false);



                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String getCategory(int category) {
        String categoryToReturn = "";
        String question = "";
        String categoryQuestion = "";
        int count = 0;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("jsonQuestions.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray questionArray = (JSONArray) jsonObject.get("questions");
            for (Object objInArr : questionArray) {

                JSONObject jsonQuestion = (JSONObject) objInArr;
                question = (String) jsonQuestion.get("Frage");
                categoryQuestion = (String) jsonQuestion.get("Kategorie");

                // if(grades[i].equals("IG"))
                if (count == category) {
                    categoryToReturn = (String) jsonQuestion.get("Kategorie");
                    break;
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return categoryToReturn;
    }

    public static String getQuestion(String category) throws FileNotFoundException {
        String question = "";
        String categoryQuestion = "";
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("jsonQuestions.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray questionArray = (JSONArray) jsonObject.get("questions");
            for (Object objInArr : questionArray) {
                JSONObject jsonQuestion = (JSONObject) objInArr;
                question = (String) jsonQuestion.get("Frage");
                categoryQuestion = (String) jsonQuestion.get("Kategorie");

                // if(grades[i].equals("IG"))
                if (category.equals(categoryQuestion)) {
                    question = (String) jsonQuestion.get("Frage");
                    break;

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return question;
    }

    public static void jsonReader() {

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("jsonData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray namearr = (JSONArray) jsonObject.get("politicians");
            for (Object objInArr : namearr) {
                JSONObject jsonPolitiker = (JSONObject) objInArr;
                System.out.println(jsonPolitiker.get("name"));
                System.out.println(jsonPolitiker.get("geschlecht"));
                System.out.println(jsonPolitiker.get("alive"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static int getNumberOfQuestions() {
        int count = 0;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("jsonQuestions.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray questionArray = (JSONArray) jsonObject.get("questions");
            for (Object objInArr : questionArray) {
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int getNumberOfPoliticians() {
        int count = 0;
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("jsonData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray questionArray = (JSONArray) jsonObject.get("politicians");
            for (Object objInArr : questionArray) {
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return count;
    }

}
