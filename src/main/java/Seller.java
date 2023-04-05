import java.util.ArrayList;
import java.util.Scanner;

public class Seller {
	static Shop shop;
	static String company_name;
	static int password;
	static ArrayList<String> available = new ArrayList<String>();
	static float wallet;
	static boolean registered;

	public Seller(String input_company_name, int input_password, Shop input_shop) {
		company_name = input_company_name;
		password = input_password;
		registered = false;
		shop = input_shop;
		wallet = 0;
	}

	public void ViewProfile() {
		System.out.println("Company name: " + company_name);
		System.out.println("Wallet: " + wallet);
	}

	public void EditProfile() {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter new password: ");
		String new_password = cs.nextLine();
		int hash_password = shop.authenticator.Hash(new_password);
		password = hash_password;
		return;
	}
}