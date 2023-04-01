import java.util.ArrayList;
import java.util.Scanner;

public class User {
	static Shop shop;
	static String username;
	static int password;
	static String email;
	static String phone;
	static String address;
	static Cart cart;
	static ArrayList<Order> history = new ArrayList<Order>();
	static ArrayList<CartProduct> purchased = new ArrayList<CartProduct>();
	static int fund_requested_amount;
	
	static float wallet;
	
	public User(String input_username, int input_password, String input_email, String input_phone, String input_address, Shop input_shop) {
		username = input_username;
		password = input_password;
		email = input_email;
		phone = input_phone;
		address = input_address;
		cart = new Cart(this);
		shop = input_shop;
		fund_requested_amount = 0;
	}
	
	public void ViewProfile() {
		System.out.println("Username: " + username);
		System.out.println("Email: " + email);
		System.out.println("Phone number: " + phone);
		System.out.println("Address: " + address);
		System.out.println("Wallet: " + wallet);
		System.out.println("Orders list: ");
		for(int i = 0; i < history.size(); i++) {
			System.out.println("Order number " + (i + 1) + ":");
			history.get(i).Show();
		}
		System.out.println("Purchased list: ");
		for(int i = 0; i < purchased.size(); i++) {
			purchased.get(i).Show();
		}
	}
	
	public void EditProfile() {
		Scanner cs = new Scanner(System.in);
		
		System.out.println("Enter new password:");
		String new_password = cs.nextLine();
		int hash_password = Shop.authenticator.Hash(new_password);
		password = hash_password;
		
		System.out.println("Enter new email address");
		email = cs.nextLine();
		System.out.println("Enter new phone number");
		phone = cs.nextLine();
		System.out.println("Enter new address");
		address = cs.nextLine();
		
		return;
	}
	
	public void EditCart() {
		cart.Edit();
		return;
	}
	
	public void Purchase() {
		if(cart.amount < wallet) {
			System.out.println("Not enough money !");
			return;
		}
		
		shop.Purchase(cart);
		return;
	}
	
	public void Search() {
		shop.Search(cart);
		return;
	}
	
	public void RequestFund() {
		shop.RequestFund(this);
		return;
	}
	
	public void AddPurchased(CartProduct cart_product) {
		for(int i = 0; i < purchased.size(); i++) {
			if(purchased.get(i).name.equals(cart_product.name)) {
				purchased.get(i).cnt += cart_product.cnt;
				return;
			}
		}
		purchased.add(cart_product);
		return;
	}
}
