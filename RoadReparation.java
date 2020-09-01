package cses;


import java.util.*;
import java.io.*;

public class RoadReparation {
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

	static int[] par;
	
	public static int find(int node) {
		if(par[node] == -1) return node;
		return par[node] = find(par[node]);
	}
	
	
	
	public static void main(String[] args) throws IOException{
		Reader scn = new Reader();
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		int[][] adj = new int[m][3];
		par = new int[n+1];
		
		for(int i=0; i<m; i++) {
			adj[i][1]= scn.nextInt(); adj[i][2] = scn.nextInt(); adj[i][0] = scn.nextInt();
		}
		
		Arrays.sort(adj, (a,b)->(a[0] - b[0]));
		Arrays.fill(par,-1);
		
		long ans = 0;
		
		for(int[] edge : adj) {
			int pu = find(edge[1]), pv = find(edge[2]);
			if(pu != pv) {
				ans += edge[0];
				par[pu] = pv;
			}
		}
		
		int negs = 0;
		for(int i=1;i<=n;i++) {
			if(par[i] < 0) negs ++;
		}
		
		if(negs > 1) System.out.println("IMPOSSIBLE");
		else System.out.println(ans);
		
	}
}



















