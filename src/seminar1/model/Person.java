package seminar1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private int birthYear;
    private Person father;
    private Person mother;
    private List<Person> children;
    private String gender;

    public Person(String name, String surname, int birthYear, String gender) {
        this.name = name;
        this.birthYear = birthYear;
        this.surname = surname;
        this.gender = gender;
        this.children = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public List<Person> getChild() {
        return children;
    }

    public void addChildren(Person child) {
        this.children.add(child);
        if (this.getGender().equals("male")) {
            child.setFather(this);
        } else {
            child.setMother(this);
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + birthYear + " " + gender;
    }
}
