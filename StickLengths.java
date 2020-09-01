package cses;

import java.util.*;
import java.io.*;

public class StickLengths {
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

		Arrays.sort(arr);
		if (n % 2 == 0) {
			int med = arr[n / 2];
			long ans = 0;
			for (int val : arr)
				ans += Math.abs(val - med);
			System.out.println(ans);
		} else {
			int med1 = arr[n / 2];
			int med2 = arr[n / 2];

			long ans1 = 0;
			long ans2 = 0;

			for (int val : arr) {
				ans1 += Math.abs(val - med1);
				ans2 += Math.abs(val - med2);
			}
			System.out.println(Math.min(ans1, ans2));
		}
	}
}














