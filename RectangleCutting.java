package cses;

import java.util.*;
import java.io.*;

public class RectangleCutting {
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

	public static int function(int a, int b) {
		int[][] dp = new int[a + 1][b + 1];

		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				if (i != j)
					dp[i][j] = Integer.MAX_VALUE;
				for (int k = 1; k < i; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i - k][j] + dp[k][j] + 1);
				}
				for (int k = 1; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][j - k] + dp[i][k] + 1);
				}
			}
		}

		return dp[a][b];
	}

	public static void main(String[] args) {
		FastReader scn = new FastReader();
		int a = scn.nextInt();
		int b = scn.nextInt();

		System.out.println(function(a, b));

	}
}
