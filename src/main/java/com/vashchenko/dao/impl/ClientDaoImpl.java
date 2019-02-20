package com.vashchenko.dao.impl;

import com.vashchenko.dao.ClientDao;
import com.vashchenko.domain.Client;
import com.vashchenko.services.impl.ClientServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDaoImpl implements ClientDao {
    private Map<Long, Client> clients = new HashMap<>();
    private static volatile ClientDao clientDao;

    private static long generator = 0;

    private ClientDaoImpl(){
    }
    @Override
    public List<Client> getAllClients() {
        List<Client> clientList = new ArrayList<>();
        for (long i = 0; i < clients.size(); i++) {
            clientList.add(clients.get(i));
        }
        return clientList;
    }

    @Override
    public boolean saveClient(Client client) {
        client.setId(generator++);
        clients.put(client.getId(), client);
        System.out.println("Saved" + client);
        return true;
    }

    @Override
    public boolean deleteClient(long clientId) {
        clients.remove(clientId);
        System.out.println("Deleted client : id=" + clientId);
        return true;
    }

    @Override
    public boolean modifyClient(long clientId) {
        System.out.println("Modified client with id: " + clientId);
        return true;
    }

    public static ClientDao getInstance() {
        if(clientDao == null){
            synchronized (ClientServiceImpl.class) {
                if (clientDao == null) {
                    clientDao = new ClientDaoImpl();
                }
            }
        }
        return clientDao ;
    }


}
