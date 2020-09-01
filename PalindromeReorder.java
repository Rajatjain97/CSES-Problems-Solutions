package cses;

import java.util.*;
import java.io.*;

public class PalindromeReorder {
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
		String str = scn.nextLine();
		int[] arr = new int[26];
		for (char ch : str.toCharArray())
			arr[ch - 'A']++;
		int odds = 0;
		for (int val : arr)
			if (val % 2 != 0)
				odds++;
		if (odds > 1)
			System.out.println("NO SOLUTION");
		else {
			StringBuffer sb = new StringBuffer("");
			char codd = ' ';
			int odd_val = 0;
			for (int i = 0; i < 26; i++) {
				int val = arr[i];
				char ch = (char) (i + 'A');
				if (val % 2 != 0) {
					codd = ch;
					odd_val = val;
				} else
					for (int it = 1; it <= val / 2; it++)
						sb.append(ch);
			}
			StringBuffer rev = new StringBuffer(sb.reverse());
			sb.reverse();
			for (int i = 0; i < odd_val; i++)
				sb.append(codd);
			sb.append(rev);
			System.out.println(sb);
		}
	}
}
