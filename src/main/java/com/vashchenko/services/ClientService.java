package com.vashchenko.services;

import com.vashchenko.domain.Client;

import java.util.List;

/**
 * @author Vashchenko Maksim
 */

public interface ClientService {
    /**
     * Create a new client.
     * @param name the client's name;
     * @param surname the client's surname.
     * @param age the client's age.
     * @param number the client's number.
     * @param email the client's email.
     */
    void createClient(String name, String surname, int age, String number, String email);

    /**
     * Modify a currently existing client by id.
     * @param id of the client.
     */
    void modifyClient(long id);

    /**
     * Delete the client with by id.
     * @param id of the client.
     */
    void deleteClient(long id);

    /**
     * Gets list of all clients {@link Client}.
     * @return List<Client> clients.
     */
    List<Client> getAllClients();



}
