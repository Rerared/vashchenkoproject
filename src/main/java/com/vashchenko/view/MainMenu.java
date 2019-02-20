package com.vashchenko.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {
    private final BufferedReader br;
    private final AdminMenu adminMenu;
    private final ClientMenu clientMenu;


    public MainMenu(BufferedReader br, AdminMenu adminMenu, ClientMenu clientMenu) {
        this.br = br;
        this.adminMenu = adminMenu;
        this.clientMenu = clientMenu;
    }


    private boolean isRunning = true;


    public void show() throws IOException {

        while (isRunning) {
            System.out.println("1. Admin");
            System.out.println("2. Client");
            System.out.println("E - Exit");

            switch (br.readLine()) {
                case "1":
                    adminMenu.show();
                    break;
                case "2":
                    clientMenu.show();
                    break;
                case "E":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;

            }

        }

    }

}
