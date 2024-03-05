package edu.neumont.csc150.model.character;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:42 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public enum Race {//We can add more races, but each race has different racial skill so do over do it yet
    HUMAN("Human"),
    ELF("Elf"),
    DRAGON_BORN("Dragon Born"),
    DWARF("Dwarf"),
    DEFAULT("Default");

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
