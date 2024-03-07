package com.nicosandoval.SpringSecurity.persistence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "email"}) })
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private String email;
    @Setter
    @Getter
    private String password;

    public UserEntity(Long user_Id, String firstName, String lastName, String email, String password) {
        this.userId = user_Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserEntity() {
    }

    public Long getUser_Id() {
        return userId;
    }

    public void setUser_Id(Long user_Id) {
        this.userId = user_Id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserEntity(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


}
