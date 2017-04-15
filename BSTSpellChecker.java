
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tongtong
 */
public class BSTSpellChecker {

    
    public static void main(String[] args) {

        /**
         * 
         * instantiate four variables of the long type to act as counters, a wordToBeSearched
         * of the String type for the word comparisons for "Oliver", an int i variable
         * for loops, and initializing the count array that will be used for the
         * "search" method
         */
        int wordsFound = 0;
        int wordsNotFound = 0;
        double compsFound = 0;
        double compsNotFound = 0;
        String[] wordToBeSearched;
        
        
        
        int[] count = new int[1];

       
         // instantiate twenty-six empty Binary Search Tree's of the String type
         
        BinarySearchTree[] dictionary = new BinarySearchTree[26];
        for (int i = 0; i < dictionary.length; i++) {
            dictionary[i] = new BinarySearchTree<String>();// each array element contains a new BinarySearchTree
        }

        //a try-catch block to read in the file for the random dictionary 
        java.io.File f= new java.io.File("random_dictionary.txt");
        try {
           
           
            Scanner in = new Scanner(f);
            while (in.hasNext() != false) {
                String word = in.next();
                word = word.toLowerCase();
                dictionary[(int)word.charAt(0) - 97].insert(word);//subtracts 97 from the ASCII value of the first letter for every word.
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

       
         // a try-catch block that reads in the file for the book "Oliver." 
         java.io.File f1 = new java.io.File("oliver.txt");
        try {
            
            Scanner in = new Scanner(f);
            while (in.hasNext()) {
                String l = in.next();
                 wordToBeSearched = l.toLowerCase().replaceAll("[^A-Za-z]", " ").split(" ");
               for (String word : wordToBeSearched) {
                if (!word.isEmpty()) {
                    if (dictionary[word.charAt(0) - 97].search(word, count)) {
                        wordsFound++;
                        compsFound += count[0];
                    } else {
                       
                        wordsNotFound++;
                        compsNotFound += count[0];                       
                    }
                }
            }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        /**
         * 
         * process the averages for both words found to comparisons of words found, and 
         * words not found to comparisons of words not found
         */
        double avgCompsWordsFound =  (compsFound / wordsFound);
        double avgCompsWordsNotFound =  (compsNotFound / wordsNotFound);
        
        /**
         * 
         * output all the counters for words found and words found comparisons, words not 
         * found and word not found comparisons, and the averages for  both.
         */
        System.out.println("The amount of words found: " + wordsFound);
        System.out.println("The amount of comparisons of words found: " + compsFound);
        System.out.println("The amount of words not found: " + wordsNotFound);
        System.out.println("The amount of comparisons of words not found: " + compsNotFound);
        System.out.println("The average amount of words found to comparisons of words"
                + " found is:" + avgCompsWordsFound);
        System.out.println("The average amount of words not found to comparisons of words"
                + " not found is:" + avgCompsWordsNotFound);

    }//main
}//class


    
    

