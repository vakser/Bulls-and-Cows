import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        if (n > s.length()) {
            System.out.println(s);
        } else {
            String s1 = s.substring(0, n);
            String s2 = s.substring(n);
            System.out.println(s2 + s1);
        }
    }
}