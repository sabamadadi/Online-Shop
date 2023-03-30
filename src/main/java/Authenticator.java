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
}
