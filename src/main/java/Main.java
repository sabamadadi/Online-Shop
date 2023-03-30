import java.util.Scanner;

public class Main {
    static Shop shop;
    static User current_user;
    static boolean isUser;
    static Admin current_admin;
    static boolean isAdmin;
    static Seller current_seller;
    static boolean isSeller;

    public static void main(String[] args) {
        shop = new Shop("Digikala", "digikala.com", "61930000");
        current_user = null;
        isUser = false;
        current_admin = null;
        isAdmin = false;
        current_seller = null;
        isSeller = false;

        boolean running = true;
        while(running) {
            running = runMenu();
        }
    }

    public static boolean runMenu() {
        Scanner cs = new Scanner(System.in);
        if(isUser) {
            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. View & Edit Shopping Cart");
            System.out.println("4. Purchase");
            System.out.println("5. Search Product");
            System.out.println("6. Request for fund");
            System.out.println("7. Logout");

            int input = Integer.parseInt(cs.nextLine());
            if(input == 1) {
                current_user.ViewProfile();
            }
            if(input == 2) {
                current_user.EditProfile();
            }
            if(input == 3) {
                current_user.EditCart();
            }
            if(input == 4) {
                current_user.Purchase();
            }
            if(input == 5) {
                current_user.Search();
            }
            if(input == 6) {
                current_user.RequestFund();
            }
            if(input == 7) {
                current_user = null;
                isUser = false;
            }
        }
        else if(isAdmin) {

        }
        else if(isSeller) {

        }
        else {
            System.out.println("1. Login user");
            System.out.println("2. Login admin");
            System.out.println("3. Login seller");
            System.out.println("4. Register user");
            System.out.println("5. Register seller");
            System.out.println("6. Exit");

            int input = Integer.parseInt(cs.nextLine());
            if(input == 1) {
                current_user = shop.LoginUser();
                if(current_user != null) {
                    isUser = true;
                }
            }
            if(input == 2) {
                current_admin = shop.LoginAdmin();
                if(current_admin != null) {
                    isAdmin = true;
                }
            }
            if(input == 3) {
                current_seller = shop.LoginSeller();
                if(current_seller != null) {
                    isSeller = true;
                }
            }
            if(input == 4) {
                current_user = shop.RegisterUser();
                if(current_user != null) {
                    isUser = true;
                }
            }
            if(input == 5) {
                current_seller = shop.RegisterSeller();
                if(current_seller != null) {
                    isSeller = true;
                }
            }
            if(input == 6) {
                return false;
            }
        }
        return true;
    }
}
