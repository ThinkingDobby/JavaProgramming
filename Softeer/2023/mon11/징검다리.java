// WA

import java.io.*;
import java.util.StringTokenizer;

public class 징검다리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int mv = -1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            int prev = data[i];
            int now  = data[i];
            for (int j = i + 1; j < n; j++) {
                if (data[j] > prev) {
                    if (data[j] > now) {
                        prev = now;
                        now = data[j];
                        cnt += 1;
                    } else if (data[j] < now) {
                        now = data[j];
                    }
                }
            }
            mv = Math.max(mv, cnt);
        }

        String ans = String.format("%d\n", mv);
        bw.write(ans);

        br.close();
        bw.flush();
        bw.close();
    }
}
