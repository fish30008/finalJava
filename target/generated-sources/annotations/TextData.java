package oop;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextData {
    private String text;
    private String fileName;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String text, String fileName) {
        this.text = text;
        this.fileName = fileName;
        this.numberOfVowels = countVowels();
        this.numberOfConsonants = countConsonants();
        this.numberOfLetters = countLetters();
        this.numberOfSentences = countSentences();
        this.longestWord = findLongestWord();
    }

    public String getFileName() {
        return fileName;
    }

    public String getText() {
        return text;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }

    private int countVowels() {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    private int countConsonants() {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if ("bcdfghjklmnpqrstvwxyz".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    private int countLetters() {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }

    private int countSentences() {
        int count = 0;
        Matcher matcher = Pattern.compile("[.!?]").matcher(text);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private String findLongestWord() {
        String longest = "";
        String[] words = text.split("\\W+");//split by whitespaces
        for (String word : words) {//finding longest word
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
}