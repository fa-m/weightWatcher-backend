package de.fmalik.entity;

import java.util.List;

public interface WeightHistory {
    List<Weight> getHistory();
    Boolean addWeight(Weight weight);
}
