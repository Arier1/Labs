package Task1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {

    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println(getIntegersFromList(Arrays.asList(1, 2, "a", "b")));
        System.out.println(getIntegersFromList(Arrays.asList(1, 2, "a", "b", 0, 15)));
        System.out.println(getIntegersFromList(Arrays.asList(1, 2, "a", "b", "aasf", "1", "123", 231)));
    }

    static List<Integer> getIntegersFromList(List<?> xs) {
        List<Integer> ret = new ArrayList<>();
        for (Object x : xs) {
            if (x instanceof Integer) {
                ret.add((Integer) x);
            }
        }
        return ret;
    }

}
