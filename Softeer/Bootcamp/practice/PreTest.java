import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class PreTest {
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(br.readLine());
        int[][] data = new int[lines][lines];
        boolean[][] visited = new boolean[lines][lines];

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < lines; j++) {
                data[i][j] = Integer.parseInt(input[j]);
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines; j++) {
                if (!visited[i][j] && data[i][j] == 1) {
                    ans.add(bfs(data, lines, new int[]{i, j}, visited));
                }
            }
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    static int bfs(int[][] data, int lines, int[] start, boolean[][] visited) {
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();

        visited[start[0]][start[1]] = true;
        q.add(start);

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for (int way = 0; way < 4; way++) {
                int[] dir = dirs[way];

                int ni = now[0] + dir[0];
                int nj = now[1] + dir[1];

                if ((0 <= ni && ni < lines) && (0 <= nj && nj < lines)
                        && data[ni][nj] == 1 && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    q.add(new int[]{ni, nj});
                    cnt++;
                }
            }
        }

        return cnt;
    }
}



/*
4
1 0 0 0
1 0 0 0
0 0 0 0
0 0 1 1

6
0 1 1 0 0 0
0 1 1 0 1 1
0 0 0 0 1 1
0 0 0 0 1 1
1 1 0 0 1 0
1 1 1 0 0 0
 */