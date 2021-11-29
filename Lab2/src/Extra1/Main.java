package Extra1;

import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println("nextBigger(12  ) = " + nextBigger(  12));
        System.out.println("nextBigger(513 ) = " + nextBigger( 513));
        System.out.println("nextBigger(2017) = " + nextBigger(2017));
        System.out.println("nextBigger(9   ) = " + nextBigger(   9));
        System.out.println("nextBigger(111 ) = " + nextBigger( 111));
        System.out.println("nextBigger(531 ) = " + nextBigger( 531));
    }

    static int nextBigger(int num) {
        if (num <= 0) {
            return -1;
        }
        int[] digits = numToDigits(num);
        if (nextPermutation(digits)) {
            return digitsToNum(digits);
        } else {
            return -1;
        }
    }

    static int[] numToDigits(int num) {
        int[] ret = new int[(int) Math.floor(Math.log10(num)) + 1];
        for (int i = ret.length - 1; num != 0; num /= 10) {
            ret[i--] = num % 10;
        }
        return ret;
    }

    static int digitsToNum(int[] digits) {
        int ret = digits[0];
        for (int i = 1; i < digits.length; i++) {
            ret = ret * 10 + digits[i];
        }
        return ret;
    }

    static boolean nextPermutation(int[] digits) {
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = digits.length - 1;
            while (digits[i] >= digits[j]) {
                j--;
            }
            int tmp = digits[i];
            digits[i] = digits[j];
            digits[j] = tmp;
            reverse(digits, i + 1);
            return true;
        } else {
            return false;
        }
    }

    static void reverse(int[] digits, int off) {
        for (int i = 0; i < (digits.length - off) / 2; i++) {
            int tmp = digits[off + i];
            digits[off + i] = digits[digits.length - i - 1];
            digits[digits.length - i - 1] = tmp;
        }
    }

}
