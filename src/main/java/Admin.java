import java.util.Scanner;

public class Admin {
    static Shop shop;
    static String username;
    static int password;
    static String email;

    public Admin(String input_username, int input_password, String input_email, Shop input_shop) {
        username = input_username;
        password = input_password;
        email = input_email;
        shop = input_shop;
    }

    public void EditProfile() {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter new password:");
        String new_password = cs.nextLine();
        int hash_password = shop.authenticator.Hash(new_password);
        password = hash_password;
        System.out.println("Enter new email address:");
        email = cs.nextLine();
        return;
    }
}
