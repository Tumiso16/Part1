/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;

/**
 *
 * @author Student
 */
import java.util.Scanner; 
public class POEpart1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Create username: ");
        String username = input.nextLine();

        if (checkUserName(username)) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        System.out.print("Create password: ");
        String password = input.nextLine();

        if (checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        System.out.print("Enter username to login: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter password to login: ");
        String loginPassword = input.nextLine();

        if (loginUser(username, password, loginUsername, loginPassword)) {
            System.out.println("Welcome " + firstName + " " + lastName + ", it is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }

        input.close();
    }

    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public static boolean checkPasswordComplexity(String password) {
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            } 
            else if (Character.isDigit(ch)) {
                hasNumber = true;
            } 
            else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        return password.length() >= 8 &&
               hasCapital &&
               hasNumber &&
               hasSpecial;
    }

    public static boolean loginUser(String storedUsername, String storedPassword,
                                    String enteredUsername, String enteredPassword) {
        return storedUsername.equals(enteredUsername) &&
               storedPassword.equals(enteredPassword);
    }
}



    