import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] consonants = str.split("[aeiouy]+");
        String[] vowels = str.split("[b-df-hj-np-tv-xz]+");
        int num = 0;
        final int euMinimum = 3;
        for (String s : consonants) {
            if (s.length() >= euMinimum) {
                if (s.length() % 2 == 1) {
                    num = num + s.length() / 2;
                } else {
                    num = num + s.length() / 2 - 1;
                }
            }
        }
        for (String s : vowels) {
            if (s.length() >= euMinimum) {
                if (s.length() % 2 == 1) {
                    num = num + s.length() / 2;
                } else {
                    num = num + s.length() / 2 - 1;
                }
            }
        }
        System.out.println(num);
    }
}