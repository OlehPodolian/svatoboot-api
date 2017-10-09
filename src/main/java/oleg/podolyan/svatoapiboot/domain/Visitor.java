package oleg.podolyan.svatoapiboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import oleg.podolyan.svatoapiboot.domain.enums.Range;
import oleg.podolyan.svatoapiboot.domain.security.Authority;
import oleg.podolyan.svatoapiboot.domain.security.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Visitor extends User {

    private String title;
    private String locality;
    private Range range = Range.LOCAL;
    private String contactDetails;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}
