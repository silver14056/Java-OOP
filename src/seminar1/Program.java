package seminar1;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Person ivanIvanov = new Person("Ivan", "Ivanov", 1985, "male");
        Person marinaIvanova = new Person("Marina", "Ivanova", 1991, "female");

        Person petrIvanov = new Person("Petr", "Ivanov", 2011, "male");
        Person svetlanaIvanova = new Person("Svetlana", "Ivanova", 2015, "female");

        Person galinaPetrova = new Person("Galina", "Petrova", 1960, "female");
        galinaPetrova.setSurname("Milanova");
        Person ivanSerov = new Person("Ivan", "Serov", 1974, "male");

        ivanIvanov.addChildren(petrIvanov);
        ivanIvanov.addChildren(svetlanaIvanova);
        marinaIvanova.addChildren(petrIvanov);
        marinaIvanova.addChildren(svetlanaIvanova);
        galinaPetrova.addChildren(marinaIvanova);

//        marinaIvanova.setMother(galinaPetrova);
//        petrIvanov.setMother(marinaIvanova);
//        svetlanaIvanova.setMother(marinaIvanova);
//        petrIvanov.setFather(ivanIvanov);
//        svetlanaIvanova.setFather(ivanIvanov);

        familyTree.addPerson(ivanIvanov);
        familyTree.addPerson(marinaIvanova);
        familyTree.addPerson(petrIvanov);
        familyTree.addPerson(svetlanaIvanova);
        familyTree.addPerson(galinaPetrova);
        familyTree.addPerson(ivanSerov);

        List<Person> list = familyTree.getChildren(ivanIvanov);
        for (Person person : list) {
            System.out.println(person.getName());
        }
        System.out.println(familyTree.findPersonByName("Ivan"));
        System.out.println(familyTree.findPersonByName("Ivan", "Serov"));
        System.out.println(svetlanaIvanova.getFather().getName() + "-father " + svetlanaIvanova.getMother().getName() + "-mother");

        for (Person child: familyTree.getSiblings(petrIvanov)) {
            System.out.println(child.getName() + " " + child.getSurname());
        }

        for (Person person : familyTree.getOlder(1990)) {
            System.out.println(person.getName() + " " + person.getSurname() + " older");
        }

        // Создаем объект для работы с файлами
        FileOperations fileOps = new FileOperationsImpl();
// Сохраняем генеалогическое древо в файл
        try {
            fileOps.saveToFile(familyTree, "src\\seminar1\\familyTree.dat");
            System.out.println("Family tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
// Загружаем генеалогическое древо из файла
        FamilyTree loadedFamilyTree = null;
        try {
            loadedFamilyTree =
                    fileOps.loadFromFile("src\\seminar1\\familyTree.dat");
            System.out.println("Family tree loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
// Проверяем, что древо загрузилось правильно
        if (loadedFamilyTree != null) {
            for (Person person : loadedFamilyTree.getPeople()) {
                System.out.println("Loaded person: " +
                        person.getName() + ", born in " + person.getBirthYear());
            }
        }


    }
}
