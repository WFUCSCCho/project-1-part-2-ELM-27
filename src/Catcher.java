import java.io.*;
import java.util.*;

public class Catcher {

    /*
        Username:     Player's username
        User ID:      Player's account ID
        Skill Rating: Combination of various stats (see README)
        Title:        Given based on user performance or other factors (see README)
     */

    // Variable Definition
    private String username;
    private int userID;
    private int skill;
    private String title;
    private FileReader inputFile = new FileReader("CTB Data Current.csv");
    private Scanner csv = new Scanner(inputFile);

    public Catcher(String username) throws FileNotFoundException {
        FileReader inputFile = new FileReader("CTB Data Current.csv");
        Scanner sc = new Scanner(inputFile);
        String testString;

        this.username = username;

        while(sc.hasNext()) {
            testString = sc.next();
            if(testString.contains(username)) {
                if(testString.indexOf(username) == 0) {
                    // TODO: read and assign rest of data
                }
            }
        }
        // this.userID = 0;
        // this.skill = skill;
        // this.title = title;
    }

    public Catcher(int userID) throws FileNotFoundException {
        FileReader inputFile = new FileReader("CTB Data Current.csv");
        Scanner sc = new Scanner(inputFile);
        String testString;

        this.userID = userID;

        while(sc.hasNext()) {
            testString = sc.next();
            if(testString.contains(Integer.toString(userID))) {
                // TODO: read and assign rest of data
            }
        }
        // this.username = null;
        // this.skill = skill;
        // this.title = title;
    }

    public int getSkill() {
        return skill;
    }

    @Override
    public String toString() {
        String printString = username;
        printString = printString.concat("Username: " + username);
        printString = printString.concat(", ID: " + userID);
        printString = printString.concat(", SR: " + skill);
        printString = printString.concat(", Title: " + title);
        return printString;
    }

    @Override
    public boolean equals(Object obj) {
        String objString;

        objString = obj.toString();
        // returns true if username or user ID are identical
        if(objString.contains(username) || objString.contains(Integer.toString(userID))) {
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(Catcher catcher) {
        int compare;
        compare = this.skill - catcher.getSkill();
        return compare;
    }
}