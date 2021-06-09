package org.felix.persons.utils;

import org.felix.persons.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<Person> persons;
    public Parser() {
        persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public static void menuOOP()
    {
        System.out.println("Hello friend!Please enter a number");
        System.out.println("addFromIO");
        System.out.println("Sorter");
        System.out.println("ADD");
        System.out.println("SHOW");
        System.out.println("EXIT");
        System.out.println("SortUnique");
        System.out.println("SaveFile");
        System.out.println("Menu");
        System.out.println("ReadFile");
        System.out.println("ClearData");
    }

    public static void menu()
    {
        System.out.println("Hello friend!Please enter a number");
        System.out.println("0-addWithArgs");
        System.out.println("1-addFromIO");
        System.out.println("2-Sorter");
        System.out.println("3-ADD");
        System.out.println("4-SHOW");
        System.out.println("5-EXIT");
        System.out.println("6-SortUnique");
        System.out.println("7-SaveFile");
        System.out.println("8-Menu");
        System.out.println("9-ReadFile");
        System.out.println("10-ClearData");
    }

}
