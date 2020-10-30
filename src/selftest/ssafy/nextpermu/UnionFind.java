package selftest.ssafy.nextpermu;

public class UnionFind {
	private static int[] parent;
	private static int[] rank;
	private static int N;

	public static void main(String[] args) {
		N = 6;
		parent = new int[N];
		rank = new int[N];

		for (int i = 0; i < N; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return parent[x];
		} else {
			return parent[x] = find(parent[x]);
		}
	}

	public static boolean isConnected(int x, int y) {
		return find(x) == find(y);
	}

	public static void union(int x, int y) {
		int xp = find(x);
		int yp = find(y);

		if (xp == yp)
			return;

		if (rank[xp] < rank[yp]) {
			parent[xp] = yp;
		} else {
			parent[yp] = xp;
		}
		
		if(rank[x] == rank[y]) {
			rank[x]++;
		}
	}

}
