package seminar1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FamilyTree {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public Person findPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getChildren(Person parent) {
        return parent.getChildren();
    }

    public List<Person> getSpouses(Person person) {
        return people;
    }
    public List<Person> getSiblings(Person person) {
        return people;
    }
}
