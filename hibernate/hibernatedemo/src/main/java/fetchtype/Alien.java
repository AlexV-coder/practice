package fetchtype;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Alien {

    @Id
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "alien")
    private List<Laptop> laptops = new ArrayList<>();

    public Alien() {

    }
    public Alien(int id, String name, List<Laptop> laptops) {
        this.id = id;
        this.name = name;
        this.laptops = laptops;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}
