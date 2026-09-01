import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int[][] id = new int[m][n];

        for (int[] row : id) {
            Arrays.fill(row, -1);
        }

        int count = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    sr = r;
                    sc = c;
                } else if (ch == 'L') {
                    id[r][c] = count++;
                }
            }
        }

        if (count == 0) return 0;

        int mask = (1 << count) - 1;

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][][] vis =
            new boolean[m][n][energy + 1][1 << count];

        q.offer(new int[]{sr, sc, energy, mask});
        vis[sr][sc][energy][mask] = true;

        int[][] dir = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];
                int e = cur[2];
                int maskNow = cur[3];

                if (maskNow == 0) return moves;

                if (e == 0) continue;

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    char ch = classroom[nr].charAt(nc);

                    if (ch == 'X') continue;

                    int ne = e - 1;
                    int nm = maskNow;

                    if (ch == 'R') {
                        ne = energy;
                    }

                    if (ch == 'L') {
                        nm &= ~(1 << id[nr][nc]);
                    }

                    if (!vis[nr][nc][ne][nm]) {
                        vis[nr][nc][ne][nm] = true;
                        q.offer(new int[]{nr, nc, ne, nm});
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}