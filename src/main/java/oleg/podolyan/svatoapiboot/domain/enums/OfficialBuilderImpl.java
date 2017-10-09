package oleg.podolyan.svatoapiboot.domain.enums;

import oleg.podolyan.svatoapiboot.domain.Official;
import oleg.podolyan.svatoapiboot.domain.helpers.VisitorBuilder;
import oleg.podolyan.svatoapiboot.domain.security.Role;
import oleg.podolyan.svatoapiboot.domain.security.UserRole;

public class OfficialBuilderImpl implements VisitorBuilder<Official> {

    @Override
    public Official build(String username, String password,
                          String title, String locality,
                          String range, String contactDetails,
                          String type) {
        Official official = Official.getInstance();
        official.setUsername(username);
        official.setEnabled(false);
        official.setPassword(password);
        official.setTitle(title);
        official.setLocality(locality);
        official.setContactDetails(contactDetails);
        official.setRange(Range.getRange(range));
        official.setType(OfficialType.getType(type));
        official.getUserRoles().add(new UserRole(official, new Role(Roles.ROLE_OFFICIAL.toString())));
        return official;
    }
}
