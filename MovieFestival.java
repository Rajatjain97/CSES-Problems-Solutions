package cses;
import java.util.*;
import java.io.*;

public class MovieFestival {
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

	static class pair {
		int x;
		int y;
		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		FastReader scn = new FastReader();
		int n = scn.nextInt();
		pair[] list = new pair[n];
		
		for(int i=0; i<n; i++) {
			int x = scn.nextInt(), y = scn.nextInt();
			pair np = new pair(x, y);
			list[i] = np;
		}
		
		Arrays.sort(list, (a,b) -> a.y - b.y);
		
		int ans = 1;
		int prev = list[0].y;
		
		for(int i=1; i<n; i++) {
			pair rp = list[i];
			if(rp.x >= prev) {
				ans++;
				prev = rp.y;
			}
		}
		System.out.println(ans);
	}
}





















