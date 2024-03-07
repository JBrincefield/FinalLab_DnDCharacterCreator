package edu.neumont.csc150.model.item;

public abstract class Item {
    private ItemName itemName;
    private String name;
    private String description;
    private String rarity;

    public Item(ItemName name) {
        setItemName(name);
        setName(name.getItemName());
        setDescription(name.getDescription());
        setRarity(name.getRarity());

    }
    //region Getter/Setters
    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public ItemName getItemName() {
        return itemName;
    }
    private void setItemName(ItemName itemName) {
        this.itemName = itemName;
    }
    public String getName(){return this.name;}
    private void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    private void setRarity(String rarity) {
        this.rarity = rarity;
    }

    //endregion
    @Override
    public abstract String toString() ;
}

