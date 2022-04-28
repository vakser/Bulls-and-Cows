import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    static String input;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                input = scanner.next();
                if (!"0".equals(input)) {
                    final int i = Integer.parseInt(input) * 10;
                    list.add(String.valueOf(i));
                }
            } catch (NumberFormatException e) {
                list.add("Invalid user input: " + input);
            }
        } while (!"0".equals(input));
        for (String str : list) {
            System.out.println(str);
        }
    }
}