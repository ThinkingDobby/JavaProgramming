import java.io.*;
import java.util.StringTokenizer;

public class 수퍼바이러스_2 {
    static long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long k = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        n *= 10;
        String ans = String.format("%d", k * calc(p, n) % mod);

        bw.write(ans);

        br.close();
        bw.flush();
        bw.close();
    }

    static long calc(long p, long n) {
        if (n == 1) return p;

        if (n % 2 == 1) {
            return calc(p * p % mod, n / 2) * p % mod;
        } else {
            return calc(p * p % mod, n / 2);
        }
    }
}
