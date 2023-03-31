import java.util.ArrayList;

public class Product {
	static String name;
	static int price;
	static int cnt;
	static ArrayList<String> comments = new ArrayList<String>();
	static String type;
	static String category;
	static Seller seller;
	
	public Product(String input_name, int input_price, int input_cnt, String input_type, String input_category, Seller input_seller) {
		name = input_name;
		price = input_price;
		cnt = input_cnt;
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
}
