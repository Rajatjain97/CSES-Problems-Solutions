
package cses;

import java.util.*;
import java.io.*;

public class RemovingDigits {
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
		int n = scn.nextInt();
		int[] dp = new int[n + 1];

		for (char ch : Integer.toString(n).toCharArray())
			dp[n - ch + '0'] = 1;

		for (int i = n - 2; i >= 0; i--) {
			if (dp[i] != 0) {
				for (char ch : Integer.toString(i).toCharArray()) {
					int dig = ch - '0';
					dp[i - dig] = dp[i - dig] == 0 ? dp[i] + 1 : Math.min(dp[i - dig], dp[i] + 1);
				}
			}
		}
		System.out.println(dp[0]);
	}
}
