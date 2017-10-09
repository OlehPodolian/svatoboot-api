package oleg.podolyan.svatoapiboot.domain;

import oleg.podolyan.svatoapiboot.domain.enums.OfficialType;

public class Official extends Visitor {

    private OfficialType type;

    @Override
    public String getType() {
        return type.toString();
    }

    public void setType(OfficialType type) {
        this.type = type;
    }

    public static Official getInstance() {
        return new Official();
    }
}
