
package cses;

import java.util.*;
import java.io.*;

public class CoinCombinations1 {
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
		int x = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		int mod = (int) 1e9 + 7;

		int[] dp = new int[x + 1];

		for (int val : arr)
			if (val < dp.length)
				dp[val] = 1;

		for (int i = 0; i <= x; i++) {
			long temp = dp[i];
			for (int val : arr) {
				if (i - val > 0) {
					temp += dp[i - val];
				}
			}
			temp = temp % mod;
			dp[i] = (int) temp;
		}
		System.out.println(dp[x] % mod);
	}
}
