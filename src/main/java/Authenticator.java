import java.util.Scanner;

public class Authenticator {
	static Shop shop;
	
	public Authenticator(Shop input_shop) {
		shop = input_shop;
	}
	
	public static int Hash(String password) {
		int MOD = 1000847, Base = 256;
		int ans = 0;
		for(int i = 0; i < password.length(); i++) {
			ans = (ans * Base) + (int)password.charAt(i);
			ans %= MOD;
		}
		return ans;
	}
	
	public User LoginUser() {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter Username:");
		String name = cs.nextLine();
		System.out.println("Enter Password:");
		String password = cs.nextLine();
		int hash_password = Hash(password);
		
		for(int i = 0; i < shop.users.size(); i++) {
			if(shop.users.get(i).username.equals(name) && shop.users.get(i).password == hash_password) {
				return shop.users.get(i);
			}
		}
		System.out.println("Invalid username or password !");
		return null;
	}
	
	public User RegisterUser() {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter Username:");
		String name = cs.nextLine();
		
		for(int i = 0; i < shop.users.size(); i++) {
			if(shop.users.get(i).username.equals(name)) {
				System.out.println("This Username already exists !");
				return null;
			}
		}
		
		System.out.println("Enter password:");
		String password = cs.nextLine();
		int hash_password = Hash(password);
		System.out.println("Enter email address:");
		String email = cs.nextLine();
		System.out.println("Enter phone number:");
		String phone = cs.nextLine();
		System.out.println("Enter your address:");
		String address = cs.nextLine();
		
		User tmp = new User(name, hash_password, email, phone, address, shop);
		return tmp;
	}
	
	public Admin LoginAdmin() {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter Username:");
		String name = cs.nextLine();
		System.out.println("Enter Password:");
		String password = cs.nextLine();
		int hash_password = Hash(password);
		
		for(int i = 0; i < shop.admins.size(); i++) {
			if(shop.admins.get(i).username.equals(name) && shop.admins.get(i).password == hash_password) {
				return shop.admins.get(i);
			}
		}
		System.out.println("Invalid username or password !");
		return null;
	}
	
	public Admin RegisterAdmin() {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter Username:");
		String name = cs.nextLine();
		
		for(int i = 0; i < shop.admins.size(); i++) {
			if(shop.admins.get(i).username.equals(name)) {
				System.out.println("This Username already exists !");
				return null;
			}
		}
		
		System.out.println("Enter password:");
		String password = cs.nextLine();
		int hash_password = Hash(password);
		System.out.println("Enter email address:");
		String email = cs.nextLine();
		
		Admin tmp = new Admin(name, hash_password, email, shop);
		return tmp;
	}
	
	public Seller LoginSeller() {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter Company name:");
		String name = cs.nextLine();
		System.out.println("Enter Password:");
		String password = cs.nextLine();
		int hash_password = Hash(password);
		
		for(int i = 0; i < shop.sellers.size(); i++) {
			if(shop.sellers.get(i).company_name.equals(name) && shop.sellers.get(i).password == hash_password) {
				return shop.sellers.get(i);
			}
		}
		System.out.println("Invalid company name or password !");
		return null;
	}
	
	public Seller RegisterSeller() {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter Company name:");
		String name = cs.nextLine();
		
		for(int i = 0; i < shop.sellers.size(); i++) {
			if(shop.sellers.get(i).company_name.equals(name)) {
				System.out.println("This Company name already exists !");
				return null;
			}
		}
		
		System.out.println("Enter password:");
		String password = cs.nextLine();
		int hash_password = Hash(password);
		Seller tmp = new Seller(name, hash_password, shop);
		return tmp;
	}
}
