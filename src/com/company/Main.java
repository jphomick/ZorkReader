package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String command = "";


            while (!command.equals("quit")) {
                try {
                    command = read.nextLine();
                    if (!(command.startsWith("check") || command.startsWith("reset")
                            || command.startsWith("status") || command.startsWith("move"))) {
                        command = "act_" + command;
                    }
                    command = command.replace(" ", "_");
                    String result = ReadHelper.readTextFromUrl("http://localhost:8080/" + command.trim());
                    System.out.println(result.trim());
                } catch (IOException e) {
                    System.out.println("Invalid Read");
                }
            }

    }
}
