package cses;

import java.util.*;
import java.io.*;

public class ShortestRoutes2 {
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
		int m = scn.nextInt();
		int q = scn.nextInt();

		long[][] dp = new long[n + 1][n + 1];

		for (long[] arr : dp)
			Arrays.fill(arr, (long)(1e15));

		for (int i = 0; i <= n; i++)
			dp[i][i] = 0;

		while (m-- > 0) {
			int u = scn.nextInt(), v = scn.nextInt(), c = scn.nextInt();
			dp[u][v] = Math.min(dp[u][v], c);
			dp[v][u] = Math.min(dp[v][u], c);

//			dp[v][u] = c;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dp[i][k] + dp[k][j] < dp[i][j]) 
						dp[i][j] = dp[i][k] + dp[k][j];
//					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		while(q-- > 0) {
			int s = scn.nextInt(), e = scn.nextInt();
			sb.append((dp[s][e] >= (long)(1e15) ? -1 : dp[s][e])).append('\n');
		}
		System.out.println(sb);
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
