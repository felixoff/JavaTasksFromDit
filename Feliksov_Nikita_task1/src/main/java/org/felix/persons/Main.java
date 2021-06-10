package org.felix.persons;

import org.felix.persons.model.Person;
import org.felix.persons.service.Service;
import org.felix.persons.utils.Parser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Service service = new Service();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        parser.menu();
        List<Person> persons = new ArrayList<>();
        int i = 1;
        while (i != 0) {
            i = scanner.nextInt();
            switch (i) {
                case 0:
                    if (args.length == 2) {
                        service.addPersonsWithArgs(args);
                    } else {
                        System.out.println("Invalid arguments");
                    }
                    break;
                case 1:
                    service.addPersonsFromIO();
                    break;
                case 2:
                    service.sorter();
                    break;
                case 3:
                    String[] s = scanner.nextLine().split(" ");
                    if (s.length != 2) {
                        System.out.println("Incorrect data!Breaking...");
                        break;
                    }
                    Person person = new Person(s);
                    service.addPerson(person);
                    break;
                case 4:
                    service.showPersons();
                    break;
                case 5:
                    i = 0;
                    break;
                case 6:
                    service.sorterUnique();
                    break;
                case 7:
                    service.saveToFile();
                    break;
                case 8:
                    parser.menu();
                    break;
                case 9:
                    service.readFromFile();
                    break;
                case 10:
                    service.clearDataInMemory();
                    break;
                default:
                    System.out.println("Не могу это выполнить, у меня лапки");
            }
        }
    }
}