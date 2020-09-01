package cses;

import java.util.*;
import java.io.*;

public class RoadConstruction {
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

	static int par[];

	// parent contains the number of node in that components
	// while its children contain their parent
	public static void union(int a, int b) {
		par[a] += par[b];
		par[b] = a;
	}

	public static int find(int n) {
		if (par[n] < 0) {
			return n;
		} else {
			int x = find(par[n]);
			par[n] = x;
			return x;
		}

	}

	public static void main(String[] args) throws IOException {
		Reader scn = new Reader();
		int n = scn.nextInt(), m = scn.nextInt();

		par = new int[n + 1];
		Arrays.fill(par, -1);

		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i <= n; i++)
			set.add(i);

		int max = 1;
		StringBuffer sb = new StringBuffer();
		while (m-- > 0) {
			int u = scn.nextInt(), v = scn.nextInt();
			int a = find(u);
			int b = find(v);
			if (a != b) {
				union(a, b);
				set.remove(b);
				max = Math.max(max, Math.abs(par[a]));
			}
			sb.append(set.size() + " " + max).append('\n');
		}
		System.out.println(sb);
	}

}
