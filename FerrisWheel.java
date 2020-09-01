package cses;

import java.util.*;
import java.io.*;

public class FerrisWheel {
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
		
		Arrays.sort(arr);
		
		int ans = 0;
		
		int i=0, j=n-1;
		while(i < j) {
			if(arr[i] + arr[j] <= x) {
				ans++; i++; j--;
			} else if(arr[i] + arr[j] > x) {
				ans++;
				j--;
			}
		}
		if(i == j) ans++;
		System.out.println(ans);
	}
}
