package oleg.podolyan.svatoapiboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import oleg.podolyan.svatoapiboot.domain.security.Authority;
import oleg.podolyan.svatoapiboot.domain.security.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public abstract class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 4444L;

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Long userId;
    private String username;
    private String password;
//    private String firstName;
//    private String lastName;
    private String phone;
    private String email;
    private String locality;

    private String iconPath;

    private boolean enabled = true; // Change in production
    private boolean phoneDisplayed = true;

    private LocalDate dob;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

//    @ElementCollection
//    private Set<Long> friends = new HashSet<>();
//    @ElementCollection
//    private Set<Long> projects = new HashSet<>();
    @ElementCollection
    private Set<String> tags = new HashSet<>();
//    @ElementCollection
//    private Set<Long> appointments = new HashSet<>();
//    @ElementCollection
//    private Set<Long> rejectedPublishers = new HashSet<>();


//    protected User(){}
//
//    public static User getInstance(){
//        return new User();
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        userRoles.forEach(userRole -> authorities.add(new Authority(userRole.getRole().getName())));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isPhoneDisplayed() {
        return phoneDisplayed;
    }

    public void setPhoneDisplayed(boolean phoneDisplayed) {
        this.phoneDisplayed = phoneDisplayed;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

//    public Set<Long> getFriends() {
//        return friends;
//    }
//
//    public void setFriends(Set<Long> friends) {
//        this.friends = friends;
//    }
//
//    public Set<Long> getProjects() {
//        return projects;
//    }
//
//    public void setProjects(Set<Long> projects) {
//        this.projects = projects;
//    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

//    public Set<Long> getAppointments() {
//        return appointments;
//    }
//
//    public void setAppointments(Set<Long> appointments) {
//        this.appointments = appointments;
//    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

//    public Set<Long> getRejectedPublishers() {
//        return rejectedPublishers;
//    }
//
//    public void setRejectedPublishers(Set<Long> rejectedPublishers) {
//        this.rejectedPublishers = rejectedPublishers;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getUserId() != null ? !getUserId().equals(user.getUserId()) : user.getUserId() != null) return false;
        if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
            return false;
        return getEmail() != null ? getEmail().equals(user.getEmail()) : user.getEmail() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserId() != null ? getUserId().hashCode() : 0;
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }
}
