package oleg.podolyan.svatoapiboot.domain.helpers;

import oleg.podolyan.svatoapiboot.domain.Visitor;

public interface VisitorBuilder<T extends Visitor> {

    T build(String username, String password,
            String title, String locality,
            String range, String contactDetails, String type);
}
