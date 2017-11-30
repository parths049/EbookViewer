package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * EbookWritter
 */
public class EbookWritter {

    static Scanner scanner = new Scanner(System.in);
    
    public static int line = 50;
    
    public static Integer currentPage = 0;
    
    /**
     * Read file 
     */
    public static void readFileAndPrintCounts(File selectedFile) throws FileNotFoundException {
        
        int crunchifyTotalWords = 0;
        int crunchifyTotalLines = 0;
        int crunchifyTotalCharacters = 0;
 
        String crunchifyLine;
        
        try (BufferedReader crunchifyBuffer = new BufferedReader(new FileReader(selectedFile))) {
            System.out.println("========== File Content ==========");
 
            // read each line one by one
            while ((crunchifyLine = crunchifyBuffer.readLine()) != null) {
                //System.out.println(crunchifyLine);
                crunchifyTotalLines++;
                // ignore multiple white spaces
                String[] myWords = crunchifyLine.replaceAll("\\s+", " ").split(" ");
 
                for (String s : myWords) {
                    crunchifyTotalCharacters += s.length();
                }
                crunchifyTotalWords += myWords.length;
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("* Total Characters: " + crunchifyTotalCharacters);
        System.out.println("* Total Words: " + crunchifyTotalWords);
        System.out.println("* Toal Lines: " + crunchifyTotalLines);
        System.out.println("* Total Pages : " + crunchifyTotalLines/50);
        
        currentPage = 1 ;
        System.out.println("\n========== Result ==========");
        currentPage = EbookReader.readBook(selectedFile, 0 , line);
        
        do {
            System.out.println("You have following choce :");
            System.out.println("1. NEXT");
            System.out.println("2. PREVIOUS");
            System.out.println("3. EXIT");
            
            if(currentPage <= 0) {
                System.out.println("There is no previous page , please select next option or exit");
            }
            int choice = scanner.nextInt();
                switch (choice) {
                case 1:
                    System.out.println("* Current Pages : " + (currentPage + 1));
                    currentPage = EbookReader.readBook(selectedFile, currentPage + 1 , line);
                    break;
                case 2:
                    System.out.println("* Current Pages : " + (currentPage - 1));
                    currentPage = EbookReader.readBook(selectedFile, currentPage - 1 , line);
                    break;
                case 3:
                    System.out.println("You exit from this book !!!");
                    EbookViewer.main(null);
                    break;
                default:
                    System.out.println("Please enter valid input");
                    break;
            }
         
        } while (currentPage != null);
        
    }
}
