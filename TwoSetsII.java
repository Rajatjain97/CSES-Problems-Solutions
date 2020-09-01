package cses;
import java.util.*;
import java.io.*;

public class TwoSetsII {
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
		
		int sum = n*(n+1)/2;
		if(sum%2 == 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		int mod = (int)1e9 + 7;
		
		long []dp = new long[(sum+1)];
		
		sum/=2;
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = i * (i + 1) / 2; j >= i; j--) {
				dp[j] = (dp[j] + dp[j - i]) % mod;
			}
		}
		
		System.out.println(dp[sum]*((mod+1)/2)%mod);
	}
}
