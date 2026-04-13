/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Student
 */
import java.util.Scanner;
 
public class Question2a {

public class LoginSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Registration
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Create username: ");
        String username = input.nextLine();

        System.out.print("Create password: ");
        String password = input.nextLine();

        if (checkUsername(username)) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted.");
            return;
        }

        if (checkPassword(password)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted.");
            return;
        }

        // Login
        System.out.println("\nLOGIN");
        System.out.print("Enter username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = input.nextLine();

        if (loginUser(username, password, loginUsername, loginPassword)) {
            System.out.println("Welcome " + firstName + ", " + lastName +
                    " it is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }

        input.close();
    }

    public static boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public static boolean checkPassword(String password) {
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        return hasCapital && hasNumber && hasSpecial;
    }

    public static boolean loginUser(String regUser, String regPass,
                                    String loginUser, String loginPass) {
        return regUser.equals(loginUser) &&
               regPass.equals(loginPass);
    }
}
    
}

        