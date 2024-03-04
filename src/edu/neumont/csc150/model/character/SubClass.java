package edu.neumont.csc150.model.character;

public enum SubClass {

    THIEF("Thief"),
    ELF("Assassin"),
    Swashbuckler("Swashbuckler"),
    DWARF("Dwarf");

    private String subClassName = "";
    SubClass(String subClassName){
        setSubClassName(subClassName);
    }

    public String getName() {
        return subClassName;
    }

    private void setSubClassName(String subClass) {
        this.subClassName = subClass;
    }
}
