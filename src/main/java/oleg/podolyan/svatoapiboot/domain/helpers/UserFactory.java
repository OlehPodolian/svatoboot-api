package oleg.podolyan.svatoapiboot.domain.helpers;

import oleg.podolyan.svatoapiboot.domain.User;
import oleg.podolyan.svatoapiboot.domain.Visitor;

public interface UserFactory<T extends User> {

    T create(String username, String password,
                   String title, String locality, String range, String contactDetails,
                   String type, VisitorBuilder builder);
}
