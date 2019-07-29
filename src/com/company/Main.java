package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static long user;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String command = "";
        user = -1;

        while (!command.equals("quit")) {
            try {
                while (user < 0) {
                    System.out.println("Type 'play [name]' to start a new game or 'load [id]' to continue");
                    command = read.nextLine();
                    command = command.replace(" ", "_");
                    if (command.startsWith("play")) {
                        String result = ReadHelper.readTextFromUrl("http://localhost:8080/" + command.trim());
                        System.out.println("Player created! Your id is '" + result + "'\nYou are in the Foyer.");
                        user = Long.parseLong(result);
                    } else if (command.startsWith("load") || command.startsWith("reset")) {
                        String result = ReadHelper.readTextFromUrl("http://localhost:8080/" + command.trim());
                        System.out.println(result.trim());
                        if (command.startsWith("load")) {
                            user = Long.parseLong(command.substring(5));
                        }
                    }
                }
                command = read.nextLine();
                if (!(command.startsWith("check") || command.startsWith("reset")
                        || command.startsWith("help")
                        || command.startsWith("status") || command.startsWith("move"))) {
                    command = "act_" + command;
                }
                if (!(command.startsWith("reset") || command.startsWith("help"))) {
                    command = user + "_" + command;
                }
                command = command.replace(" ", "_");
                String result = ReadHelper.readTextFromUrl("http://localhost:8080/" + command.trim());
                System.out.println(result.trim());
                if (command.equals("reset")) {
                    user = -1;
                }
            } catch (IOException e) {
                System.out.println("Invalid Read");
            }
        }

    }
}
