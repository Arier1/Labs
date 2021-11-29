package Task2;
import java.util.HashMap;
import java.util.Map;

class Main {

    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println("firstNonRepeatingLetter(\"stress\") = \"" + firstNonRepeatingLetter("stress") + "\"");
        System.out.println("firstNonRepeatingLetter(\"sTreSS\") = \"" + firstNonRepeatingLetter("sTreSS") + "\"");
        System.out.println("firstNonRepeatingLetter(\"aaaaaa\") = \"" + firstNonRepeatingLetter("aaaaaa") + "\"");
    }

    static String firstNonRepeatingLetter(String str) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = Character.toLowerCase(str.charAt(i));
            int count = charToCount.getOrDefault(c, 0);
            if (count == 0 || count == 1) {
                charToCount.put(c, count + 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charToCount.get(Character.toLowerCase(c)) == 1) {
                return String.valueOf(c);
            }
        }
        return "";
    }

}
