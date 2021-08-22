class UnionFind {
    int[] parent;
    int[] size;
    
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++) {
            parent[i]=i;
            size[i]=1;
        }
    }
    
    public int find(int A) {
        int root = A;
        
        while(parent[A] != root) {
            root = parent[A];
        }
        
        int temp = A;
        while(temp != root) {
            int oldroot = parent[temp];
            parent[temp] = root;
            temp = oldroot;
        }
        
        return root;
    }
    
    public boolean union(int A, int B) {
        int parentA = find(A);
        int parentB = find(B);
        
        if(parentA == parentB) return false;
        
        if(size[parentA] < size[parentB]) {
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
        } else {
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
        }
        return true;
    }
}



class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != (n-1)) return false;
        
        UnionFind unionFind = new UnionFind(n);
        
        for(int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            if(!unionFind.union(A, B)) return false;
        }
        return true;
    }
}