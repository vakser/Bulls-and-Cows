import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();
        int seed = k;
        int num = 0;
        double gaussian;
        while (num < n) {
            Random random = new Random(seed);
            for (int i = 0; i < n; i++) {
                gaussian = random.nextGaussian();
                if (gaussian <= m) {
                    num++;
                }
            }
            if (num < n) {
                seed++;
                num = 0;
            }
        }
        System.out.println(seed);
    }
}