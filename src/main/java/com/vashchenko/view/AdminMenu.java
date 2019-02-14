package com.vashchenko.view;

import com.vashchenko.services.ClientService;
import com.vashchenko.services.ProductService;
import com.vashchenko.services.impl.ClientServiceImpl;
import com.vashchenko.services.impl.ProductServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;


public class AdminMenu {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private ClientService clientService = new ClientServiceImpl();
    private ProductService productService = new ProductServiceImpl();


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
                    deleteClient();
                    break;
                case "4":
                    addProduct();
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

    private void addProduct() throws IOException {
        System.out.println("Enter name of product");
        String name = br.readLine();
        System.out.println("Enter price of product");
        String priceStr = br.readLine();
        if(priceStr.matches("\\d*")){
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(priceStr));
            productService.addProduct(name, price);
        } else {
            System.out.println("Wrong price input");
        }
        System.out.println("Add product");
    }

    private void modifyClient() throws IOException {
        System.out.println("Enter client's id");
        String id = br.readLine();
        if(id.matches("-?\\d*")){
            long idLong = Long.parseLong(id);
            clientService.modifyClient(idLong);
        } else {
            System.out.println("Wrong client's id");
        }
    }

    private void deleteClient() throws IOException {
        System.out.println("Enter client's id");
        String idString = br.readLine();
        if(idString.matches("-?\\d*")){
            long id = Long.parseLong(idString);
            clientService.deleteClient(id);
        } else {
            System.out.println("Wrong client's id");
        }
    }

    private void showMenu() {
        System.out.println("1 Add client");
        System.out.println("2. Modify client");
        System.out.println("3. Remove client");
        System.out.println("4. Add product");
        System.out.println("9. Return");
        System.out.println("0. Exit");
    }

    private void createClient() throws IOException {
        System.out.println("Input name");
        String name = br.readLine();
        System.out.println("Input surname");
        String surname = br.readLine();
        System.out.println("Input phone number");
        String number = br.readLine();
        clientService.createClient(name,surname,number);
    }
}
