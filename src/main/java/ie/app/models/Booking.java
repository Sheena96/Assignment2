package ie.app.models;

/**
 * Created by sheenakelly on 17/12/2017.
 */

public class Booking {
    public String name;
    public String date;
    public int amount;
    public String method;

    public Booking (String name, String date, int amount, String method)
    {
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.method = method;
    }

}
