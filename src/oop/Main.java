package oop;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Display> displayList = new ArrayList<Display>();

        displayList.add(new Display("Asus", 50, 50, 1080));
        displayList.add(new Display("Lenovo", 1250, 5320, 1080));
        displayList.add(new Display("Dell", 1000, 500, 1080));

//        for (Display display1 : displayList) {
//            for (Display display2 : displayList) {
//                if (display1 != display2) {
//                    display1.compareSize(display2);
//                }
//            }
//        }
//        Display display1 = new Display("Asus", 1080, 1920, 1080);
//        Display display2 = new Display("Lenovo", 1440, 2560, 1440);
//        Display display3 = new Display("Dell", 720, 1280, 720);

        Assistant assistant = new Assistant( "Alexandro");



        // Assign displays to the Assistant
//        FileReader file = new FileReader();
//        file.ReadFile("output.txt");



        assistant.assignDisplay(displayList.get(0));
        assistant.assignDisplay(displayList.get(1));
        assistant.assignDisplay(displayList.get(2));

        // Use the assist method to compare displays
        assistant.assist();

        // Buy a display
        assistant.buyDisplay(displayList.get(1));

        // Attempt to buy the same display again
        assistant.buyDisplay(displayList.get(1));
    }
}




//Task nr 2 and 4 with file and text proccessing
//public class Main {
//    public static void main(String[] args) {
//        if (args.length == 0) {
//            System.out.println("Please provide file paths as command-line arguments.");
//            return;
//        }
//
//        FileReaderUtils fileReader = new FileReaderUtils();
//        for (String filePath : args) {
//            try {
//                String content = fileReader.readFileIntoString(filePath);
//                TextData textData = new TextData(content, filePath);
//                displayFileData(textData);
//            } catch (IOException e) {
//                System.out.println("Could not read file: " + filePath);
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private static void displayFileData(TextData textData) {
//        System.out.println("File Name: " + textData.getFileName());
//        System.out.println("Number of Vowels: " + textData.getNumberOfVowels());
//        System.out.println("Number of Consonants: " + textData.getNumberOfConsonants());
//        System.out.println("Number of Letters: " + textData.getNumberOfLetters());
//        System.out.println("Number of Sentences: " + textData.getNumberOfSentences());
//        System.out.println("Longest Word: " + textData.getLongestWord());
//        System.out.println("-----------");
//    }
//
//
//}
