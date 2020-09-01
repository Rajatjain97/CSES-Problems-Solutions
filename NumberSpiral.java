package cses;
import java.util.*;
import java.io.*;

public class NumberSpiral {
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
		int t = scn.nextInt();
		StringBuffer sb = new StringBuffer("");
		while(t-- > 0) {
			long x = scn.nextLong();
			long y = scn.nextLong();
			if (x < y) {
	            if (y % 2 == 1) {
	                long r = (y * y) - x + 1;
	                sb.append(r).append('\n');
	            }
	            else {
	            	long r = (y - 1) * (y - 1) + x;
	            	sb.append(r).append('\n');
	            }
	        }
	        else {
	            if (x % 2 == 0) {
	            	long r = (x * x) - y + 1;
	                sb.append(r).append('\n');
	            }
	            else {
	            	long r = (x - 1) * (x - 1) + y;
	                sb.append(r).append('\n');
	            }
	        }
		}
		System.out.println(sb);
	}
}
