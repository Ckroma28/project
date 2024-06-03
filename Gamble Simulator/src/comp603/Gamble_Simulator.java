package comp603;

import java.io.*;
import java.util.*;

public class Gamble_Simulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Gambling Simulator!");

        System.out.println("Please input your username:");
        String username = scanner.nextLine();
        User user;

        if (!UserFileHandler.userExists(username)) {
            System.out.println("Username not found, creating new user...");
            User newUser = new User(username);
            UserFileHandler.updateUserData(newUser, 1000);
            user = newUser;
        } else {
            user = UserFileHandler.loadUsersData(username);
            System.out.println("Welcome " + user.getUsername() + ", Your current balance is : $" + user.getBalance());
        }

        if (user != null) {
            Blackjack blackjack = new Blackjack(user);
            Coinflip coinflip = new Coinflip(user);
            SlotMachine slots = new SlotMachine(user);

            while (true) {
                System.out.println("\nWhich game would you like to play?");
                System.out.println("1. Blackjack");
                System.out.println("2. Slots");
                System.out.println("3. Coinflip");
                System.out.println("4. Exit program");

                try {
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            blackjack.play();
                            break;
                        case 2:
                            slots.play();
                            break;
                        case 3:
                            coinflip.play();
                            break;
                        case 4:
                            System.out.println("Thanks for playing");
                            System.out.println("Terminating program...");
                            return;
                        default:
                            System.out.println("Invalid input, please try again");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nInvalid input");
                    scanner.nextLine();
                }
            }
        } else {
            System.out.println("User object is null. Exiting program...");
        }
    }
}
