
package cses;

import java.util.*;

import java.io.*;

public class Labyrinth {

	static class Pair {
		int r = -1;
		int c = -1;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {
		FastReader scn = new FastReader();
		int m = scn.nextInt();
		int n = scn.nextInt();

		char[][] crr = new char[m][n];
		for (int i = 0; i < m; i++) {
			String str = scn.next();
			crr[i] = str.toCharArray();
		}

		int si = -1;
		int ei = -1;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (crr[i][j] == 'A') {
					si = i;
					ei = j;
				}

		int[][] vis = new int[m][n];
		Pair[][] prev = new Pair[m][n];

		LinkedList<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(si, ei));
		vis[si][ei] = 1;
		crr[si][ei] = '#';

		int bi = -1, bj = -1;

		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		boolean possible = false;

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Pair rp = queue.poll();
				for (int[] dir : dirs) {
					int ni = rp.r + dir[0], nj = rp.c + dir[1];

					if (ni >= 0 && ni < m && nj >= 0 && nj < n && vis[ni][nj] == 0 && crr[ni][nj] != '#') {

						if (crr[ni][nj] == 'B') {
							bi = ni;
							bj = nj;
							possible = true;
							prev[ni][nj] = rp;
							break;
						}

						crr[ni][nj] = '#';
						queue.add(new Pair(ni, nj));
						vis[ni][nj] = 1;
						prev[ni][nj] = rp;
					}
				}
				if (possible)
					break;
			}
			if (possible)
				break;
		}

		if (possible) {
			StringBuffer sb = new StringBuffer();
			int ci = bi, cj = bj;
			while (!(ci == si && cj == ei)) {
				int ni = prev[ci][cj].r, nj = prev[ci][cj].c;

				if (cj == nj) {
					if (ci - ni == 1)
						sb.append('D');
					else
						sb.append('U');
				} else {
					if (cj - nj == 1)
						sb.append('R');
					else
						sb.append('L');
				}
				ci = ni;
				cj = nj;
			}
			sb = sb.reverse();

			System.out.println("YES\n" + sb.length() + '\n' + sb);
		} else {
			System.out.println("NO");
		}
	}
}
