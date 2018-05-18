package de.fmalik.boundary;

import de.fmalik.entity.Customer;
import de.fmalik.entity.Weight;

public interface CustomerRepository {
    void setup();

    void exit();

    void create(Customer customer);

    Customer read(long id);

}
