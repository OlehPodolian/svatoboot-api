package oleg.podolyan.svatoapiboot.domain;

import oleg.podolyan.svatoapiboot.domain.security.UserRole;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Group implements Serializable {

    private static final long serialVersionUID = 121212453465L;

    private Long groupId;

    private String title;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserGroup> userGroups = new HashSet<>();

    private Group(){}

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (getGroupId() != null ? !getGroupId().equals(group.getGroupId()) : group.getGroupId() != null) return false;
        return getTitle().equals(group.getTitle());
    }

    @Override
    public int hashCode() {
        int result = getGroupId() != null ? getGroupId().hashCode() : 0;
        result = 31 * result + getTitle().hashCode();
        return result;
    }
}
