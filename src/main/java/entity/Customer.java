package entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

// JavaEE   ->  javax
// JakartaEE -> jakarta

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

@Entity // Customer
@Table(name = "customer_table")
// (DB name,table name, column name) customer_table_test
public class Customer {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // IDENTITY - auto increment
    // AUTO - JPA picks best strategy based on database dialect
    // SEQUENCE - using database SEQUENCE
    private int id;

    // customize column
    @Column(
            name = "customer_name",
            nullable = false,
            // (nullable) can null - true (default), can't null - false
            unique = true, // no duplicate date
            length = 100 // varchar(100)
    )
    private String name;

    @Embedded
    private FullName fullName;

    private double weight;

    // 100.00, 500.999
    @Column(precision = 9, scale = 2) // 123456789.11
    private BigDecimal price;

    // java.sql.Date
    private Date date;

    private boolean isTrue;
//    Boolean

    // image - binary data (BASE64)
    // large data (text or binary data)
    @Lob // text, clob, longtext
    @Column(columnDefinition = "TEXT")
    private String address;

    @Transient // non persistent, npt save in database
    private String debitCardNumber;

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
