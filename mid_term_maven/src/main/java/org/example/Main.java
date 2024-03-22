package org.example;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        InputDevice userInput = new InputDevice(System.in);
        OutputDevice programOutput = new OutputDevice(System.out);
        Application application = new Application(userInput, programOutput);
        DatabaseLink data = new DatabaseLink();

        programOutput.printMessage("---------Log in--------\n");
        programOutput.printMessage("\n");
        programOutput.printMessage("Username: \n");
        String username = userInput.inputString();

        programOutput.printMessage("Password: \n");
        String password = userInput.inputString();

        programOutput.printMessage("\n");

        if (data.authenticateUser(username, password)){

            String role = data.getUserRole(username);
            if (role.equals("admin")){

                application.run();

            }else{

                application.user();
            }

        }else {
            programOutput.printMessage("User doesn't exist.\n");
        }
    }
}