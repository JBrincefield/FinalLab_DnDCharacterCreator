package edu.neumont.csc150.model.item;

public abstract class Item {

    private String description;

    public Item(String description) {
        setDescription(description);
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public abstract String toString() ;
}

