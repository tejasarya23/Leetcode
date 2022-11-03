class Solution {
    public boolean equationsPossible(String[] equations) {
        int len=equations.length;
        UnionFind uf= new UnionFind(26);
        for(int i=0;i<len;i++){
            if(equations[i].charAt(1)=='='){
                uf.union(equations[i].charAt(0)-'a',equations[i].charAt(3)-'a');
                // System.out.print("hello");
            }
        }
        for(int i=0;i<len;i++){
            if(equations[i].charAt(1)=='!'){
                if(uf.connected(equations[i].charAt(0)-'a',equations[i].charAt(3)-'a')){
                    return false;
                }
            }
        }   
        return true;
    }
}
class UnionFind {
    private int[] root;
 
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; 
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX==rootY){
            return false;
        }
        else if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
        return true;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
