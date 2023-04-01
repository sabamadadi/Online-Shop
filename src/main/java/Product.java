import java.util.ArrayList;
import java.util.Scanner;

public class Product extends CartProduct{
	static int price;
	static ArrayList<String> comments = new ArrayList<String>();
	static String type;
	static String category;
	static Seller seller;
	
	public Product(String input_name, int input_price, int input_cnt, String input_type, String input_category, Seller input_seller) {
		super(input_name, input_cnt);
		price = input_price;
		type = input_type;
		category = input_category;
		seller = input_seller;
		return;
	}
	
	public void Show() {
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("Stock: " + cnt);
		System.out.println("Type: " + type);
		System.out.println("Category: " + category);
		System.out.println("Comments: ");
		for(int i = 0; i < comments.size(); i++) {
			System.out.println(comments.get(i));
		}
		return;
	}
	
	public void Update() {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter new price:");
		price = Integer.parseInt(cs.nextLine());
		System.out.println("Enter new stock:");
		cnt = Integer.parseInt(cs.nextLine());
		System.out.println("Enter new type:");
		type = cs.nextLine();
		System.out.println("Enter new Category:");
		category = cs.nextLine();
		return;
	}
}
