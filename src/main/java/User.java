import java.util.ArrayList;

public class User {
    static String username;
    static int password;
    static String email;
    static String phone;
    static String address;

    static ArrayList<Product> cart = new ArrayList<Product>();
    static ArrayList<Integer> cart_cnt = new ArrayList<Integer>();
    static ArrayList<Order> history = new ArrayList<Order>();
    static ArrayList<Product> purchased = new ArrayList<Product>();
    static ArrayList<Integer> purchased_cnt = new ArrayList<Integer>();

    static int wallet;

    public void Show() {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Phone number: " + phone);
        System.out.println("Address: " + address);
        System.out.println("Cart: ");
        for(int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).name + " " + cart_cnt.get(i));
        }
        System.out.println("Orders list: ");
        for(int i = 0; i < history.size(); i++) {
            System.out.println("Order number " + (i + 1) + ":");
            history.get(i).Show();
        }
        System.out.println("Purchased list: ");
        for(int i = 0; i < purchased.size(); i++) {
            System.out.println(purchased.get(i).name + " " + purchased_cnt.get(i));
        }
    }

}
