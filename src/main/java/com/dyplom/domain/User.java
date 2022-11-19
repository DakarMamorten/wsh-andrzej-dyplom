package com.dyplom.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "user", orphanRemoval = true)
    private List<Request> requests = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Role role;
    private String username;
    private String password;

    public User(Role role, String username, String password) {
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public User(Role role, String username) {
        this.role = role;
        this.username = username;
    }

}
