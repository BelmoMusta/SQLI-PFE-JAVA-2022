package org.sqli.authentification.entitie;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USER_GROUP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

}
