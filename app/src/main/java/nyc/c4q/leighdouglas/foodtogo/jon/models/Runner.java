package nyc.c4q.leighdouglas.foodtogo.jon.models;

/**
 * Created by jonathancolon on 2/18/17.
 */

public class Runner {

    private Long _id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String restaurantClaimed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getRestaurantClaimed() {
        return restaurantClaimed;
    }

    public void setRestaurantClaimed(String restaurantClaimed) {
        this.restaurantClaimed = restaurantClaimed;
    }
}
