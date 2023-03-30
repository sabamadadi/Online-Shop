import java.util.ArrayList;

public class Order {
    static ArrayList<Product> cart = new ArrayList<Product>();
    static ArrayList<Integer> cart_cnt = new ArrayList<Integer>();

    public void Show() {
        for(int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).name + " " + cart_cnt.get(i));
        }
    }
}
