package com.vashchenko.view;

import com.vashchenko.domain.Order;
import com.vashchenko.domain.Product;
import com.vashchenko.services.ClientService;
import com.vashchenko.services.OrderService;
import com.vashchenko.services.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientMenu {
    private BufferedReader br;
    private ClientService clientService;
    private ProductService productService;
    private OrderService orderService;

    public ClientMenu(ClientService clientService, ProductService productService, OrderService orderService, BufferedReader br ) {
        this.clientService = clientService;
        this.br = br;
        this.productService = productService;
        this.orderService = orderService;
    }

    private List<Product> productList = new ArrayList<>();
    public void show() throws IOException {
        boolean isRunning = true;
        while (isRunning){
            showMenu();
            switch (br.readLine()) {
                case "1":
                    createClient();
                    break;
                case "2":
                    modifyClient();
                    break;
                case "3":
                    List<Order> orders = orderService.getAllOrders();
                    for (Order order : orders) {
                        System.out.println(order);
                    }
                    break;
                case "4":
                    System.out.println("This option will be available soon");
                    break;
                case "5":
                    System.out.println("List of client's orders: will be available soon");
                    break;
                case "R":
                    isRunning = false;
                    break;
                case "E":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("1 Register client");
        System.out.println("2. Modify client");
        System.out.println("3. Show all products");
        System.out.println("4. Make order");
        System.out.println("5. List of client's orders");

        System.out.println("R - Return");
        System.out.println("E - Exit");
    }

    private void addProductToList() throws IOException {
        productList = productService.getListProduct();
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(i + 1 + ". Name:" + productList.get(i).getName()
                    + " Price:" + productList.get(i).getPrice());
        }

        System.out.println("Enter number of Product");
        String number = br.readLine();
        if(Integer.parseInt(number) <= productList.size()){
            productService.addProduct(
                    productList.get(Integer.parseInt(number) - 1).getName(),
                    productList.get(Integer.parseInt(number) - 1).getPrice());
            System.out.println(productList.get(Integer.parseInt(number) - 1).toString() + "was added.");
        }
    }

    private void modifyClient() throws IOException {
        System.out.println("Enter client's id");
        String id = br.readLine();
        if(id.matches("\\d+")){
            long idLong = Long.parseLong(id);
            clientService.modifyClient(idLong);
        } else {
            System.out.println("Wrong client's id");
        }
    }

    private void createClient() throws IOException {
        System.out.println("Enter your name");
        String name = br.readLine();
        System.out.println("Enter your surname");
        String surname = br.readLine();
        System.out.println("Enter your age");
        int age = Integer.parseInt(br.readLine());
        System.out.println("Enter your phone number (XXX)XXX-XX-XX");
        String number = br.readLine();
        System.out.println("Enter your email");
        String email = br.readLine();
        clientService.createClient(name,surname, age,number,email);
    }
}
