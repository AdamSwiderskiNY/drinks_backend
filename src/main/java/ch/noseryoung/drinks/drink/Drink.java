package ch.noseryoung.drinks.drink;

import jakarta.persistence.*;

@Entity
@Table(name="drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="drinks_id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private Float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
