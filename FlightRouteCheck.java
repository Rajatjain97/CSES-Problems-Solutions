
package cses;

import java.util.*;
import java.io.*;

public class FlightRouteCheck {
	static class Reader {
		
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}
			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

	static int[] vis;
	static HashMap<Integer, ArrayList<Integer>> graph, graphRev;
	static LinkedList<Integer> stack;
	static ArrayList<Integer> comp, ans;

	public static void dfs(int node) {
		vis[node] = 1;
		for (int child : graph.getOrDefault(node, new ArrayList<>())) {
			if (vis[child] == 0)
				dfs(child);
		}
		stack.push(node);
	}

	public static void dfs2(int node) {
		vis[node] = 0;
		for (int child : graphRev.getOrDefault(node, new ArrayList<>())) {
			if (vis[child] == 1)
				dfs2(child);
		}
		comp.add(node);
	}

	public static void main(String[] args) throws IOException {
		Reader scn = new Reader();
		graph = new HashMap<>();
		graphRev = new HashMap<>();
		vis = new int[(int) 1e5 + 10];
		stack = new LinkedList<>();
		comp = new ArrayList<>();
		ans = new ArrayList<>();

		int n = scn.nextInt();
		int m = scn.nextInt();

		for (int i = 0; i < n; i++) {
			graph.put(i + 1, new ArrayList<>());
			graphRev.put(i + 1, new ArrayList<>());
		}

		while (m-- > 0) {
			int u = scn.nextInt(), v = scn.nextInt();
			graph.get(u).add(v);
			graphRev.get(v).add(u);
		}

		for (int i = 1; i <= n; i++) {
			if (vis[i] == 0) {
				dfs(i);
			}
		}

		while (!stack.isEmpty()) {
			int rm = stack.pop();
			if (vis[rm] == 1) {
				dfs2(rm);
				if (comp.size() == n) {
					System.out.println("YES");
//					System.exit(0);
					return;
				}
				ans.add(comp.get(0));
				if (ans.size() >= 2) {
					System.out.println("NO\n" + ans.get(1) + " " + ans.get(0));
//					System.exit(0);
					return;
				}
				comp = new ArrayList<>();
			}
		}
	}
}