import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        int cCount = 0;
        int gCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'c') {
                cCount++;
            }
            if (str.charAt(i) == 'g') {
                gCount++;
            }
        }
        System.out.println((double) (cCount + gCount) * 100 / str.length());
    }
}