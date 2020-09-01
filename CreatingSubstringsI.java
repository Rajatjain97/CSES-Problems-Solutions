package cses;

import java.util.*;
import java.io.*;

public class CreatingSubstringsI {
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

	private static void permute(String str, int l, int r) {
		if (l == r)
			set.add(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public static String swap(String a, int i, int j) {
		char[] charArray = a.toCharArray();
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	static TreeSet<String> set = new TreeSet<>();

	public static void main(String[] args) {
		FastReader scn = new FastReader();

		String str = scn.next();
		StringBuffer sb = new StringBuffer("");
		int n = str.length();
		permute(str, 0, n - 1);
		sb.append(set.size()).append('\n');
		for (String s : set)
			sb.append(s).append('\n');
		System.out.println(sb);
	}
}
