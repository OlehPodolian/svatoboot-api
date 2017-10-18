package oleg.podolyan.svatoapiboot.domain.security;

import oleg.podolyan.svatoapiboot.domain.User;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class AppAdmin extends User implements Serializable{

    private String firstName;
    private String lastName;
}
