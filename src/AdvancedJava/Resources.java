package AdvancedJava;

import CoreJava.Util;

import java.io.*;
import java.util.Scanner;

public class Resources {
    private String tempFileName = "learnTmp";
    private String ext = "tmp";
    File tempFile;
    public Resources() {
        createTmpFile();
        tryWithWrite();
        bufferedReader();
        scanner();


    }

    private void tryWithWrite() {
        Util.printHeader("Try With writing");
        System.out.println("Try (init resources) will close the resource on completion of block");
        System.out.println("""
                        try (FileWriter writer = new FileWriter(tempFile)) {
                            writer.write("This is line 1\\r\\nThis is line 2\\r\\nLINE 33333333");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }\
                """);
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("This is line 1\r\nThis is line 2\r\nLINE 33333333");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createTmpFile() {
        Util.printHeader("Create temp file");
        System.out.println("""
                Create temporary file:\s
                try {
                            tempFile = File.createTempFile(tempFileName, ext);
                            tempFile.deleteOnExit();
                
                        } catch (IOException e) {
                            System.out.println("Couldn't open file " + e.getMessage());
                        }""");
        try {
            tempFile = File.createTempFile(tempFileName, ext);
            System.out.println("Temp file created: " + tempFile.toURI());
            tempFile.deleteOnExit();

        } catch (IOException e) {
            System.out.println("Couldn't open file " + e.getMessage());
        }




    }

    private void scanner() {
        Util.printHeader("Scanner");
        System.out.println("""
                Newer read from console:
                    Scanner sc = new Scanner(System.in);
                    sc.nextInt();
                    sc.nextLine();""");
//        Scanner sc = new Scanner(System.in);
//        sc.nextInt();
//        sc.nextLine();
        System.out.println("""
                read from temp file:\s
                 try {
                    Scanner fileReader = new Scanner(tempFile);
                    System.out.println(fileReader.nextLine());
                } catch (FileNotFoundException e) {
                    System.out.println(e);
                }""");
        try (Scanner fileReader = new Scanner(tempFile)){
            System.out.println(fileReader.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    private void bufferedReader() {
        Util.printHeader("Buffered Reader");
        System.out.println("Original method - BufferedReader br = new BufferedReader(new InputStreamReader(System.in)));\nbr.readLine();\nbr.close();");
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in)));
        //br.readLine();
        //br.close();
    }
    
    
}
