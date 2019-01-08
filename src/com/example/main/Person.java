package com.example.main;

import java.io.Serializable;

/**
 * Created by ls on 18/6/20.
 */
public class Person implements Serializable {
    private String name = "ls";
    private int age = 10;
    private transient String password;

    public Person() {
    }

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void say() {
        System.out.println("private say()");
    }

    public void work() {
        System.out.println("public work()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            return name.equals(((Person) obj).getName()) && age == ((Person) obj).getAge();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
