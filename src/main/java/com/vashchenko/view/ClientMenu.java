package com.vashchenko.view;

import com.vashchenko.domain.Product;
import com.vashchenko.services.ClientService;
import com.vashchenko.services.OrderService;
import com.vashchenko.services.ProductService;
import com.vashchenko.services.impl.ClientServiceImpl;
import com.vashchenko.services.impl.OrderServiceImpl;
import com.vashchenko.services.impl.ProductServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClientMenu {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private ClientService clientService = new ClientServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

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
                    addProductToList();
                    break;
                case "3":
                    makeOrder();
                    break;
                case "4":
                    System.out.println("The order is currently active" + orderService.isActive());
                    break;
                case "9":
                    isRunning = false;
                    break;
                case "0":
                    System.exit(-1);
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }

    private void makeOrder() {
        System.out.println("Your order list is:");
        for (Product product : productList) {
            System.out.println(product.getName());
        }
        orderService.makeOrder(1, productList); // 1 - id of client
    }

    private void showMenu() {
        System.out.println("1 Add client");
        System.out.println("2. Add product to list");
        System.out.println("3. Make order");
        System.out.println("4. Watch state of order");
        System.out.println("9. Return");
        System.out.println("0. Exit");
    }

    private void addProductToList() throws IOException {
        productList.add(new Product("Book", BigDecimal.valueOf(50)));
        productList.add(new Product("Disk", BigDecimal.valueOf(100)));
        productList.add(new Product("Water", BigDecimal.valueOf(15)));
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

    private void createClient() throws IOException {
        System.out.println("Input your name");
        String name = br.readLine();
        System.out.println("Input your surname");
        String surname = br.readLine();
        System.out.println("Input your phone number");
        String number = br.readLine();
        clientService.createClient(name,surname,number);
    }
}
