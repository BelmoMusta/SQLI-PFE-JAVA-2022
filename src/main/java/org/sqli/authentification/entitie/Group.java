package org.sqli.authentification.entitie;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private String id;
    private String name;
}
