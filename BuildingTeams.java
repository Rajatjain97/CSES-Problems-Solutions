package cses;

import java.util.*;
import java.io.*;

public class BuildingTeams {
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
	static HashSet<Integer> first, second;
	static int[] vis, color;
	
	
	public static boolean dfs(int node, int c) {

		color[node] = c;
		
		vis[node] = 1;
		for(int child : graph.get(node)) {
			if(vis[child] == 0) {
				if(!dfs(child, c^1)) return false;
			} else {
				if(color[node] == color[child]) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		FastReader scn = new FastReader();
		graph = new HashMap<>();
		first = new HashSet<>();
		second = new HashSet<>();

		int n = scn.nextInt(), m = scn.nextInt();

		for (int i = 0; i < n; i++)
			graph.put(i + 1, new ArrayList<>());

		while (m-- > 0) {
			int u = scn.nextInt(), v = scn.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		vis = new int[n+1];
		color = new int[n+1];
		
		boolean impossible = false;
		
		for(int i=1; i<=n; i++) {
			if(vis[i] == 0) {
				if(!dfs(i, 0)) {
					impossible = true;
					break;
				}
			}
		}
		
		if(impossible) System.out.println("IMPOSSIBLE");
		else {
			StringBuffer sb = new StringBuffer();
			for(int i=1; i<=n; i++) {
				sb.append((color[i] + 1) + " ");
//				if(first.contains(i)) sb.append(1 + " ");
//				else sb.append(2 + " ");
			}
			System.out.println(sb);
		}
	}
}



























