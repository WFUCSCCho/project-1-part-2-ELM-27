/*
 * @file: Catcher.java
 * @description: This class creates the data type Catcher, which hold 4 kinds of data:
 *               String username: The username of the player
 *               int userID:      The player's account ID
 *               int skill:       Combination of various user performance statistics
 *               String title:    Title given based off of skill
 * @author: Elliott Lowman
 * @date: September 25, 2024
 */

import java.io.*;
import java.util.*;

public class Catcher {

    // Variable Definition
    private String username;
    private int userID;
    private int skill;
    private String title;

    // for manual declaration
    public Catcher(String username, int userID, int skill, String title) {
        this.username = username;
        this.userID = userID;
        this.skill = skill;
        this.title = title;
    }

    // for declaration that searches CTB_Data.csv
    public Catcher(int userID) throws IOException {
        FileReader inputFile = new FileReader("CTB_Data.csv");
        Scanner sc = new Scanner(inputFile);
        String testString;
        String temp;
        String temp2;
        int index;
        boolean found = false;

        this.userID = userID;

        while(sc.hasNextLine()) {
            testString = sc.nextLine();
            if(testString.contains(Integer.toString(userID))) {
                // Ensures the input and userID match
                index = testString.indexOf(',');
                temp = testString.substring(index + 1);
                index = temp.indexOf(',');
                temp = temp.substring(0, index);
                if(Integer.parseInt(temp) == userID) {
                    found = true;

                    // Assigns username
                    index = testString.indexOf(',');
                    // Isolate username
                    temp = testString.substring(0, index);
                    // Set username
                    this.username = temp;

                    // Assigns skill rating
                    // Navigate to skill rating
                    temp = testString.substring(index + 1);
                    index = temp.indexOf(',');
                    temp = temp.substring(index + 1);
                    index = temp.indexOf(',');
                    // Isolate title
                    temp2 = temp.substring(index + 1);
                    // Isolate skill rating
                    temp = temp.substring(0, index);
                    // Set skill rating
                    this.skill = Integer.parseInt(temp);

                    // Set title
                    this.title = temp2;
                }
            }
        }

        // user not found
        if(!found) {
            this.userID = 0;
        }

        inputFile.close();
    }

    public int getSkill() {
        return skill;
    }

    public String getUsername() {
        return username;
    }

    // used only when a Catcher object is being printed
    public String getString() {
        String returnString = "Username: " + username;
        returnString = returnString.concat(", User ID: " + userID);
        returnString = returnString.concat(", Skill: " + skill);
        returnString = returnString.concat(", Title: " + title);
        return returnString;
    }

    // used when comparing Catcher objects to objects of other classes
    @Override
    public String toString() {
        String printString = Integer.toString(skill);
        return printString;
    }

    @Override
    public boolean equals(Object obj) {
        return Integer.toString(skill).equals(obj);
    }

    // tried to implement this but was met with errors, so I ended up having to use toString
    public int compareTo(Catcher catcher) {
        int compare;
        compare = this.skill - catcher.getSkill();
        return compare;
    }
}