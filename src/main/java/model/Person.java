package model;

import java.util.Objects;

public abstract class Person {
    private String name;
    private double customerWallet;
    private String id;
    private int yearsOfExperience;
    private int age;

    public Person(String name, double customerWallet) {
        this.name = name;
        this.customerWallet = customerWallet;
    }


    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Person(String name, int yearsOfExperience, int age) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public double getCustomerWallet() {
        return customerWallet;
    }

    public String getId() {
        return id;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public int getAge() {
        return age;
    }

    public void setCustomerWallet(double customerWallet) {
        this.customerWallet = customerWallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Double.compare(person.getCustomerWallet(), getCustomerWallet()) == 0 && getYearsOfExperience() == person.getYearsOfExperience() && getAge() == person.getAge() && getName().equals(person.getName()) && getId().equals(person.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCustomerWallet(), getId(), getYearsOfExperience(), getAge());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", customerWallet=" + customerWallet +
                ", id='" + id + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", age=" + age +
                '}';
    }
}
