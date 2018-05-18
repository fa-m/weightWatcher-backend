package de.fmalik.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.sql.Timestamp;

public class Weight {
    private final Timestamp timestamp;
    private final double weight;
    private int id;

    public Weight(Timestamp timestamp, double weight) {
        this.timestamp = timestamp;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight1 = (Weight) o;
        return Double.compare(weight1.weight, weight) == 0 &&
                id == weight1.id &&
                Objects.equal(timestamp, weight1.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(timestamp, weight, id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("timestamp", timestamp)
                .add("weight", weight)
                .add("id", id)
                .toString();
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public double getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
