package seminar1;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Person ivanIvanov = new Person("Ivan", "Ivanov", 44, "male");
        Person marinaIvanova = new Person("Marina", "Ivanova", 40, "female");

        Person petrIvanov = new Person("Petr", "Ivanov", 22, "male");
        Person svetlanaIvanova = new Person("Svetlana", "Ivanova", 10, "female");

        Person galinaPetrova = new Person("Galina", "Petrova", 60, "female");

        ivanIvanov.addChildren(petrIvanov);
        ivanIvanov.addChildren(svetlanaIvanova);
        marinaIvanova.addChildren(petrIvanov);
        marinaIvanova.addChildren(svetlanaIvanova);
        galinaPetrova.addChildren(marinaIvanova);

        marinaIvanova.setMother(galinaPetrova);
        petrIvanov.setMother(marinaIvanova);
        svetlanaIvanova.setMother(marinaIvanova);
        petrIvanov.setFather(ivanIvanov);
        svetlanaIvanova.setFather(ivanIvanov);

        familyTree.addPerson(ivanIvanov);
        familyTree.addPerson(marinaIvanova);
        familyTree.addPerson(petrIvanov);
        familyTree.addPerson(svetlanaIvanova);
        familyTree.addPerson(galinaPetrova);

        List<Person> list = familyTree.getChildren(ivanIvanov);
        for (Person person : list) {
            System.out.println(person.getName());
        }



    }
}
