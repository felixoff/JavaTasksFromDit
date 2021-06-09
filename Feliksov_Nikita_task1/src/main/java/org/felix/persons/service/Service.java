package org.felix.persons.service;

import org.felix.persons.utils.Parser;
import org.felix.persons.utils.PersonComparator;
import org.felix.persons.model.Person;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Service {
    private List<Person> persons;
    private static String path = "src/main/resources/persons.txt";
    public Service(){
        Parser p = new Parser();
        persons = p.getPersons();
    }

    public void addPersonsWithArgs(String[] args)  {
        System.out.println("task addPersonsWithArgs");
        Person person = new Person(args);
        System.out.println(person.toString());
    }
    public void addPersonsFromIO()  {
        System.out.println("task addPersonsFromIO");
        Scanner scan = new Scanner(System.in);
        String[] s = {""};
        int i = 1;
        while (s != null) {
            s =scan.nextLine().split(" ");
            if (s.length != 2) {
                System.out.println("Incorrect data!Breaking...");
                break;
            }
            persons.add(new Person(s));
        }
        for (Person human : persons) {
            System.out.println(human.toString());
        }
    }
    public void addPerson(Person person)  {
            System.out.println("task ADD");
            persons.add(person);
        }
    public List<Person> getPersons() {
        return persons;
    }
    public void showPersons() {
        System.out.println("task SHOW");
        for (Person human : persons) {
            System.out.println(human.toString());
        }
    }
    public  void sorter() {
        System.out.println("task sorter");
        Collections.sort(persons, new PersonComparator());
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
    public  void exit() {
        System.exit(0);
    }
    public  void sorterUnique() {
        System.out.println("task sorterUnique");
        Collections.sort(persons, new PersonComparator());
        List<Person> persons_cpy =  removeDuplicates(persons);
        for (Person person : persons_cpy) {
            System.out.println(person.toString());
        }
    }

    private static String uniqueAttributes(Person person){
        return (person.getLastName());
    }
    public static List<Person> removeDuplicates(final List<Person> persons) {
        return persons.stream().collect(Collectors
                .collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(
                        Service::uniqueAttributes))),
                        ArrayList::new));
    }

    public  void saveToFile() throws IOException {
        System.out.println("task saveToFile");
        FileWriter writer = new FileWriter(path);
        for(Person person : persons) {
            writer.write(person.getFirstName() + ";" + person.getLastName() + "\n");
        }
        writer.close();
    }

    public void readFromFile() throws FileNotFoundException {
        System.out.println("task readFromFile");
        File file = new File(path);
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String[] s1 = scan.nextLine().split(";");
            Person person = new Person(s1);
            System.out.println(person.toString());
            persons.add(person);
        }
    }

    public void clearDataInMemory(){
        System.out.println("task clearDataInMemory");
        persons.clear();
    }

}