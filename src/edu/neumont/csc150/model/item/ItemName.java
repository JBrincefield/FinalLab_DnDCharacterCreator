package edu.neumont.csc150.model.item;

/**
 * @author jbrincefield
 * @createdOn 3/3/2024 at 2:06 PM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public enum ItemName {
    SWORD("Sword"),
    ROPE("Rope"),
    BEDROLL("Bedroll"),
    MESS_KIT("Mess Kit"),
    TINDER_BOX("Tinder Box"),
    TORCH("Torch"),
    RATION("Ration"),
    WATER_SKIN("Water Skin");

    String friendlyName = "";
    ItemName(String friendlyName){
        setFriendlyName(friendlyName);
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    private void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }
}
