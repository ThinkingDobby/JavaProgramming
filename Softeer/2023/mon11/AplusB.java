import java.util.Arrays;
import java.util.Scanner;

public class AplusB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        for (int tc = 0; tc < t; tc++) {
            int[] data = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int sum = Arrays.stream(data).sum();
            String ans = String.format("Case #%s: %s", tc + 1, sum);

            System.out.println(ans);
        }
    }
}