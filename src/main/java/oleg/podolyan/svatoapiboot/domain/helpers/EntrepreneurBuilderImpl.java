package oleg.podolyan.svatoapiboot.domain.helpers;

import oleg.podolyan.svatoapiboot.domain.Entrepreneur;
import oleg.podolyan.svatoapiboot.domain.enums.EntrepreneurType;
import oleg.podolyan.svatoapiboot.domain.enums.Range;
import oleg.podolyan.svatoapiboot.domain.enums.RoleType;
import oleg.podolyan.svatoapiboot.domain.security.Role;
import oleg.podolyan.svatoapiboot.domain.security.UserRole;

public class EntrepreneurBuilderImpl implements VisitorBuilder<Entrepreneur>{

    @Override
    public Entrepreneur build(String username, String password, String title,
                              String locality, String range, String contactDetails,
                              String type) {
        Entrepreneur entrepreneur = Entrepreneur.getInstance();
        entrepreneur.setEnabled(false);
        entrepreneur.setUsername(username);
        entrepreneur.setPassword(password);
        entrepreneur.setTitle(title);
        entrepreneur.setLocality(locality);
        entrepreneur.setRange(Range.getRange(range));
        entrepreneur.setContactDetails(contactDetails);
        entrepreneur.setType(EntrepreneurType.getType(type));
        entrepreneur.getUserRoles().add(new UserRole(entrepreneur, new Role(RoleType.ROLE_ENTREPRENEUR.toString())));
        return entrepreneur;
    }


}
