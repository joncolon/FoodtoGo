package nyc.c4q.leighdouglas.foodtogo.hakeem;

/**
 * Created by hakeemsackes-bramble on 2/19/17.
 */

public class User {

    public String uid;
    public String username;
    public String email;
    String businessName;
    String address;
    String phoneNumber;
    boolean isrunner;

    //business name address phone# isrunner

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
