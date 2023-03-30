import java.util.ArrayList;

public class Shop {
    static String name;
    static String webaddress;
    static String phone;
    static ArrayList<User> users = new ArrayList<User>();
    static ArrayList<Admin> admins = new ArrayList<Admin>();
    static ArrayList<Seller> sellers = new ArrayList<Seller>();
    static ArrayList<Product> products = new ArrayList<Product>();
    static int wallet;
    static Authenticator authenticator;

    public Shop(String input_name, String input_webaddress, String input_phone) {
        name = input_name;
        webaddress = input_webaddress;
        phone = input_phone;

        authenticator = new Authenticator(this);

        Admin admin = new Admin("admin", authenticator.Hash("admin"), "admin@gmail.com");
        admins.add(admin);
    }
}
