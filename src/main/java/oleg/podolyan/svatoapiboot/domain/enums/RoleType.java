package oleg.podolyan.svatoapiboot.domain.enums;

public enum RoleType {

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER"),
    ROLE_VETERAN("ROLE_VETERAN"),
    ROLE_OFFICIAL("ROLE_OFFICIAL"),
    ROLE_ENTREPRENEUR("ROLE_ENTREPRENEUR"),
    ROLE_GUEST("ROLE_GUEST");

    private final String value;

    private RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public RoleType getRoleType(String roleName){
        switch (roleName){
            case "ROLE_ADMIN"           : return ROLE_ADMIN;
            case "ROLE_USER"            : return ROLE_USER;
            case "ROLE_VETERAN"         : return ROLE_VETERAN;
            case "ROLE_OFFICIAL"        : return ROLE_OFFICIAL;
            case "ROLE_ENTREPRENEUR"    : return ROLE_ENTREPRENEUR;
            default                     : return ROLE_GUEST;
        }
    }


}
