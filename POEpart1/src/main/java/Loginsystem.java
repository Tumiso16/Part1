/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
import java.util.Scanner;
public class Loginsystem {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Registration
        System.out.print("Create username: ");
        String registeredUsername = input.nextLine();

        System.out.print("Create password: ");
        String registeredPassword = input.nextLine();

        System.out.println("Registration successful!");

        // Login
        System.out.print("Enter username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = input.nextLine();

        // Check login details
        if (loginUsername.equals(registeredUsername) &&
            loginPassword.equals(registeredPassword)) {

            System.out.println("Welcome " + loginUsername +
                    ", it is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }
    }
}
    

