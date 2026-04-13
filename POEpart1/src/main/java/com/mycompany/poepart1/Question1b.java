/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

/**
 *
 * @author Student
 */// Reference: OpenAI (2026) ChatGPT [AI language model]. 
// Available at: https://chat.openai.com/ (Accessed: 11 April 2026).

import java.util.Scanner; 
public class Question1b {
 public static boolean checkCellNumber(String number) {
        return number.matches("^\\+\\d{1,3}\\d{1,10}$");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter cell phone number: ");
        String number = input.nextLine();

        if (checkCellNumber(number)) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
        }
    }
}   

