package com.vashchenko.services.impl;

import com.vashchenko.dao.ClientDao;
import com.vashchenko.dao.impl.ClientDaoImpl;
import com.vashchenko.domain.Client;
import com.vashchenko.services.ClientService;

public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao = new ClientDaoImpl();

    @Override
    public void createClient(String name, String surname, String number) {
        Client client = new Client(name, surname, number);
        boolean result = clientDao.saveClient(client);
        if (result) {
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
