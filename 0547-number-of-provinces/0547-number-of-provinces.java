// UnionFind.class
class UnionFind {
     int[] root;
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
     int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is
                         // a standalone vertex with no connection to other vertices.
        }
    }

	// The find function here is the same as that in the disjoint set with path compression.
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

	// The union function with union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len=isConnected.length;
        List<Integer> li = new ArrayList<>();
        UnionFind uf = new UnionFind(len);
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(isConnected[i][j]==1){
                    uf.union(i,j);
                }
            }
        }
        System.out.print(Arrays.toString(uf.root));
        int count=0;
        for(int i=0;i<len;i++){
            if(uf.root[i]==i){
                count++;
            }
        }
        return count;
    }
}