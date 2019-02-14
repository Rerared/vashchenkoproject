package com.vashchenko.dao;

import com.vashchenko.domain.Client;

public interface ClientDao {
    /**
     * @param client
     * @return is he was saved successful.
     */
    boolean saveClient(Client client);

    /**
     * Delete a client by id.
     * @param id of Client.
     * @return is he was deleted successful.
     */
    boolean deleteClient(long id);

    /**
     * Modify client by id.
     * @param id of Client.
     * @return is he was modified successful.
     */
    boolean modifyClient(long id);

}
