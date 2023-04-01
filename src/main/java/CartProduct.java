public class CartProduct {
	static String name;
	static int cnt;
	
	public CartProduct(String input_name, int input_cnt) {
		name = input_name;
		cnt = input_cnt;
		return;
	}
	
	public void Show() {
		System.out.println(name + " " + cnt);
		return;
	}
}
