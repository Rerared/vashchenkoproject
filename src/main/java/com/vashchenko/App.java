package com.vashchenko;

import com.vashchenko.domain.Product;
import com.vashchenko.view.MainMenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    List<Product> productsList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        MainMenu menu = new MainMenu();
        menu.show();
    }
}
