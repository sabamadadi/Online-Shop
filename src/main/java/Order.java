import java.util.ArrayList;

public class Order {
    static User user;
    static ArrayList<String> cart = new ArrayList<String>();
    static ArrayList<Integer> cart_cnt = new ArrayList<Integer>();

    public Order(User input_user) {
        user = input_user;
        return;
    }

    public void Show() {
        for(int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i)+ " " + cart_cnt.get(i));
        }
    }
}
