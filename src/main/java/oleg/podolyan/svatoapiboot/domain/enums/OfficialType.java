package oleg.podolyan.svatoapiboot.domain.enums;

public enum OfficialType {

    MEDICAL_STATE, MEDICAL_OTHER, SOCIAL_SECURITY, COMMISSARIAT, OTHER;

    public static OfficialType getType(String type) {
        switch (type){
            case "MEDICAL_STATE": return MEDICAL_STATE;
            case "MEDICAL_OTHER": return MEDICAL_OTHER;
            case "SOCIAL_SECURITY": return SOCIAL_SECURITY;
            case "COMMISSARIAT": return COMMISSARIAT;
            default: return OTHER;
        }
    }
}
