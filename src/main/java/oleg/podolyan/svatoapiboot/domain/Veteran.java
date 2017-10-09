package oleg.podolyan.svatoapiboot.domain;

import javax.persistence.ElementCollection;
import java.util.HashSet;
import java.util.Set;

public class Veteran extends User {

    private String firstName;
    private String lastName;

    @ElementCollection
    private Set<Long> friends = new HashSet<>();
    @ElementCollection
    private Set<Long> projects = new HashSet<>();

    @ElementCollection
    private Set<Long> appointments = new HashSet<>();
    @ElementCollection
    private Set<Long> rejectedPublishers = new HashSet<>();
}
