
import java.util.Scanner;

public class Main {

    public static String lastPolitician;

    public static boolean endOfGame() {

        // Wird am Ende vom Mainloop aufgerufen.
        // Wenn die Liste der Politiker nur 1 oder 0 Einträge hat,
        // ist das Spiel zu Ende und es wird der Name der letzten Person ausgegeben.

        int x = Politician.getPoliticiansLeft();

        if (x == 1) {
            lastPolitician = Politician.getLastPolitician();
            return false;
        }
        else if (x == 0){
            lastPolitician = "*Kein Treffer, sry*";
            return true;
        }
        else {
            return true;
        }
    }

    public static void main(String[] args) {

        boolean isGameOn = true;
        boolean answer;
        Scanner scanner = new Scanner(System.in);
        int input;
        int probability;

        Politician.createPoliticians();
        // Politiker werden aus dem File gelesen und als Objekte in der Arraylist gespeichert.
        Question.createQuestions();
        // Fragen werden aus dem File gelesen und als Objekte in der Arraylist gespeichert.

        System.out.println("************** UNSER MAINLOOP *******************");

        //unser MainLoop
        while (isGameOn) {
            System.out.println("Die Frage lautet:");

            Question.getNewQuestion(0);
            input = scanner.nextInt();

            if (input == 1) {
                answer = true;
                Question.removeCurrentQuestion();
            }
            else {
                answer = false;
            }
            Politician.setPoliticianList(Question.giveCategory(), answer, Question.giveAnswer());

            isGameOn = endOfGame();
        }

        System.out.println("Deine Wahl ist auf " + lastPolitician + " gefallen.");

        System.out.println("***************** BIS HIERHER UND NICHT WEITER *********************");
    }
}