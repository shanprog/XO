package io.hexlet.java.m101.xo.view;

import java.util.Scanner;

public class MenuView {

    private static final int START_CODE = 1;

    public int showMenuWithResult() {
        System.out.println(START_CODE + " - Start");
        System.out.println("2 - Load");
        System.out.println("3 - Settings");
        System.out.println("4 - Exit");
        System.out.print(">");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case START_CODE:
                System.out.println("START!");
                break;
            case 2:
                System.out.println("LOAD!");
                  break;
            case 3:
                System.out.println("SETTINGS!");
                   break;
            case 4:
                System.out.println("EXIT!");
                break;
            default:
                System.out.println("REALLY!!?");
        }

        return 0;
    }

}
