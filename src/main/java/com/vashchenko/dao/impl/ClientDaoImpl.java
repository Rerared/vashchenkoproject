package com.vashchenko.dao.impl;

import com.vashchenko.dao.ClientDao;
import com.vashchenko.domain.Client;

public class ClientDaoImpl implements ClientDao {


    @Override
    public boolean saveClient(Client client) {
        System.out.println("Saved" + client);
        return true;
    }

    @Override
    public boolean deleteClient(long id) {
        System.out.println("Deleted client : id=" + id);
        return true;
    }

    @Override
    public boolean modifyClient(long id) {
        System.out.println("Modified client with id: " + id);
        return true;
    }
}
