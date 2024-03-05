package edu.neumont.csc150.model.character;

public enum SubClass {
    THIEF("Thief"),
    ASSASSIN("Assassin"),
    Swashbuckler("Swashbuckler"),
    TRICKSTER("Trickster"),
    ROUGE("Rouge"),
    WIZARD("Wizard"),
    PYROMANCER("Pyromancer"),
    AEROMANCER("Aeromancer"),
    GRAVOMANCER("GRAVOMANCER"),
    WARRIOR("Warrior"),
    SAMURAI("Samurai"),
    ARCANEARCHER("Arcane Archer"),
    RANGER("RANGER"),
    MONSTERSLAYER("MonsterSlayer");





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
