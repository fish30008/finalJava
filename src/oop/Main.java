package oop;

import oop.task1.Display;
import oop.task2.FileReaderUtils;
import oop.task3.TextData;
import oop.task4.Assistant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("Please specify a task (1 for Display/Assist tasks, 2 for File/Text proccessing tasks): ");
        Scanner scanner = new Scanner(System.in);
        int taskOption = scanner.nextInt();
        scanner.nextLine();

        switch (taskOption) {
            case 1:
                // Task 1-3: Display and Assistant functionality
                ArrayList<Display> displayList = new ArrayList<>();

                displayList.add(new Display("Asus", 50, 50, 1080));
                displayList.add(new Display("Lenovo", 1250, 5320, 1080));
                displayList.add(new Display("Dell", 1000, 500, 1080));

                Assistant assistant = new Assistant("Alexandro");

                assistant.assignDisplay(displayList.get(0));
                assistant.assignDisplay(displayList.get(1));
                assistant.assignDisplay(displayList.get(2));

                assistant.assist();


                assistant.buyDisplay(displayList.get(1));
                assistant.buyDisplay(displayList.get(1));
                break;

            case 2:
                        if (args.length == 0) {
            System.out.println("Please specify a task (1 for Display tasks, 2 for File tasks)");
            return;
        }
                FileReaderUtils fileReader = new FileReaderUtils();
                for (int i = 0; i < args.length; i++) {
                    String filePath = args[i];
                    try {
                        String content = fileReader.readFileIntoString(filePath);
                        TextData textData = new TextData(content, filePath);
                        displayFileData(textData);
                    } catch (IOException e) {
                        System.out.println("Could not read file: " + filePath);
                        e.printStackTrace();
                    }
                }
                break;

            default:
                System.out.println("Invalid task option. Please provide 1 or 2 as the task number.");
                break;
        }
    }

    private static void displayFileData(TextData textData) {
        System.out.println("File Name: " + textData.getFileName());
        System.out.println("Number of Vowels: " + textData.getNumberOfVowels());
        System.out.println("Number of Consonants: " + textData.getNumberOfConsonants());
        System.out.println("Number of Letters: " + textData.getNumberOfLetters());
        System.out.println("Number of Sentences: " + textData.getNumberOfSentences());
        System.out.println("Longest Word: " + textData.getLongestWord());
        System.out.println("-----------");
    }
}