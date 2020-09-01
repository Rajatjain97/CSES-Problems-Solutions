package cses;

import java.util.*;
import java.io.*;

public class MinimizingCoins {
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
		for(int i=0;i<n;i++)arr[i] = scn.nextInt();
		
		int[] dp = new int[x+1];
		
		for(int val : arr) if(val < dp.length) dp[val] = 1;
		
		for(int i=1; i<=x; i++) {
			if(dp[i]==0) {
				int temp = Integer.MAX_VALUE;
				for(int val : arr) {
					if(i - val > 0 && dp[i-val] != 0) {
						temp = Math.min(temp, 1 + dp[i-val]);
					}
				}
				dp[i] = temp == Integer.MAX_VALUE ? 0 : temp;
			}
		}
		System.out.println(dp[x] == 0 ? -1 : dp[x]);
	}
}
