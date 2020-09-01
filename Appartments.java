package cses;

import java.util.*;
import java.io.*;

public class Appartments {
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
		int k = scn.nextInt();
		
		int[] applicants = new int[n];
		for (int i = 0; i < n; i++)
			applicants[i] = scn.nextInt();
		
		int[] appartments = new int[m];
		for (int i = 0; i < m; i++)
			appartments[i] = scn.nextInt();
		
		Arrays.sort(applicants);
		Arrays.sort(appartments);

		int ans = 0;
		for (int i = 0, j = 0; i < n && j < m;) {
			if (Math.abs(applicants[i] - appartments[j]) <= k) {
				ans++;
				i++;
				j++;
			} else if (applicants[i] < appartments[j])
				i++;
			else
				j++;
		}
		System.out.println(ans);
	}
}


















