package seminar1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
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

    public Person findPersonByName(String name, String surname) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                if (person.getSurname().equals(surname)) {
                    return person;
                }
            }
        }
        return null;
    }

    public List<Person> getChildren(Person parent) {
        return parent.getChild();
    }


    public List<Person> getSiblings(Person person) {
        List<Person> siblings = new ArrayList<>();
        for (Person child: person.getMother().getChild()) {
            if (child.getName().equals(person.getName())) {
                continue;
            }
            siblings.add(child);
        }
        return siblings;
    }

    public List<Person> getOlder(int birthYear) {
        List<Person> older = new ArrayList<>();
        for (Person person : people) {
            if (person.getBirthYear() < birthYear) {
                older.add(person);
            }
        }
        return older;
    }
}
