package cses;

import java.util.*;
import java.io.*;

public class AppleDivision {
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

	static long minDiff = Long.MAX_VALUE;
	
	public static void solve(int[] arr, int idx, long sum1, long sum2) {
		
		if(idx == arr.length) {
			minDiff = Math.min(minDiff, Math.abs(sum1 - sum2));
			return ;
		}
		
		solve(arr, idx + 1, sum1 + arr[idx], sum2);
		solve(arr, idx + 1, sum1, sum2 + arr[idx]);
	}
	
	public static void main(String[] args) {
		FastReader scn = new FastReader();
		int n = scn.nextInt();
		int[] arr= new int[n];
		for(int i=0; i<n; i++) arr[i] = scn.nextInt();
		solve(arr, 0, 0, 0);
		System.out.println(minDiff);
	}
}
