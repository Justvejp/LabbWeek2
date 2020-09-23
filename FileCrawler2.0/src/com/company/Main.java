package com.company;

import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        File startingFolder = new File("C:\\Users\\Gurra\\DokumentsGitub\\FileCrawler2.0");
        Scanner key = new Scanner(System.in);

        while (true) {

            System.out.println("Welcome to FileCrawler!");
            System.out.println("Search for a keyword, or type Exit to end the program.");
            System.out.print("Enter a keyword: ");
            String keyword = key.next();

            checkIfFile(startingFolder, keyword);
            
            if (keyword.equalsIgnoreCase("Exit")) {
                break;
            }
        }
    }

    public static void checkIfFile(File startingFolder, String keyword) {

        if (startingFolder.isFile()) {
            scanFile(startingFolder, keyword);

        } else if (startingFolder.isDirectory()) {

            try {
                File[] folderContents = startingFolder.listFiles();
                assert folderContents != null;
                for (File fileList : folderContents) {
                    checkIfFile(fileList, keyword);
                }

            } catch (Exception e) {
                System.err.println("Error: " + startingFolder.getAbsolutePath());

            }

        } else {
            System.err.println("Error: " + startingFolder.getAbsolutePath());

        }
    }

    public static void scanFile(File startingFolder, String keyword) {

        try {
            Scanner sc = new Scanner(startingFolder);

            while (sc.hasNextLine()) {
               String s = sc.nextLine();

                if (s.contains(keyword)) {
                    System.out.println(startingFolder.getCanonicalPath());
                }

            } sc.close();

        } catch (Exception e) {
            System.err.println("Error: " + startingFolder.getAbsolutePath());

        }
    }       // av Gustav och Cuneyt
}
