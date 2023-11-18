// Scanner -> TLE

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 성적평균_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] scores = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] sumScores = new int[n];

        sumScores[0] = scores[0];
        for (int i = 1; i < n; i++) {
            sumScores[i] = sumScores[i - 1] + scores[i];
        }

        for (int tc = 0; tc < k; tc++) {
            st = new StringTokenizer(sc.nextLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int fin = Integer.parseInt(st.nextToken()) - 1;

            int sv = start == 0 ? 0 : sumScores[start - 1];
            double ans = sumScores[fin] - sv;

            System.out.println(ans / (fin - start + 1));
        }
    }
}