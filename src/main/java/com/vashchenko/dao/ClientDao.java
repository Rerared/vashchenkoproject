package com.vashchenko.dao;

import com.vashchenko.domain.Client;

import java.util.List;

public interface ClientDao {
    /**
     * Return all clients
     * @return list of all clients.
     */
    List<Client> getAllClients();
    /**
     * @param client
     * @return is he was saved successful.
     */
    boolean saveClient(Client client);

    /**
     * Delete a client by id.
     * @param clientId of Client.
     * @return is he was deleted successful.
     */
    boolean deleteClient(long clientId);

    /**
     * Modify client by id.
     * @param clientId of Client.
     * @return is he was modified successful.
     */
    boolean modifyClient(long clientId);

}
