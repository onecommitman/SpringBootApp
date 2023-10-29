package ru.onecommitman.springcourse.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Table(name = "users")
@Entity
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Name shouldn't be empty")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё]+$", message = "The name must consist of letters only!")
    @Size(min = 2, max = 30, message = "The name should be between 2 and 30 characters")
    private String name;

    @Column(name = "lastName")
    @NotEmpty(message = "Surname shouldn't be empty")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё]+$", message = "The surname must consist of letters only!")
    @Size(min = 2, max = 30, message = "The surname should be between 2 and 30 characters")
    private String lastName;

    @Column(name = "age")
    @NotNull(message = "Shouldn't be empty!")
    @Min(value = 18, message = "Must be over 18 years of age!")
    private Byte age;

    public User() {

    }


    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        //this.setId(++ID_COUNTER);
        System.out.println("ID = " + id);
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return '\n' + "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}