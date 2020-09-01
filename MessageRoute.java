package cses;

import java.util.*;
import java.io.*;

public class MessageRoute {
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

		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(1);

		int[] vis = new int[n + 1];
		vis[1] = 1;

		int[] prev = new int[n + 1];

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int par = queue.removeFirst();
				for (int child : graph.get(par)) {
					if (vis[child] == 0) {
						vis[child] = 1;
						queue.add(child);
						prev[child] = par;
					}
				}
			}
		}

		if (prev[n] == 0)
			System.out.println("IMPOSSIBLE");
		else {
			ArrayList<Integer> ans = new ArrayList<>();
			int start = n;

			while (start != 0) {
				ans.add(start);
				start = prev[start];
			}

			Collections.reverse(ans);
			StringBuffer sb = new StringBuffer();

			sb.append(ans.size()).append('\n');
			for (int val : ans)
				sb.append(val + " ");

			System.out.println(sb);
		}
	}
}
