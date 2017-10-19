package oleg.podolyan.svatoapiboot.domain.enums;

public enum UserType {

    VETERAN("VETERAN"),
    OFFICIAL("OFFICIAL"),
    VOLUNTEER("VOLUNTEER"),
    ENTREPRENEUR("ENTREPRENEUR"),
    OTHER("OTHER");

    private final String value;

    UserType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UserType getUserType(String value){
        switch (value){
            case "VETERAN"      : return VETERAN;
            case "OFFICIAL"     : return OFFICIAL;
            case "VOLUNTEER"    : return VOLUNTEER;
            case "ENTREPRENEUR" : return ENTREPRENEUR;
            default             : return OTHER;
        }
    }

    public static String [] getUserTypesInUa(){
        return new String[] {"Ветеран АТО", "Держустанова", "Волонтер", "Підприємець", "Інше",};
    }

    public static UserType getUserTypeFromUa(String value){
        switch (value){
            case "Ветеран АТО"  : return VETERAN;
            case "Держустанова" : return OFFICIAL;
            case "Волонтер"     : return VOLUNTEER;
            case "Підприємець"  : return ENTREPRENEUR;
            default             : return OTHER;
        }
    }
}
