class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        
        DSU alice = new DSU(n + 1);
        DSU bob = new DSU(n + 1);
        int removedEdges = 0, totalEdges = 0;
        
        for(int[] e : edges) {
            if(e[0] == 3) {
                boolean isEdgeValidForAlice = alice.union(e[1], e[2]);
                boolean isEdgeValidForBob = bob.union(e[1], e[2]);
                
                if(isEdgeValidForAlice) totalEdges++;//made the edge 
                if(isEdgeValidForBob) totalEdges++;//made the edge
                
                if(!isEdgeValidForAlice || !isEdgeValidForBob) removedEdges++;//remove the edge if it's not valid
            } else if (e[0] == 1) {
                boolean isEdgeValidForAlice = alice.union(e[1], e[2]);
                if(isEdgeValidForAlice) 
                    totalEdges++;
                else
                    removedEdges++;
            } else {
                boolean isEdgeValidForBob = bob.union(e[1], e[2]);
                if(isEdgeValidForBob)  
                    totalEdges++;   
                else
                    removedEdges++;
            }
        }
        
        if(totalEdges != 2 * n - 2) return -1;//n - 1 for alice and n - 1 for bob
                
        return removedEdges;      
    }
}

class DSU {
    private int[] root;
 
    private int[] rank;

    public DSU(int size) {
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