package de.fmalik.boundary;

import de.fmalik.entity.Customer;
import de.fmalik.entity.Weight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Customers implements CustomerRepository {
    private SessionFactory sessionFactory;

    @Override
    public void setup() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Override
    public void exit() {
        sessionFactory.close();
    }

    @Override
    public void create(Customer customer) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(customer);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Customer read(long id) {
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }
}
