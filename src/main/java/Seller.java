import java.util.ArrayList;

public class Seller {
    static String company_name;
    static int password;
    static ArrayList<Product> available = new ArrayList<Product>();
    static float wallet;
    static boolean registered;

    public Seller(String input_company_name, int input_password) {
        company_name = input_company_name;
        password = input_password;
        registered = false;
    }

    public void Add(Product new_product) {
        available.add(new_product);
    }
}
