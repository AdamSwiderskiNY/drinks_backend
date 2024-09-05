
package ch.noseryoung.drinks.authority;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Entity
@Getter
@Setter
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private int roleId;

    @Column(name = "authority_name")
    @NotNull
    @Length(min = 2, max = 20)
    private String name;

    public Authority(int roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public Authority() {

    }
}
