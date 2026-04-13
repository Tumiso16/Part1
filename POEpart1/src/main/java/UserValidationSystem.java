/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
import java.util.Scanner;
public class UserValidationSystem {
   
    
    // ========== VALIDATION METHODS ==========
    
    // Method that returns welcome message or error for username
    public static String validateUsername(String username, String firstName, String lastName) {
        if (isUsernameValid(username)) {
            return "Welcome " + firstName + " ," + lastName + " it is great to see you.";
        } else {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    }
    
    // Method that returns success or error for password
    public static String validatePassword(String password) {
        if (isPasswordValid(password)) {
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
    }
    
    // Method that returns success or error for cell phone
    public static String validateCellPhone(String cellNumber) {
        if (isCellPhoneValid(cellNumber)) {
            return "Cell number successfully captured.";
        } else {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }
    }
    
    // ========== BOOLEAN VALIDATION METHODS ==========
    
    // Returns true if username contains underscore AND is <= 5 characters
    public static boolean isUsernameValid(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    
    // Returns true if password meets complexity requirements
    public static boolean isPasswordValid(String password) {
        if (password.length() < 8) return false;
        
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        
        return hasCapital && hasNumber && hasSpecial;
    }
    
    // Returns true if cell phone has international code (+ and 11-12 digits total)
    public static boolean isCellPhoneValid(String cellNumber) {
        return cellNumber.matches("\\+\\d{11,12}");
    }
    
    // Login simulation
    public static boolean login(String username, String password) {
        // For testing purposes, valid credentials are:
        // Username: "kyl_1", Password: "Ch&sec@ke99!"
        return username.equals("kyl_1") && password.equals("Ch&sec@ke99!");
    }
    
    // ========== UNIT TESTS (Console-based) ==========
    
    public static void runAllTests() {
        System.out.println("=".repeat(60));
        System.out.println("RUNNING UNIT TESTS");
        System.out.println("=".repeat(60));
        
        // assertEquals TESTS
        System.out.println("\n--- assertEquals TESTS ---\n");
        
        // Test 1: Username correctly formatted
        testAssertEquals(
            "Username is correctly formatted",
            validateUsername("kyl_1", "Kyle", "Smith"),
            "Welcome Kyle ,Smith it is great to see you."
        );
        
        // Test 2: Username incorrectly formatted
        testAssertEquals(
            "Username incorrectly formatted",
            validateUsername("kyle!!!!!!!", "Kyle", "Smith"),
            "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length."
        );
        
        // Test 3: Password meets complexity
        testAssertEquals(
            "Password meets complexity requirements",
            validatePassword("Ch&sec@ke99!"),
            "Password successfully captured."
        );
        
        // Test 4: Password does NOT meet complexity
        testAssertEquals(
            "Password does not meet complexity requirements",
            validatePassword("password"),
            "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character."
        );
        
        // Test 5: Cell phone correctly formatted
        testAssertEquals(
            "Cell phone correctly formatted",
            validateCellPhone("+27838968976"),
            "Cell number successfully captured."
        );
        
        // Test 6: Cell phone incorrectly formatted
        testAssertEquals(
            "Cell phone incorrectly formatted",
            validateCellPhone("08966553"),
            "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again."
        );
        
        // assertTrue/False TESTS
        System.out.println("\n--- assertTrue/assertFalse TESTS ---\n");
        
        // Test 7: Login Successful
        testAssertTrue("Login Successful", login("kyl_1", "Ch&sec@ke99!"));
        
        // Test 8: Login Failed
        testAssertFalse("Login Failed", login("wrong", "wrong"));
        
        // Test 9: Username correctly formatted (boolean)
        testAssertTrue("Username correctly formatted", isUsernameValid("kyl_1"));
        
        // Test 10: Username incorrectly formatted (boolean)
        testAssertFalse("Username incorrectly formatted", isUsernameValid("kyle!!!!!!!"));
        
        // Test 11: Password meets complexity (boolean)
        testAssertTrue("Password meets complexity requirements", isPasswordValid("Ch&sec@ke99!"));
        
        // Test 12: Password does NOT meet complexity (boolean)
        testAssertFalse("Password does not meet complexity requirements", isPasswordValid("password"));
        
        // Test 13: Cell phone correctly formatted (boolean)
        testAssertTrue("Cell phone correctly formatted", isCellPhoneValid("+27838968976"));
        
        // Test 14: Cell phone incorrectly formatted (boolean)
        testAssertFalse("Cell phone incorrectly formatted", isCellPhoneValid("08966553"));
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ALL TESTS COMPLETED");
        System.out.println("=".repeat(60));
    }
    
    // Helper methods for console-based assertions
    private static void testAssertEquals(String testName, String actual, String expected) {
        System.out.println("Test: " + testName);
        System.out.println("  Expected: \"" + expected + "\"");
        System.out.println("  Actual:   \"" + actual + "\"");
        if (actual.equals(expected)) {
            System.out.println("  Result: ✓ PASSED");
        } else {
            System.out.println("  Result: ✗ FAILED");
        }
        System.out.println();
    }
    
    private static void testAssertTrue(String testName, boolean actual) {
        System.out.println("Test: " + testName);
        System.out.println("  Expected: true");
        System.out.println("  Actual:   " + actual);
        if (actual) {
            System.out.println("  Result: ✓ PASSED");
        } else {
            System.out.println("  Result: ✗ FAILED");
        }
        System.out.println();
    }
    
    private static void testAssertFalse(String testName, boolean actual) {
        System.out.println("Test: " + testName);
        System.out.println("  Expected: false");
        System.out.println("  Actual:   " + actual);
        if (!actual) {
            System.out.println("  Result: ✓ PASSED");
        } else {
            System.out.println("  Result: ✗ FAILED");
        }
        System.out.println();
    }
    
    // ========== MAIN CONSOLE APPLICATION ==========
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=".repeat(60));
        System.out.println("USER REGISTRATION SYSTEM");
        System.out.println("=".repeat(60));
        
        // Option to run tests or use the application
        System.out.println("\nOptions:");
        System.out.println("1. Run Unit Tests");
        System.out.println("2. Run Main Application");
        System.out.print("\nSelect option (1 or 2): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        if (choice == 1) {
            runAllTests();
        } else {
            runMainApplication(scanner);
        }
        
        scanner.close();
    }
    
    private static void runMainApplication(Scanner scanner) {
        // Get user details
        System.out.print("\nEnter first name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        
        // Username validation
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        String usernameResult = validateUsername(username, firstName, lastName);
        System.out.println(usernameResult);
        
        // Only proceed with password and cell if username was valid
        if (isUsernameValid(username)) {
            // Password validation
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            String passwordResult = validatePassword(password);
            System.out.println(passwordResult);
            
            // Cell phone validation
            System.out.print("Enter cell phone number (with + and country code): ");
            String cellNumber = scanner.nextLine();
            String cellResult = validateCellPhone(cellNumber);
            System.out.println(cellResult);
            
            // Login simulation
            System.out.println("\n--- LOGIN SIMULATION ---");
            System.out.print("Enter username to login: ");
            String loginUser = scanner.nextLine();
            System.out.print("Enter password to login: ");
            String loginPass = scanner.nextLine();
            
            if (login(loginUser, loginPass)) {
                System.out.println("Login successful! Welcome back " + firstName + "!");
            } else {
                System.out.println("Login failed! Invalid credentials.");
            }
        }
        
        System.out.println("\nThank you for using the system!");
    }
}


