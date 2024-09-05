package ch.noseryoung.drinks.user;

import ch.noseryoung.drinks.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "users")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "name")
    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @Column(name = "password")
    @NotNull
    @Size(min = 5, max = 16)
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_role", referencedColumnName = "role_id")
    private Role role;
    public User (int userId, String name, String password, Role role) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User() {

    }
}