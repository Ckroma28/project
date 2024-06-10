package comp603;

import java.util.*;
import java.io.*;

public class UserFileHandler {
    
    public static final String fileLocation = "./data/userdata.txt";
    
    public static User loadUsersData(String username) {
        User user = null;
        try (Scanner scanner = new Scanner(new File(fileLocation))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                
                if (parts.length >= 2 && parts[0].equals(username)) {
                    double balance = Double.parseDouble(parts[1]);
                    user = new User(username, (int) balance);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("User file not found, creating new user...");
        }
        if (user == null) {
            user = new User(username);
        }
        return user;
    }
    
    public static void saveUsersData(User user) {
        try {
            File file = new File(fileLocation); 
            List<String> lines = new ArrayList<>();
            
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                boolean userExists = false;
                
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(" ");
                    
                    if (parts.length >= 2 && parts[0].equals(user.getUsername())) {
                        lines.add(user.getUsername() + " " + user.getBalance());
                        userExists = true;
                    } else {
                        lines.add(line);
                    }
                }
                scanner.close();
                
                if (!userExists) {
                    lines.add(user.getUsername() + " " + user.getBalance());
                }
            } else {
                lines.add(user.getUsername() + " " + user.getBalance());
            }
            
            PrintWriter writer = new PrintWriter(new FileWriter(fileLocation));
            
            for (String line : lines) {
                writer.println(line);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
    
    public static void updateUserData(User user, int newBalance) {
        user.setBalance(newBalance);
        saveUsersData(user);
    }
    
    public static boolean userExists(String username) {
        try (Scanner scanner = new Scanner(new File(fileLocation))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                
                if (parts.length >= 2 && parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("User file not found");
        }
        return false;
    }
}
