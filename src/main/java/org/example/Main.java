package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        final int NUMBER_OF_LETTERS_TO_SPLIT_STRINGS_IN = 14;

        //Scan
        InputStream inputStream = new FileInputStream("src/main/resources/input.txt");
        Scanner sc = new Scanner(inputStream);
        String string = sc.nextLine();

        //Split string
        List<String> wordList = new ArrayList<>();
        splitLargeStringIntoSeperateStrings(string, wordList, NUMBER_OF_LETTERS_TO_SPLIT_STRINGS_IN);

        //Check which string is the first to NOT contain a double
        int wordCounter = 0;
        for (String s : wordList) {
            wordCounter++;
            if (checkIfAllLettersAreUnique(s)) {
                break;
            }
        }

        //Number of letters are the begin value
        System.out.println(wordCounter + (NUMBER_OF_LETTERS_TO_SPLIT_STRINGS_IN - 1));
    }

    //Range moves 1 to the right every loop
    private static void splitLargeStringIntoSeperateStrings(String string, List<String> stringList, int range) {
        int index = 0;
        while (index < string.length()) {
            stringList.add(string.substring(index, Math.min(index + range, string.length())));
            index += 1;
        }
    }

    public static boolean checkIfAllLettersAreUnique(String word) {
        boolean letterIsDouble = true;
        for (int i = 0; i < word.length(); i++) {
            String letterThatNeedsToBeChecked = String.valueOf(word.charAt(i));
            if (checkWordContainsLetterTwoTimes(word, letterThatNeedsToBeChecked)) {
                letterIsDouble = false;
                break;
            }
        }
        return letterIsDouble;
    }


    private static Boolean checkWordContainsLetterTwoTimes(String word, String letter) {
        return word.length() - word.replace(letter, "").length() > 1;
    }


//    private static Boolean checkIfWordContainsCharTwoTimes2(String word, String letter) {
//        return word.indexOf(letter, word.indexOf(letter) + 1) > -1;
//    }

}

