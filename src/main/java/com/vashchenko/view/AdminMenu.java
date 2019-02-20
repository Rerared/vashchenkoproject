package com.vashchenko.view;

import com.vashchenko.domain.Client;
import com.vashchenko.domain.Order;
import com.vashchenko.domain.Product;
import com.vashchenko.services.ClientService;
import com.vashchenko.services.OrderService;
import com.vashchenko.services.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


public class AdminMenu {

    private final BufferedReader br;
    private ClientService clientService;
    private ProductService productService;
    private OrderService orderService;


    public AdminMenu(ClientService clientService, ProductService productService,OrderService orderService, BufferedReader br) {
        this.br = br;
        this.clientService = clientService;
        this.productService = productService;
        this.orderService = orderService;
    }


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
                    List<Client> allClients = clientService.getAllClients();
                    for (Client c : allClients) {
                        System.out.println(c.toString());
                    }
                    break;
                case "5":
                    addProduct();
                    break;
                case "6":
                    System.out.println("Enter product's id to modify");
                    long productIdModify = Long.parseLong(br.readLine());
                    productService.modifyProduct(productIdModify);
                    break;
                case "7":
                    System.out.println("Enter product's id to delete");
                    long productIdDelete = Long.parseLong(br.readLine());
                    productService.deleteProduct(productIdDelete);
                    break;
                case "8":
                    List<Product> productList = productService.getListProduct();
                    for (Product product : productList) {
                        System.out.println(product);
                    }
                    break;
                case "9":
                    System.out.println("This option will be available soon");
                    break;
                case "10":
                    System.out.println("This option will be available soon");
                    break;
                case "11":
                    List<Order> orderList = orderService.getAllOrders();
                    for (Order order : orderList) {
                        System.out.println(order);
                    }
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
        System.out.println("1 Add client");
        System.out.println("2. Modify client");
        System.out.println("3. Delete client");
        System.out.println("4. Show all clients");
        System.out.println("5. Add product");

        System.out.println("6. Modify product");
        System.out.println("7. Delete product");
        System.out.println("8. Show all products");
        System.out.println("9. Add Order");
        System.out.println("10. Delete Order");
        System.out.println("11. Show all orders");
        System.out.println("R - Return");
        System.out.println("E - Exit");
    }

    private void addProduct() throws IOException {
        System.out.println("Enter name of product");
        String name = br.readLine();
        System.out.println("Enter price of product");
        String priceStr = br.readLine();
        if(priceStr.matches("\\d+")){
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
        if(id.matches("\\d+")){
            long idLong = Long.parseLong(id);
            clientService.modifyClient(idLong);
        } else {
            System.out.println("Wrong client's id");
        }
    }

    private void deleteClient() throws IOException {
        System.out.println("Enter client's id");
        String idString = br.readLine();
        boolean flag = true;
        while(flag){
            if(idString.matches("\\d+")){
                long id = Long.parseLong(idString);
                clientService.deleteClient(id);
                flag = false;
            } else {
                System.out.println("Wrong client's id");
            }
        }
    }

    private void createClient() throws IOException {
        System.out.println("Enter name");
        String name = br.readLine();
        System.out.println("Enter surname");
        String surname = br.readLine();
        System.out.println("Enter age");
        int age = Integer.parseInt(br.readLine());
        System.out.println("Enter phone number");
        String number = br.readLine();
        System.out.println("Enter email");
        String email = br.readLine();
        clientService.createClient(name,surname, age,number,email);
    }
}
