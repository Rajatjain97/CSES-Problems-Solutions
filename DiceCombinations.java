package cses;

import java.util.*;
import java.io.*;

public class DiceCombinations {
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
		
		int mod = (int)1e9 + 7;
		
		int[] arr = new int[n+1];
		
		for(int i=1;i<=6&&i<=n;i++) arr[i] = 1;
		
		
		for(int i=2; i<=n; i++) {
			for(int j = 1; j<=6; j++) {
				arr[i] += i-j > 0 ? arr[i-j] : 0;
				arr[i] = arr[i]%mod;
			}
		}
		System.out.println(arr[n]%mod);
	}
}
