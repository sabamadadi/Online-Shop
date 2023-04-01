import java.util.ArrayList;

public class Order {
	static User user;
	static ArrayList<CartProduct> cart = new ArrayList<CartProduct>();

	public Order(User input_user) {
		user = input_user;
		return;
	}
	
	public void Show() {
		for(int i = 0; i < cart.size(); i++) {
			cart.get(i).Show();
		}
	}
}
