package edu.neumont.csc150.model;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:42 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public enum Race {
    HUMAN("Human"),
    ELF("Elf"),
    DRAGON_BORN("Dragon Born"),
    DWARF("Dwarf");

    private String friendlyName = "";
    Race(String friendlyName){
        setFriendlyName(friendlyName);
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    private void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }
}
