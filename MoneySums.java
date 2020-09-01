package cses;

import java.util.*;
import java.io.*;

public class MoneySums {
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
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		int totalSum = 0;
		for (int val : arr)
			totalSum += val;
		Arrays.sort(arr);

		boolean[][] dp = new boolean[arr.length + 1][totalSum + 1];

		for (int i = 0; i < dp.length; i++)
			dp[i][0] = true;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j - arr[i - 1] >= 0)
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		StringBuffer sb = new StringBuffer();
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 1; i <= totalSum; i++)
			if (dp[n][i])
				ans.add(i);

		sb.append(ans.size()).append('\n');
		for (int val : ans)
			sb.append(val).append(' ');
		System.out.println(sb);
	}
}
