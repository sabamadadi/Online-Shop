import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
	static User user;
	static int amount;
	static ArrayList<String> cart = new ArrayList<String>();
	static ArrayList<Integer> cart_cnt = new ArrayList<Integer>();
	
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
				System.out.println((i + 1) + " " + cart.get(i) + " " + cart_cnt.get(i));
			}
			
			input = Integer.parseInt(cs.nextLine());
			if(input == 0) return;
			if(input > 0) {
				if(user.shop.Reserve(cart.get(input))){
					cart_cnt.set(input, cart_cnt.get(input) + 1);
				}
			}
			if(input < 0) {
				input = -1 * input;
				cart_cnt.set(input, cart_cnt.get(input) - 1);
				user.shop.Release(cart.get(input));
				
				if(cart_cnt.get(input) == 0) {
					cart_cnt.remove(input);
					cart.remove(input);
				}
			}
		}
		return;
	}
	
	public void Add(String name) {
		for(int i = 0; i < cart.size(); i++) {
			if(cart.get(i).equals(name)) {
				cart_cnt.set(i, cart_cnt.get(i) + 1);
			}
		}
		return;
	}

}
