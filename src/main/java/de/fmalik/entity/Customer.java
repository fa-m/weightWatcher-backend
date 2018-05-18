package de.fmalik.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Customer implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final String name;
    private final String password;
    private final WeightHistory history;

    public Customer(String name, String password, WeightHistory history) {
        this.name = name;
        this.password = password;
        this.history = history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equal(name, customer.name) &&
                Objects.equal(password, customer.password) &&
                Objects.equal(history, customer.history);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, password, history);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("password", password)
                .add("history", history)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public WeightHistory getHistory() {
        return history;
    }
}
