package cses;

import java.util.*;
import java.io.*;

public class CountingRooms {
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

	public static void dfs(int cr, int cc, int er, int ec, char[][] crr) {

		if (cr < 0 || cr >= er || cc < 0 || cc >= ec || crr[cr][cc] == '#')
			return;

		crr[cr][cc] = '#';
		dfs(cr + 1, cc, er, ec, crr); // down
		dfs(cr - 1, cc, er, ec, crr); // up
		dfs(cr, cc - 1, er, ec, crr); // left
		dfs(cr, cc + 1, er, ec, crr); // right

	}

	public static void printCrr(char[][] crr) {
		for (char[] cr : crr) {
			System.out.println(Arrays.toString(cr));
		}
		System.out.println();
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
		
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (crr[i][j] == '.') {
					cnt++;
					dfs(i, j, m, n, crr);
//					printCrr(crr);
				}
			}
		}
		System.out.println(cnt);
	}
}
