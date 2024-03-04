package edu.neumont.csc150.model.skills;

public enum SkillList {
    SWORD("Sword"),
    ROPE("Rope"),
    BEDROLL("Bedroll"),
    MESS_KIT("Mess Kit"),
    TINDER_BOX("Tinder Box"),
    TORCH("Torch"),
    RATION("Ration"),
    WATER_SKIN("Water Skin");

    String skillName = "";
    SkillList(String friendlyName){
        setSkillName(skillName);
    }

    public String getSkillName() {
        return skillName;
    }

    private void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
