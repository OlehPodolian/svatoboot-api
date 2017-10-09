package oleg.podolyan.svatoapiboot.domain.enums;

public enum Range {

    LOCAL, REGIONAL, NATIONAL;

    public static Range getRange(String value){
        switch (value){
            case "REGIONAL": return REGIONAL;
            case "NATIONAL": return NATIONAL;
            default: return LOCAL;
        }
    }
}
