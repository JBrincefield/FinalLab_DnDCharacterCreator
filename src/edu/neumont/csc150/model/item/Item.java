package edu.neumont.csc150.model.item;

public abstract class Item {
    private ItemName name;
    private String description;

    public Item(ItemName name, String description) {
        setName(name);
        setDescription(description);
    }
    //region Getter/Setters
    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public ItemName getName() {
        return name;
    }

    private void setName(ItemName name) {
        this.name = name;
    }
    //endregion
    @Override
    public abstract String toString() ;
}

