package cses;
import java.util.*;
import java.io.*;

public class Permutations {
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
		if(n == 1) System.out.println(n);
		else if(n < 4) System.out.println("NO SOLUTION");
		else if(n == 4) System.out.println("2 4 1 3 ");
		else if(n == 5) System.out.println("2 4 1 3 5 ");
		else {
			StringBuffer sb = new StringBuffer("");
			int i = 1;
			int j = n/2+1;
			for(; i<=n/2; i++, j++) {
				sb.append(i + " ").append(j + " ");
			}
			
			if(n%2 != 0) System.out.println(n + " " + sb);
			else System.out.println(sb);
		}
	}
}