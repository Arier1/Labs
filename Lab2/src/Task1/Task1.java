package Task1;
import java.util.ArrayList;
import java.util.List;

public class Task1 {

	public static void main(String[] args) {
        List<Object> mixed = new ArrayList<Object>();
        String str1 = "a";
        String str2 = "aab";
        String str3 = "b";
        int num1 = -6;
        int num2 = 12;
        int num3 = 67;
        mixed.add(str1);
        mixed.add(num2);
        mixed.add(str2);
        mixed.add(num1);
        mixed.add(str3);
        mixed.add(num3);

        System.out.println(mixed);
        for(int i = 0; i < mixed.size();) {
            if (mixed.get(i) instanceof Integer) {
                int tmp = (Integer) mixed.get(i);
                if(tmp < 0) {
                    mixed.remove(mixed.get(i));
                }    else {
                    i++;
                }
            } 
            else if (mixed.get(i) instanceof String) {
                mixed.remove(mixed.get(i));
            }
        }
        System.out.println(mixed);
    }

}
