package demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alien")
public class Alien {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private AlienName name;
    @Column(name = "color")
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int aid) {
        this.id = aid;
    }

    public AlienName getName() {
        return name;
    }

    public void setName(AlienName name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "demo.Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
