package relations.manytomany;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
}
