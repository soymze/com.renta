package com.renta.renta.entities;

import com.renta.renta.core.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends BaseEntity<Integer> {

    @Column(name="username")
    @NotNull(message = "name may not be null")
    private String username;
    @Column(name="password")
    @NotNull(message = "password may not be null")
    private String password;
    @Column(name="mail")
    @NotNull(message = "mail may not be null")
    private String mail;

    private String role;
}
