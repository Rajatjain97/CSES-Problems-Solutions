package cses;
import java.util.*;
import java.io.*;

public class IncreasingArray {
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
		long ans = 0;
		int prev = scn.nextInt();
		while(n-- > 1) {
			int curr = scn.nextInt();
			ans += prev - curr >= 0 ? prev - curr : 0;
			prev = Math.max(curr, prev);
		}
		System.out.println(ans);
	}
}
