import java.util.ArrayList;

public class Shop {
    static String name;
    static String webaddress;
    static String phone;
    static ArrayList<User> users = new ArrayList<User>();
    static ArrayList<Admin> admins = new ArrayList<Admin>();
    static ArrayList<Seller> sellers = new ArrayList<Seller>();
    static ArrayList<Product> products = new ArrayList<Product>();
    static float wallet;
    static Authenticator authenticator;

    public Shop(String input_name, String input_webaddress, String input_phone) {
        name = input_name;
        webaddress = input_webaddress;
        phone = input_phone;

        authenticator = new Authenticator(this);

        Admin admin = new Admin("admin", authenticator.Hash("admin"), "admin@gmail.com");
        admins.add(admin);
    }

    public User LoginUser() {
        User tmp = authenticator.LoginUser();
        return tmp;
    }

    public User RegisterUser() {
        User tmp = authenticator.RegisterUser();
        if(tmp != null) {
            users.add(tmp);
        }
        return tmp;
    }

    public Admin LoginAdmin() {
        Admin tmp = authenticator.LoginAdmin();
        return tmp;
    }

    public Admin RegisterAdmin() {
        Admin tmp = authenticator.RegisterAdmin();
        if(tmp != null) {
            admins.add(tmp);
        }
        return tmp;
    }

    public Seller LoginSeller() {
        Seller tmp = authenticator.LoginSeller();
        return tmp;
    }

    public Seller RegisterSeller() {
        Seller tmp = authenticator.RegisterSeller();
        if(tmp != null) {
            sellers.add(tmp);
        }
        return tmp;
    }

    private Product Find(String input_product) {
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i).name.equals(input_product)) {
                return products.get(i);
            }
        }
        return null;
    }

    public void Purchase(Cart cart) {
        Order order = new Order(cart.user);
        for(int i = 0; i < cart.cart.size(); i++) {
            Product current_product = Find(cart.cart.get(i));
            int quantity = cart.cart_cnt.get(i);

            order.cart.add(current_product.name);
            order.cart_cnt.add(quantity);

            cart.user.purchased.add(current_product.name);
            cart.user.purchased_cnt.add(quantity);

            cart.cart.remove(i);
            cart.cart_cnt.remove(i);

            cart.user.wallet -= quantity * current_product.price;
            current_product.seller.wallet += (0.9) * quantity * current_product.price;
            wallet += (0.1) * quantity * current_product.price;
        }

        order.user.history.add(order);
        return;
    }
}
