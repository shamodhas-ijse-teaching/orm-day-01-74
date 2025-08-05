package entity;


import jakarta.persistence.*;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.com
 * --------------------------------------------
 * Created: 8/5/2025 10:41 AM
 * Project: orm-start
 * --------------------------------------------
 **/

@Entity
@Table(name = "customer_table")
// customer_table
public class Customer {
    @Id
    private int id;

    private String name;

    public Customer() {
    }

    public Customer(int id, String name) {
        this.name = name;
        this.id = id;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
