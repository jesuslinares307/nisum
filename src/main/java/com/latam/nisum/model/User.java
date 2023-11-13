package com.latam.nisum.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(length = 300)
    private UUID id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Phone> phones;

    @Column
    private LocalDate created;

    @Column
    private LocalDate modified;

    @Column(name = "last_login")
    private LocalDate lastLogin;

    @Column(length = 600)
    private String token;

    @Column(name = "is_active")
    private boolean isActive;

}
