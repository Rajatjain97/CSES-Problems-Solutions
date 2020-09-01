package cses;

import java.util.*;
import java.io.*;

public class BookShop {
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
		int[] price = new int[n];
		for (int i = 0; i < n; i++)
			price[i] = scn.nextInt();

		int[] page = new int[n];
		for (int i = 0; i < n; i++)
			page[i] = scn.nextInt();

		int[] dp = new int[x + 1];
		
		
		for(int idx = 0; idx<n; idx++ ) {
			for (int i = x; i >= price[idx]; i--) {
				dp[i] = Math.max(dp[i], page[idx] + dp[i - price[idx]]);
			}
			System.out.println(Arrays.toString(dp) + " " + price[idx]);
		}

		System.out.println(Arrays.toString(dp));
		System.out.println(dp[x]);
	}
}
