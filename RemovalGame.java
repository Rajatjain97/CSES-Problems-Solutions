package cses;

import java.util.*;
import java.io.*;

public class RemovalGame {
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

	public static long function(int[] arr, int i, int j) {
		
		if(i == j) return arr[i];
		if(i + 1 == j) return Math.max(arr[i], arr[j]);
		
		if(dp[i][j]!=0) return dp[i][j];
		long f = arr[i] + Math.min(function(arr, i+2, j), function(arr, i+1, j-1));
		long s= arr[j] + Math.min(function(arr, i+1, j-1), function(arr, i, j-2));
		
		return dp[i][j] = Math.max(f, s);
		
	}

	static long[][] dp; 

	public static void main(String[] args) {
		FastReader scn = new FastReader();
		int n = scn.nextInt();
		int[] arr= new int[n];
		dp = new long[n+1][n+1];
		
		for(int i=0;i<n;i++) {
			arr[i]= scn.nextInt();
		}
		
		System.out.println(function(arr, 0, n-1));
	}
}
