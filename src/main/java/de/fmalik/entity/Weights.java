package de.fmalik.entity;

import java.util.LinkedList;
import java.util.List;

public class Weights implements WeightHistory {
    private List<Weight> weights;

    @Override
    public List<Weight> getHistory() {
        return weights;
    }

    @Override
    public Boolean addWeight(Weight weight) {
        if (isNotInitialized()) {
            initializeWeightsList();
        }
        Boolean addSuccessful = weights.add(weight);
        return addSuccessful;
    }

    private void initializeWeightsList() {
        weights = new LinkedList<>();
    }

    private Boolean isNotInitialized() {
        boolean isNotInitialized = false;
        if (weights == null) {
            isNotInitialized = true;
        } else {
            isNotInitialized = false;
        }
        return isNotInitialized;
    }
}
