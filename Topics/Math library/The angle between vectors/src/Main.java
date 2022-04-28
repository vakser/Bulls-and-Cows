import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        double u1 = scanner.nextDouble();
        double u2 = scanner.nextDouble();
        double v1 = scanner.nextDouble();
        double v2 = scanner.nextDouble();
        double length1 = Math.sqrt(u1 * u1 + u2 * u2);
        double length2 = Math.sqrt(v1 * v1 + v2 * v2);
        double dotProduct = u1 * v1 + u2 * v2;
        double cosT = dotProduct / (length1 * length2);
        System.out.println(Math.toDegrees(Math.acos(cosT)));
    }
}