package oleg.podolyan.svatoapiboot.domain;

import oleg.podolyan.svatoapiboot.domain.enums.EntrepreneurType;

public class Entrepreneur extends Visitor{

    private EntrepreneurType type = EntrepreneurType.VOLUNTEER;

    private Entrepreneur() { }

    public EntrepreneurType getType() {
        return type;
    }

    public void setType(EntrepreneurType type) {
        this.type = type;
    }

    public static Entrepreneur getInstance() {
        return new Entrepreneur();
    }
}
