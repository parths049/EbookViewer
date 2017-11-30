package com.main;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Main Class 
 */
public class EbookViewer {
   
    public static void main(String[] args) throws FileNotFoundException {
        
        File selectedFile = EbookReader.scanTextFilesAndRetrunSelectedFile();
        
        EbookWritter.readFileAndPrintCounts(selectedFile);
    }
    
}
