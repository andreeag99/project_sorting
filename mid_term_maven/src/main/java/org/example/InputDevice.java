package org.example;
import java.io.InputStream;
import java.util.Scanner;



public class InputDevice {

    private InputStream userInput;

    private Scanner scanner;

    //ask input from user
    public InputDevice(InputStream userInput){
        this.userInput = userInput;
        scanner = new Scanner(userInput);
    }

    //ask integer input
    public int inputInteger(){
        while (true) {
            try {
                int number =  scanner.nextInt();

                return number;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
    }

    //ask string input
    public String inputString(){
        String sentence = scanner.nextLine();
        if(sentence.trim().isEmpty()){
            return "Field can't be empty.";
        }
        return sentence.trim();
    }





}
