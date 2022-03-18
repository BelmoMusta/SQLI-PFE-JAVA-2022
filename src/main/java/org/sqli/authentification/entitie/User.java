package org.sqli.authentification.entitie;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    private String login;
    private String password;
    private boolean enabled;

    @Column(name="loginattempts")
    private int loginAttempts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group myGroup;


    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User() {

    }
}
