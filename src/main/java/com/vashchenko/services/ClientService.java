package com.vashchenko.services;

/**
 * @author Vashchenko Maksim
 */

public interface ClientService {

    /**
     * Create a new client.
     * @param name the name of the client;
     * @param surname the surname of the client;
     * @param number mobile number.
     * */
    void createClient(String name, String surname, String number);

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



}
