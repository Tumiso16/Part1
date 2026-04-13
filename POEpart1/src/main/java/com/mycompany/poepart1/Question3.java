/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Student
 */
import java.util.Scanner;
public class Question3{
    
}static String storedUsername;
    static String storedPassword;
    static String storedPhone;

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
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

    public static boolean checkCellPhoneNumber(String number) {
        return number.matches("^\\+\\d{1,3}\\d{1,10}$");
    }

    public static String registerUser(String username, String password, String phone) {
        if (!checkUserName(username)) {
            return "The username is incorrectly formatted.";
        }
        if (!checkPasswordComplexity(password)) {
            return "The password does not meet the complexity requirements.";
        }
        if (!checkCellPhoneNumber(phone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        storedUsername = username;
        storedPassword = password;
        storedPhone = phone;

        return "The user has been registered successfully.";
    }

    public static boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    public static String returnLoginStatus(boolean success) {
        if (success) {
            return "Login successful.";
        } else {
            return "Login failed.";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cell phone number: ");
        String phone = input.nextLine();

        System.out.println(registerUser(username, password, phone));

        System.out.println("\nLogin");

        System.out.print("Enter username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = input.nextLine();

        boolean success = loginUser(loginUsername, loginPassword);
        System.out.println(returnLoginStatus(success));
    }


        
       
    


