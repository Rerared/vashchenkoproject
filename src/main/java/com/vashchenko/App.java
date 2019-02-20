package com.vashchenko;

import com.vashchenko.dao.ClientDao;
import com.vashchenko.dao.OrderDao;
import com.vashchenko.dao.ProductDao;
import com.vashchenko.dao.impl.ClientDaoImpl;
import com.vashchenko.dao.impl.OrderDaoImpl;
import com.vashchenko.dao.impl.ProductDaoImpl;
import com.vashchenko.domain.Client;
import com.vashchenko.domain.Product;
import com.vashchenko.services.ClientService;
import com.vashchenko.services.OrderService;
import com.vashchenko.services.ProductService;
import com.vashchenko.services.ValidationService;
import com.vashchenko.services.impl.ClientServiceImpl;
import com.vashchenko.services.impl.OrderServiceImpl;
import com.vashchenko.services.impl.ProductServiceImpl;
import com.vashchenko.services.impl.ValidationServiceImpl;
import com.vashchenko.view.AdminMenu;
import com.vashchenko.view.ClientMenu;
import com.vashchenko.view.MainMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class App {



    List<Product> productsList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ProductDao productDao = new ProductDaoImpl();
        OrderDao orderDao = new OrderDaoImpl();
        ValidationService validationService = new ValidationServiceImpl();
        ClientService clientService = new ClientServiceImpl(validationService);
        ProductService productService = new ProductServiceImpl(productDao);
        OrderService orderService = new OrderServiceImpl(orderDao);
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        AdminMenu adminMenu = new AdminMenu(clientService, productService,orderService, br);
        ClientMenu clientMenu = new ClientMenu(clientService, productService, orderService, br);
        MainMenu menu = new MainMenu(br, adminMenu, clientMenu);
        menu.show();
    }
}
