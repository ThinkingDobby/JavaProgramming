import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 성적평균 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] scores = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] sumScores = new int[n];

        sumScores[0] = scores[0];
        for (int i = 1; i < n; i++) {
            sumScores[i] = sumScores[i - 1] + scores[i];
        }

        for (int tc = 0; tc < k; tc++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int fin = Integer.parseInt(st.nextToken()) - 1;

            int sv = start == 0 ? 0 : sumScores[start - 1];
            double avg = sumScores[fin] - sv;
            String ans = String.format("%.2f", avg / (fin - start + 1));

            bw.write(ans + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}