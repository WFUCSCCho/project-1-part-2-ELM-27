/*
 * @file: Proj1.java
 * @description: The parser class for Project 1. This class converts
 *               the various commands from the input file into readable
 *               commands for this program.
 * @author: Elliott Lowman
 * @date: September 22, 2024
 */

import com.sun.jdi.connect.Connector;

import java.io.*;
import java.util.Scanner;

public class Parser {

    //Create a BST tree of Integer type
    private BST<Catcher> mybst = new BST<>();

    public Parser(String filename) throws IOException {
        process(new File(filename));
    }

    // Implement the process method
    // Remove redundant spaces for each input command
    public void process(File input) throws IOException {
        Scanner inFile = new Scanner(input);
        String[] command = new String[100];   // arbitrary data set size of 100 lines
        String temp = new String();
        int counter = 0;                      // counts valid lines from input file

        for(int i = 0; i < command.length; i++) {
            if(inFile.hasNext()) {
                temp = inFile.nextLine();

                // removes whitespace
                temp = temp.replace(" ", "");
                // adds every non-empty line to command[]
                if(!temp.isEmpty()) {
                    command[counter] = temp;
                    counter++;
                }
            }
        }

        // null pointer but in java
        // tells the program when the last command is reached
        command[counter] = "fin";

        //call operate_BST method;
        operate_BST(command);
    }

    // Implement the operate_BST method
    // Determine the incoming command and operate on the BST
    public void operate_BST(String[] command) throws IOException {
        String tempString;
        String skillString;
        int counter = 0;
        Node<Catcher> tempNode;
        Catcher obj;

        for(int i = 0; i < command.length; i++) {
            // inserts object into bst
            if(command[i].contains("insert")) {
                tempString = command[i].substring(6);  // reads object

                // converts to Catcher
                obj = new Catcher(Integer.parseInt(tempString));


                mybst.insert(obj);

                writeToFile(("insert " + obj.getString()), "result.txt");

                // searches for object in bst
            } else if(command[i].contains("search")) {
                tempString = command[i].substring(6);  // reads number
                // converts to Catcher
                obj = new Catcher(Integer.parseInt(tempString));

                tempNode = mybst.search(obj);

                // checks that the node exists
                if(tempNode == null) {
                    writeToFile("search failed", "result.txt");
                } else {
                    writeToFile(("found " + obj.getString()), "result.txt");
                }

                // removes object from bst
            } else if(command[i].contains("remove")) {
                tempString = command[i].substring(6);  // reads number
                // converts to Catcher
                obj = new Catcher(Integer.parseInt(tempString));

                tempNode = mybst.remove(obj);

                // checks that the node exists
                if(tempNode == null) {
                    writeToFile("remove failed", "result.txt");
                } else {
                    writeToFile(("removed "+ obj.getString()), "result.txt");
                }

                // prints bst
            } else if(command[i].contains("print")) {
                tempString = mybst.printBST();

                // loop that separates each skill rating, determines the appropriate user, and prints the users in order
                while(tempString.contains(" ")) {
                    counter++;

                    // separates one skill rating
                    skillString = tempString.substring(0, tempString.indexOf(" "));

                    // separates the rest
                    tempString = tempString.substring(tempString.indexOf(" ") + 1);

                    // searches for specific skill rating
                    obj = new Catcher("null", 0, Integer.parseInt(skillString), "null");

                    // prints all related data
                    tempNode = mybst.search(obj);
                    writeToFile("  " + counter + ": " + tempNode.getElement().getString(), "result.txt");
                }

                counter = 0;

                // terminates searching through bst
            } else if(command[i].contains("fin")){
                return;

                // handles invalid commands
            } else {
                writeToFile("Invalid Command", "result.txt");
            }
        }
    }

    // Implement the writeToFile method
    // Generate the result file
    public void writeToFile(String content, String filePath) throws IOException {
        FileWriter outFile = new FileWriter(filePath, true);  // navigates to end of file

        outFile.write(content + "\n");

        outFile.close();
    }
}
