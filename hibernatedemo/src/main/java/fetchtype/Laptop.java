package fetchtype;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {

    @Id
    private int id;

    @Column
    private String brand;

    @Column
    private int price;

    @ManyToOne
    private Alien alien;

    public Laptop(int id, String brand, int price) {
        this.id = id;
        this.brand = brand;
        this.price = price;
    }

    public Laptop() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Alien getAlien() {
        return alien;
    }

    public void setAlien(Alien alien) {
        this.alien = alien;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
