package org.felix.api;

import org.felix.api.UserCrud;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class BusinessLogic {
    private List<Queue> queues;
    private static UserCrud base;

    public BusinessLogic() throws FileNotFoundException {
        base = new UserCrud();
    }

    public BusinessLogic(String s) throws FileNotFoundException {
        base = new UserCrud();
    }

    public static String getAlphaNumericString(int n) {
        String AlphaNumericString = "0123456789";

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

//    public static void createTable() throws SQLException {
//        base.createUser();
//    }
//
//    public static void insertInTable(Queue queue) throws SQLException {
//        base.insertUser(queue);
//    }
//
    public static String insertInCard(Queue queue) throws SQLException {
        return base.insertCard(queue);
    }

//    public static String updateBalance(Queue queue) throws SQLException {
//        return base.updateBalance(user);
//    }

//    public static String perevod(Users users) throws SQLException {
//        return base.perevod(users);
//    }

//    public static String showCards() throws SQLException {
//        return base.watchCards();
//    }
//
//    public static String checkBalance(Queue queue) throws SQLException {
//        return base.checkBalance(queue);
//    }

//    public static void deleteInTable(Queue queue) throws SQLException {
//        base.deleteUser(queue);
//    }
//
//    public static void updateInTable(Queue queue) throws SQLException {
//        base.updateUser(queue);
//    }
//
//    public static void readFromTable(Queue queue) throws SQLException {
//        base.readUser(queue);
//    }

//    public static void display(List<Queue> queues) {
//        System.out.println("display");
//        for (Queue queue : queues) {
//            System.out.println(queue.toString());
//        }
//    }
//
//    public static void sorter(List<Queue> queues) {
//        System.out.println("sorter 2.1");
//        Collections.sort(queues, new QueueComparator());
//        for (Queue queue : queues) {
//            System.out.println(queue.toString());
//        }
//    }
//
//    public static void maxPop(List<User> cities) {
//        System.out.println("maxPop");
//    }
//
//    public static void kolNameInReg(List<User> cities) {
//        System.out.println("kolNameInReg");
//
//    }
//
//    public List<Queue> getUsers() {
//        return queues;
//    }

}
