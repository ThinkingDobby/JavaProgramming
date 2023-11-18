import java.io.*;
import java.util.*;

public class 강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());

            data[i] = new int[]{start, finish};
        }

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int cnt = 1;
        int prev = data[0][1];

        for (int i = 1; i < n; i++) {
            if (data[i][0] >= prev) {
                cnt++;
                prev = data[i][1];
            }
        }

        String ans = String.format("%d", cnt);
        bw.write(ans);

        br.close();
        bw.flush();
        bw.close();
    }
}
