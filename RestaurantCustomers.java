package cses;

import java.util.*;

import java.io.*;

public class RestaurantCustomers {
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
		int b;
		pair(int x, int b) {
			this.x = x;
			this.b = b;
		}
	}

    public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));

    
    static class sort implements Comparator<pair> { 
        public int compare(pair a, pair b) { 
            return a.x - b.x; 
        } 
    } 
    
	public static void main(String[] args) {
		FastReader scn = new FastReader();
				
		int n = scn.nextInt();
		ArrayList<pair> list = new ArrayList<>();
		
		while(n-- > 0) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			pair p1 = new pair(x, 1);
			pair p2 = new pair(y, -1);
			list.add(p1);
			list.add(p2);
		}
		Collections.sort(list, new sort());
		
		int ans = 0;
		int cnt = 0;
		
		for(pair rp : list) {
			cnt += rp.b;
			ans = Math.max(ans, cnt);
		}
		
		out.println(ans);
        out.close();

		
	}
}

