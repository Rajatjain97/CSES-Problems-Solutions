
package cses;

import java.util.*;
import java.io.*;

public class ShortestRoute1 {
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

	static class node {
		long c = Long.MAX_VALUE;
		int n = 0;

		node(int nn, long cc) {
			c = cc;
			n = nn;
		}
	}

	static class comp implements Comparator<node> {

		public int compare(node s1, node s2) {
			if (s1.c < s2.c)
				return 1;
			else if (s1.c > s2.c)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) {
		FastReader scn = new FastReader();
		int n = scn.nextInt();
		int m = scn.nextInt();

		HashMap<Integer, ArrayList<node>> graph = new HashMap<>();

		PriorityQueue<node> pq = new PriorityQueue<>(new comp()); // node cost

		for (int i = 1; i <= n; i++) {
			graph.put(i, new ArrayList<node>());
		}

		for (int i = 0; i < m; i++) {
			int u = scn.nextInt(), v = scn.nextInt(), c = scn.nextInt();

			ArrayList<node> list = graph.get(u);
			node arr = new node(v, c);
			list.add(arr);
		}

		int src = 1;
		pq.add(new node(src, 0));

		long[] dist = new long[n + 1];
		Arrays.fill(dist, (long) 1e18);
		dist[1] = 0;

		while (!pq.isEmpty()) {
			node rm = pq.remove();

			if (dist[rm.n] < rm.c)
				continue;
			for (node arr : graph.get(rm.n)) {

				if ((rm.c + arr.c) < dist[arr.n]) {
					dist[arr.n] = rm.c + arr.c;
					pq.add(new node(arr.n, dist[arr.n]));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(dist[i] + " ");
		}
		System.out.println(sb);
	}
}
