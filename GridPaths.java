package cses;

import java.util.*;
import java.io.*;

public class GridPaths {
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
		int mod = (int) 1e9 + 7;

		int n = scn.nextInt();
		String[] srr = new String[n];

		for (int i = 0; i < n; i++)
			srr[i] = scn.next();

		int[][] dp = new int[n][n];

		dp[0][0] = srr[0].charAt(0) == '*' ? 0 : 1;

		for (int i = 1; i < n; i++)
			dp[i][0] = srr[i].charAt(0) == '*' ? 0 : dp[i - 1][0];
		for (int j = 1; j < n; j++)
			dp[0][j] = srr[0].charAt(j) == '*' ? 0 : dp[0][j - 1];

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = srr[i].charAt(j) == '*' ? 0 : (dp[i - 1][j] + dp[i][j - 1]) % mod;
			}
		}
		System.out.println(dp[n - 1][n - 1]);
	}

}
