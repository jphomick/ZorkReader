package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String command = "";

        try {
            while (!command.equals("quit")) {
                command = read.nextLine();
                String result = ReadHelper.readTextFromUrl("http://localhost:8080/" + command.trim());
                System.out.println(result);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
