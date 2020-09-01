package cses;
import java.util.*;
import java.io.*;

public class SumOfTwoValues {
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
		int x = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = scn.nextInt();
		
		int[] copy = arr.clone();
		
		Arrays.sort(arr);
		int l = 0, r = n-1;
		
		while(l < r) {
			int curr = arr[l] + arr[r];
			if(curr== x) {
				break;
			} else if(curr < x) l++;
			else r--;
		}
		if(l == r) System.out.println("IMPOSSIBLE");
		else {
			int a = -1; int b = -1;
			boolean A = false, B = false;
			for(int i=0; i<n; i++) {
				if(!A && arr[l] == copy[i]) {a = i+1; A = true;}
				else if(!B && arr[r] == copy[i]) { b = i+1; B = true; }
			}
			System.out.println(a + " " + b);
		}
	}
}
