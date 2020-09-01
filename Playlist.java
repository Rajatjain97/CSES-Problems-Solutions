package cses;
import java.util.*;
import java.io.*;

public class Playlist {
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
		for(int i=0;i<n;i++) arr[i] = scn.nextInt();
			
		HashMap<Integer,Integer> map = new HashMap<>();
	 
	    int result = 0;
	    int lo = 0, hi = 0;
	    
	    while(hi < n) {
	    	int val = arr[hi];
	    	if(!map.containsKey(val)) {
	    		map.put(val, 1);
	    		hi++;
	    		result = Math.max(result, hi - lo);
	    	} else {
	    		while(map.containsKey(val) && lo < hi) {
	    			map.remove(arr[lo++]);
	    		}
	    		map.put(val, 1);
	    		hi++;
	    	}
	    }
	    
	    System.out.println(result);
	}
}
