package Task5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<String> Meeting(String visitors)
    {
    String upper_visitors = visitors.toUpperCase();
    List<String> splitted = new ArrayList<String>();
    String[] tmp123 = upper_visitors.split(";");
    for(int i = 0; i < tmp123.length; i++) {
        splitted.add(tmp123[i]);
    }
   List<Guests> guests = new ArrayList<Guests>();
    for(String x: splitted) {
        guests.add(new Guests(x.split(":")[1].toString(), x.split(":")[0].toString() )); 
    }
    Collections.sort(splitted);
    return splitted;
    }

    public static void main(String[] args) {
        Guests g1 = new Guests("Bill", "Murray");
        String s = "Fired:Corwill;Wilfred:Corwill;Barney:TornBull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        Meeting(s);
    }
}