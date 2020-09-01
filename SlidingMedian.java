package cses;

import java.util.*;
import java.io.*;

public class SlidingMedian {
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
		int n = scn.nextInt(), k = scn.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = scn.nextInt();
		
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		minheap.remove(0);
	}
}
