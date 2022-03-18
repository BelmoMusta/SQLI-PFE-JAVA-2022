package org.sqli.authentification.entitie;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private int id;

  @Column(name = "LOGIN")
  private String login;

 @Column(name = "PASSWORD")
  private String password;

 @Column(name = "ENABLED")
  private boolean enabled;

  @Column(name = "LOGINATTEMPTS")
  private int loginAttempts;

  @OneToOne
  @JoinColumn(name ="GROUP_ID")
  private Group userGroup;

}
