import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
	static User user;
	static int amount;
	static ArrayList<CartProduct> cart = new ArrayList<CartProduct>();
	
	public Cart(User input_user) {
		user = input_user;
	}
	
	public void Edit() {
		Scanner cs = new Scanner(System.in);
		int input = 1;
		while(input != 0) {
			System.out.println("-To increase a product enter product number");
			System.out.println("-To decrease a product enter negative of product number");
			System.out.println("-To exit enter 0");
			
			for(int i = 0; i < cart.size(); i++) {
				System.out.print((i + 1) + " ");
				cart.get(i).Show();
			}
			
			input = Integer.parseInt(cs.nextLine());
			if(input == 0) return;
			if(input > 0) {
				user.shop.Reserve(cart.get(input - 1));
			}
			if(input < 0) {
				input = -1 * input;
				user.shop.Release(cart.get(input - 1));
				
				if(cart.get(input - 1).cnt == 0) {
					cart.remove(input - 1);
				}
			}
		}
		return;
	}
	
	public void Add(String name) {
		for(int i = 0; i < cart.size(); i++) {
			if(cart.get(i).name.equals(name)) {
				cart.get(i).cnt += 1;
				return;
			}
		}
		CartProduct new_cart_product = new CartProduct(name, 1);
		cart.add(new_cart_product);
		return;
	}

}
