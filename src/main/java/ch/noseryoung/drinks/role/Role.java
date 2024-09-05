package ch.noseryoung.drinks.role;

import ch.noseryoung.drinks.authority.Authority;
import ch.noseryoung.drinks.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_name")
    @NotNull
    @Length(min = 2, max = 20)
    private String name;

    @JoinTable(name = "role_authority", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Authority> authorities;

    @OneToMany(mappedBy = "role")
    private Set<User> users;

    public Role(int roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public Role() {}
}
