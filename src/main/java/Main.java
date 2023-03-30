import java.util.Scanner;

public class Main {
    static Shop shop;
    static User current_user;
    static boolean isUser;
    static Admin current_admin;
    static boolean isAdmin;
    static Seller current_seller;
    static boolean isSeller;

    public static void main(String[] args) {
        shop = new Shop("Digikala", "digikala.com", "61930000");

        boolean running = true;
        while(running) {
            running = runMenu();
        }
    }

    public boolean runMenu() {

    }
}
