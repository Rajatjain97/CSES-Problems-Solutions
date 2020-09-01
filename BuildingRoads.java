package cses;

import java.util.*;
import java.io.*;

public class BuildingRoads {
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

	public static void dfs(int node, int[] vis) {
		vis[node] = 1;
		for (int child : graph.get(node)) {
			if (vis[child] == 0)
				dfs(child, vis);
		}
	}

	public static void main(String[] args) {
		FastReader scn = new FastReader();
		graph = new HashMap<>();

		int n = scn.nextInt(), m = scn.nextInt();

		for (int i = 0; i <= n; i++)
			graph.put(i, new ArrayList<>());

		while (m-- > 0) {
			int u = scn.nextInt(), v = scn.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		int[] vis = new int[n + 1];
		ArrayList<Integer> repNodes = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (vis[i] == 0) {
				dfs(i, vis);
				repNodes.add(i);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		int cnt = repNodes.size() - 1;
		if (cnt > 0) {
			sb.append(cnt).append('\n');
			int first = repNodes.get(0);
			for (int i = 1; i < repNodes.size(); i++) {
				int second = repNodes.get(i);
				sb.append(first + " " + second).append('\n');
				first = second;
			}
			System.out.print(sb);
		} else
			System.out.println(0);
	}
}
