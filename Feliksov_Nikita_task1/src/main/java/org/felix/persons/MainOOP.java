package org.felix.persons;

import org.felix.persons.model.Person;
import org.felix.persons.service.Service;
import org.felix.persons.utils.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainOOP {
    private interface Exec {
        void exec(List<Person> data) throws Exception;
    }

    private static class MenuItem {
        private String name;
        private Exec exec;

        public Exec getExec() {
            return exec;
        }

        public String getName() {
            return name;
        }
    }

    private static class Menu {
        private List<MenuItem> items = new ArrayList<>(10);
        List<Person> personList = new ArrayList<>();
        Service service = new Service();
        Parser parser = new Parser();

        public Menu(Scanner scanner) throws Exception {
            parser.menuOOP();
            MenuItem element = new MenuItem();
            element.name = "addFromIO";
            element.exec = (personList) -> {
                service.addPersonsFromIO();
            };
            items.add(element);
            element = new MenuItem();
            element.name = "Sorter";
            element.exec = (personList) -> {
                service.sorter();
            };
            items.add(element);
            element = new MenuItem();
            element.name = "ADD";
            element.exec = (personList) -> {
                String[] s = scanner.nextLine().split(" ");
                if (s.length != 2) {
                    System.out.println("Incorrect data!Breaking...");
                } else {
                    Person person = new Person(s);
                    service.addPerson(person);
                }
            };
            items.add(element);
            element = new MenuItem();
            element.name = "SHOW";
            element.exec = (personList) -> {
                service.showPersons();
            };
            items.add(element);
            element = new MenuItem();
            element.name = "EXIT";
            element.exec = (personList) -> {
                service.exit();
            };
            items.add(element);
            element = new MenuItem();
            element.name = "SortUnique";
            element.exec = (personList) -> {
                service.sorterUnique();
            };
            items.add(element);
            element = new MenuItem();
            element.name = "SaveFile";
            element.exec = (personList) -> {
                service.saveToFile();
            };
            items.add(element);
            element = new MenuItem();
            element.name = "Menu";
            element.exec = (personList) -> {
                parser.menuOOP();
            };
            items.add(element);
            element = new MenuItem();
            element.name = "ReadFile";
            element.exec = (personList) -> {
                service.readFromFile();
            };
            items.add(element);
            element = new MenuItem();
            element.name = "ClearData";
            element.exec = (personList) -> {
                service.clearDataInMemory();
            };
            items.add(element);
            while (true) {
                int i = 0;
                String s = scanner.nextLine();
                for (MenuItem item : items) {
                    if (item.getName().equals(s)) {
                        i = 1;
                        item.exec.exec(personList);
                        break;
                    }
                }
                if (i == 0) {
                    System.out.println("Не могу это выполнить, у меня лапки");
                }
                if (false) {
                    break;
                }
            }
        }
    }
        public static void main(String[] args) throws Exception {
            Service service = new Service();
            Scanner scanner = new Scanner(System.in);
            if (args.length == 2) {
                service.addPersonsWithArgs(args);//  первое задание  выполнил отдельно от меню так как в меню не передаюься по заданию argc а только сканнер
            } else {
                System.out.println("Invalid arguments");
            }
            Menu menu = new Menu(scanner);// вызов меню интерактивного с выпонением задач остальных
        }
    }