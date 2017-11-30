package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * EbookReader
 */
public class EbookReader {

    static Scanner scanner = new Scanner(System.in);
    
    
    /**
     * Read book
     * @return 
     */
    public static int readBook(File file , int page,int line) {
        int crunchifyTotalLines = 0;
        int count = 0;
        String crunchifyLine;
        try (BufferedReader crunchifyBuffer = new BufferedReader(new FileReader(file))) {
 
            // read each line one by one
            while ((crunchifyLine = crunchifyBuffer.readLine()) != null) {
                crunchifyTotalLines++;
                if(crunchifyTotalLines >= (line*page) && count != line)
                {
                    System.out.println(crunchifyLine);
                    count++;
                }
            }
          
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }

    
    /**
     * Scan all text files and return selected file.
     * @return
     */
    public static File scanTextFilesAndRetrunSelectedFile() {
        System.out.println("You have following books :");
        
        File actual = new File(".");
        File list[] = actual.listFiles();
        
        int totalTextFiles = 0;
        // read all text files form project folder
        for(int i=0; i<list.length; i++){
            if(list[i].isFile() && list[i].getName().contains(".txt")){
                System.out.println(totalTextFiles+1 +" = "+ list[i].getName());
                totalTextFiles++;
            }
        }
        
        int bookNumber = 0;
        do {
            bookNumber = getUserSelectedFile(totalTextFiles);
        } while (bookNumber == 0);
       
        File selectedFile = null;
        
        int fileIndex = 1;
        for(int i=0; i<list.length; i++){
            if(list[i].isFile() && list[i].getName().contains(".txt")){
                if(fileIndex == bookNumber) {
                    selectedFile = list[i];
                    break;
                }
                fileIndex++;
            }
        }
        
        System.out.println("You are selected : " + selectedFile.getName());
        
        return selectedFile;
    }
    
    
    
    /**
     * Get users selected file
     * @param totalTextFiles
     * @return
     */
    public static int getUserSelectedFile(int totalTextFiles){
        System.out.println("Enter book number :");
        int bookNumber = scanner.nextInt();
        if(bookNumber <= totalTextFiles) {
            return bookNumber;
        } else {
            System.out.println("Opps! Please try again , You entered wrong input");
        }
        return 0;
    }
}
