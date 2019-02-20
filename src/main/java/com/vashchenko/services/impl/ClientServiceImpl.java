package com.vashchenko.services.impl;

import com.vashchenko.dao.ClientDao;
import com.vashchenko.dao.impl.ClientDaoImpl;
import com.vashchenko.domain.Client;
import com.vashchenko.exceptions.BusinessException;
import com.vashchenko.services.ClientService;
import com.vashchenko.services.ValidationService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;
    private ValidationService validationService;
    public ClientServiceImpl(ValidationService validationService) {
        this.clientDao = ClientDaoImpl.getInstance();
        this.validationService = validationService;
    }

    @Override
    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    @Override
    public void createClient(String name, String surname, int age, String phoneNumber, String email) {
        boolean canCreateUser = true;
        boolean hasSamePhoneNumber = false;
        try {
            validationService.validateAge(age);
            validationService.validateEmail(email);
            validationService.validatePhoneNumber(phoneNumber);
        } catch (BusinessException e) {
            e.printStackTrace();
            canCreateUser = false;
        }
        List<Client> clientList = clientDao.getAllClients();
        for (Client client : clientList) {
            if(client.getNumber().equals(phoneNumber)){
                System.out.println("Have user with same phoneNumber");
                hasSamePhoneNumber = true;
            }
        }
        if (!hasSamePhoneNumber && canCreateUser) {
            Client client = new Client(name, surname,age,phoneNumber, email);
            clientDao.saveClient(client);
            System.out.println("Client saved: " + client);
        }

    }

    @Override
    public void modifyClient(long id) {
        boolean result = clientDao.modifyClient(id);
        if (result) {
            System.out.println("Modification has been successful.");
        }
    }

    @Override
    public void deleteClient(long id) {
        boolean result = clientDao.deleteClient(id);
        if (result) {
            System.out.println("Client with id: " + id + " was deleted successful.");
        }
    }


}
