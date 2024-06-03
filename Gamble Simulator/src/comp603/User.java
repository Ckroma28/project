package comp603;

public class User {

    private final String username;
    private int balance;

    public User(String username) {
        this.username = username;
        this.balance = 1000;
    }

    public User(String username, int balance) {
        this.username = username;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
