import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	static String name;
	static String webaddress;
	static String phone;
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<User> fund_users = new ArrayList<User>();
	static ArrayList<User> purchased_waiting_users = new ArrayList<User>();
	static ArrayList<Seller> unconfirmeds = new ArrayList<Seller>();
	static ArrayList<Admin> admins = new ArrayList<Admin>();
	static ArrayList<Seller> sellers = new ArrayList<Seller>();
	static ArrayList<Product> products = new ArrayList<Product>();
	static float wallet;
	static Authenticator authenticator;

	public Shop(String input_name, String input_webaddress, String input_phone) {
		name = input_name;
		webaddress = input_webaddress;
		phone = input_phone;
		wallet = 0;

		authenticator = new Authenticator(this);

		Admin admin = new Admin("admin", authenticator.Hash("admin"), "admin@gmail.com", this);
		admins.add(admin);
		return;
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

	public void RegisterAdmin() {
		Admin tmp = authenticator.RegisterAdmin();
		if(tmp != null) {
			admins.add(tmp);
		}
		return;
	}

	public Seller LoginSeller() {
		Seller tmp = authenticator.LoginSeller();
		return tmp;
	}

	public Seller RegisterSeller() {
		Seller tmp = authenticator.RegisterSeller();
		if(tmp != null) {
			sellers.add(tmp);
			unconfirmeds.add(tmp);
		}
		return tmp;
	}

	private Product findProduct(String input_product_name) {
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).name.equals(input_product_name)) {
				return products.get(i);
			}
		}
		return null;
	}

	public void Purchase(User user) {
		for(int i = 0; i < purchased_waiting_users.size(); i++) {
			if(purchased_waiting_users.get(i).username.equals(user.username)) {
				return;
			}
		}
		purchased_waiting_users.add(user);
		return;
	}

	public void ConfirmOrder() {
		Scanner cs = new Scanner(System.in);
		int input = 1;
		while(input > 0) {
			System.out.println("Enter index of order you wish to confirm.");
			System.out.println("Enter 0 to exit.");

			for(int i = 0; i < purchased_waiting_users.size(); i++) {
				System.out.println((i + 1) + " "  + purchased_waiting_users.get(i).username);
			}

			input = Integer.parseInt(cs.nextLine());

			if(input == 0 || input > purchased_waiting_users.size()) {
				break;
			}

			finalPurchase(purchased_waiting_users.get(input - 1));
		}
		return;
	}

	private void finalPurchase(User user) {
		if(user.wallet < user.cart.amount) {
			return;
		}
		for(int i = 0; i < purchased_waiting_users.size(); i++) {
			if(purchased_waiting_users.get(i).username.equals(user.username)) {
				purchased_waiting_users.remove(i);
				break;
			}
		}
		user.wallet -= user.cart.amount;
		Order order = new Order(user.cart.user);
		for(int i = 0; i < user.cart.cart.size(); i++) {
			Product current_product = findProduct(user.cart.cart.get(i).name);
			int quantity = user.cart.cart.get(i).cnt;

			order.cart.add(user.cart.cart.get(i));
			user.AddPurchased(user.cart.cart.get(i));
			user.cart.cart.remove(i);
			current_product.seller.wallet += (0.9) * quantity * current_product.price;
			wallet += (0.1) * quantity * current_product.price;
		}

		user.history.add(order);
		return;
	}

	public void RequestFund(User current) {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter amount of your requested fund :");
		int amount = Integer.parseInt(cs.nextLine());

		if(current.fund_requested_amount == 0) {
			fund_users.add(current);
		}
		current.fund_requested_amount += amount;
		return;
	}

	public void Reserve(CartProduct cart_product, Cart cart) {
		Product current = findProduct(cart_product.name);
		if(current.cnt == 0) {
			return;
		}

		current.cnt -= 1;
		cart_product.cnt += 1;
		cart.amount += current.price;
		return;
	}

	public void Release(CartProduct cart_product, Cart cart) {
		Product current = findProduct(name);

		current.cnt += 1;
		cart_product.cnt -= 1;
		cart.amount += current.price;
		return;
	}

	public void ShowProduct(Product product, Cart cart) {
		product.Show();

		Scanner cs = new Scanner(System.in);
		System.out.println("Do you want to buy? (Y/N)");
		String ans = cs.nextLine();
		if(ans.equals("Y")) {
			cart.amount += product.price;
			cart.Add(product.name);
		}
		return;
	}

	public void Search(Cart cart) {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter name of product you want to search for:");
		String name = cs.nextLine();

		System.out.println("Enter index of product you want to see");
		System.out.println("To exit enter 0:");

		int cnt = 0;
		for(int i = 0; i < products.size(); i++) {
			boolean have = false;
			for(int j = 0; j + name.length() <= products.get(i).name.length(); j++) {
				boolean flag = true;
				for(int k = 0; k < name.length(); k++) {
					if(products.get(i).name.charAt(j + k) != name.charAt(k)) {
						flag = false;
						break;
					}
				}
				have |= flag;
			}
			if(have) {
				cnt += 1;
				System.out.println(cnt + " " + products.get(i).name);
			}
		}

		int input = Integer.parseInt(cs.nextLine());
		if(input == 0 || input > cnt) {
			return;
		}

		cnt = 0;
		for(int i = 0; i < products.size(); i++) {
			boolean have = false;
			for(int j = 0; j + name.length() <= products.get(i).name.length(); j++) {
				boolean flag = true;
				for(int k = 0; k < name.length(); k++) {
					if(products.get(i).name.charAt(j + k) != name.charAt(k)) {
						flag = false;
						break;
					}
				}
				have |= flag;
			}
			if(have) {
				cnt += 1;
				if(cnt == input) {
					ShowProduct(products.get(i), cart);
				}
			}
		}
		return;
	}

	private void showUser(User user) {
		user.ViewProfile();
		return;
	}

	public void UserReview() {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter username of user you want to review:");
		String name = cs.nextLine();

		System.out.println("Enter index of user you want to see");
		System.out.println("To exit enter 0:");

		int cnt = 0;
		for(int i = 0; i < users.size(); i++) {
			boolean have = false;
			for(int j = 0; j + name.length() <= users.get(i).username.length(); j++) {
				boolean flag = true;
				for(int k = 0; k < name.length(); k++) {
					if(users.get(i).username.charAt(j + k) != name.charAt(k)) {
						flag = false;
						break;
					}
				}
				have |= flag;
			}
			if(have) {
				cnt += 1;
				System.out.println(cnt + " " + users.get(i).username);
			}
		}

		int input = Integer.parseInt(cs.nextLine());
		if(input == 0 || input > cnt) {
			return;
		}

		cnt = 0;
		for(int i = 0; i < users.size(); i++) {
			boolean have = false;
			for(int j = 0; j + name.length() <= users.get(i).username.length(); j++) {
				boolean flag = true;
				for(int k = 0; k < name.length(); k++) {
					if(users.get(i).username.charAt(j + k) != name.charAt(k)) {
						flag = false;
						break;
					}
				}
				have |= flag;
			}
			if(have) {
				cnt += 1;
				if(cnt == input) {
					showUser(users.get(i));
				}
			}
		}
		return;
	}
	public void ConfirmFund() {
		Scanner cs = new Scanner(System.in);

		int input = 1;
		while(input != 0) {
			System.out.println("Enter Requst index you wish to accept");
			System.out.println("Enter 0 to exit");
			for(int i = 0; i < fund_users.size(); i++) {
				System.out.println((i + 1) + " " + fund_users.get(i).username + " " + fund_users.get(i).fund_requested_amount);
			}
			input = Integer.parseInt(cs.nextLine());
			if(input != 0 && input <= fund_users.size()) {
				fund_users.get(input - 1).wallet += fund_users.get(input - 1).fund_requested_amount;
				fund_users.get(input - 1).fund_requested_amount = 0;
				fund_users.remove(input - 1);
			}
		}
		return;
	}
	public void ConfirmSeller() {
		Scanner cs = new Scanner(System.in);

		int input = 1;
		while(input != 0) {
			System.out.println("Enter Seller index you wish to confirm");
			System.out.println("Enter 0 to exit");
			for(int i = 0; i < unconfirmeds.size(); i++) {
				System.out.println((i + 1) + " Company name: " + unconfirmeds.get(i).company_name);
			}
			input = Integer.parseInt(cs.nextLine());
			if(input != 0 && input <= unconfirmeds.size()) {
				unconfirmeds.get(input - 1).registered = true;
				unconfirmeds.remove(input - 1);
			}
		}
		return;
	}

	public void AddProduct(Seller seller) {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter name of the product: ");
		String name = cs.nextLine();
		System.out.println("Enter price of the product: ");
		int price = Integer.parseInt(cs.nextLine());
		System.out.println("Enter amount of the product: ");
		int cnt = Integer.parseInt(cs.nextLine());
		System.out.println("Enter type of the product: ");
		String type = cs.nextLine();
		System.out.println("Enter category of the product: ");
		String category = cs.nextLine();

		Product new_product = new Product(name, price, cnt, type, category, seller);
		products.add(new_product);
		seller.available.add(name);
		return;
	}

	public void UpdateProduct(Seller seller) {
		Scanner cs = new Scanner(System.in);
		int input = 1;
		while(input > 0) {
			System.out.println("Which product do you want to update ?");
			System.out.println("Enter index of selected product");
			System.out.println("Enter 0 to exit");
			for(int i = 0; i < seller.available.size(); i++) {
				System.out.println((i + 1) + " " + seller.available.get(i));
			}
			input = Integer.parseInt(cs.nextLine());
			if(input == 0 || input > seller.available.size()) {
				continue;
			}
			Product current_product = findProduct(seller.available.get(input - 1));
			current_product.Update();
		}
		return;
	}

	public void Show() {
		System.out.println("Name: " + name);
		System.out.println("WebAddress: " + webaddress);
		System.out.println("Phone: " + phone);
		System.out.println("Wallet: " + wallet);
	}
}