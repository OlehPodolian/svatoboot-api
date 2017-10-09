package oleg.podolyan.svatoapiboot.domain.enums;

public enum EntrepreneurType {

    VOLUNTEER, COMMERCIAL, OTHER;

    public static EntrepreneurType getType(String type) {
        switch (type){
            case "VOLUNTEER" : return VOLUNTEER;
            case "COMMERCIAL" : return  COMMERCIAL;
            default: return OTHER;
        }
    }
}
