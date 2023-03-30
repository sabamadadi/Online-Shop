import java.util.ArrayList;

public class Seller {
    static String company_name;
    static int password;
    static ArrayList<Product> available = new ArrayList<Product>();
    static int wallet;
    static boolean registered;

    public void Add(Product new_product) {
        available.add(new_product);
    }
}
