import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Politicians {

    public String name;
    public String gender;
    public int age;
    public String hairColour;
    public String glasses;
    public String party; //partyparty
    public String scandals;
    public String stillLiving;
    public String hoechstesAmt;
    public String Bildung;
    public String Bundeslaender;
    public String stillMoving;

    /*public Politicians (Object readIt) throws IOException {
        this.name = reader.splitIt(reader.readItRows(1), 0);
        this.gender = reader.splitIt(reader.readItRows(1), 1);
        this.stillLiving = reader.splitIt(reader.readItRows(1), 2);
        this.stillMoving = reader.splitIt(reader.readItRows(1), 3);

    }

     */

    // Konstruktor (rechtsklick, generate)

    public Politicians(String gender, int age, String hairColour, String glasses, String party, String scandals, String stillLiving, String hoechstesAmt, String bildung, String bundeslaender, String stillMoving) {
        this.gender = gender;
        this.age = age;
        this.hairColour = hairColour;
        this.glasses = glasses;
        this.party = party;
        this.scandals = scandals;
        this.stillLiving = stillLiving;
        this.hoechstesAmt = hoechstesAmt;
        Bildung = bildung;
        Bundeslaender = bundeslaender;
        this.stillMoving = stillMoving;
    }

    // getter (rechtsklick, generate)

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getHairColour() {
        return hairColour;
    }

    public String getGlasses() {
        return glasses;
    }

    public String getParty() {
        return party;
    }

    public String getScandals() {
        return scandals;
    }

    public String getStillLiving() {
        return stillLiving;
    }

    public String getHoechstesAmt() {
        return hoechstesAmt;
    }

    public String getBildung() {
        return Bildung;
    }

    public String getBundeslaender() {
        return Bundeslaender;
    }

    public String getStillMoving() {
        return stillMoving;
    }

    //Setter rechtsklick -> generate

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public void setGlasses(String glasses) {
        this.glasses = glasses;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public void setScandals(String scandals) {
        this.scandals = scandals;
    }

    public void setStillLiving(String stillLiving) {
        this.stillLiving = stillLiving;
    }

    public void setHoechstesAmt(String hoechstesAmt) {
        this.hoechstesAmt = hoechstesAmt;
    }

    public void setBildung(String bildung) {
        Bildung = bildung;
    }

    public void setBundeslaender(String bundeslaender) {
        Bundeslaender = bundeslaender;
    }

    public void setStillMoving(String stillMoving) {
        this.stillMoving = stillMoving;
    }
}
