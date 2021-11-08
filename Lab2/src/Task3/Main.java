package Task3;
import java.util.*;

public class Main 
{
	 public static int Sum_of_n(int number){
         int sum = 0;
         while (number > 0)
         {
             sum += (number % 10);
             number = number / 10;
         }
         if (sum / 10 < 1)
         { return sum; }
         else { return Sum_of_n(sum); }
     }


     public static void main(String[] args) {
         System.out.println(Sum_of_n(1051));
     }
}