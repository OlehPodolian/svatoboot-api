package oleg.podolyan.svatoapiboot.domain.enums;

public enum RoleType {

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");

    private final String value;

    private RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public RoleType getRoleType(String roleName){
        switch (roleName){
            case "ROLE_ADMIN"   : return ROLE_ADMIN;
            default             : return ROLE_USER;
        }
    }


}
