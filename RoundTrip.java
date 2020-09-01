package cses;

import java.util.*;

import java.io.*;

public class RoundTrip {
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

	static HashMap<Integer, ArrayList<Integer>> graph;
	static int[] vis, prev;
	static ArrayList<Integer> ans = new  ArrayList<>();

	public static void dfs(int node, int par) {
		vis[node] = 1;
		prev[node] = par;
		
		for (int child : graph.get(node)) {
			if(child == par) continue;
			if(vis[child] == 1) {
				while(node != child) {
					ans.add(node);
					node = prev[node];
				}
				ans.add(child);
				ans.add(0, node);
				StringBuffer sb = new StringBuffer();
				sb.append(ans.size()).append('\n');
				for(int val : ans) sb.append(val + " ");
				System.out.println(sb);
				System.exit(0);
			}
			else dfs(child, node);
		}		
	}

	public static void main(String[] args) { 
		FastReader scn = new FastReader();
		graph = new HashMap<>();

		int n = scn.nextInt(), m = scn.nextInt();

		for (int i = 0; i < n; i++)
			graph.put(i + 1, new ArrayList<>());

		while (m-- > 0) {
			int u = scn.nextInt(), v = scn.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		vis = new int[n + 1];
		prev = new int[n+1];

		int i=1;
		for (i = 1; i <= n; i++) {
			if (vis[i] == 0) {
				dfs(i, 0);
			}
		}
		System.out.println("IMPOSSIBLE");

	}
}
