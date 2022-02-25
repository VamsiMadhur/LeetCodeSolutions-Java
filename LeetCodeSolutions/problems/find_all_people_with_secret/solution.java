class Solution {
    int[] rank;
    int[] root;
    boolean[] isKnown;
    
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        rank = new int[n];
        root = new int[n];
        isKnown = new boolean[n];
        
        for(int l=0; l<n; l++) root[l] = l;
        
        isKnown[0] = true;
        isKnown[firstPerson] = true;
        
        root[firstPerson] = 0;
        rank[0] = n+1;
        
        Arrays.sort(meetings, (a,b) -> (a[2] - b[2]));
        
        int time = meetings[0][2];
        int pointer = 0;
        
        while(true) {
            
            int i;
            for(i=pointer; i<meetings.length; i++) {
                if(meetings[i][2] != time) break;
                int p1 = meetings[i][0];
                int p2 = meetings[i][1];
                if(isKnown[p1] && isKnown[p2]) continue;
                union(p1, p2);
            }
            
            for(int m= pointer; m<i; m++) {
                int p1 = meetings[m][0];
                int p2 = meetings[m][1];
                if(isKnown[p1] || isKnown[p2]) {
                    isKnown[p1] = true;
                    isKnown[p2] = true;
                } else if(find(p1) == 0 ) {
                    isKnown[p1] = true;
                    isKnown[p2] = true;
                } else {
                    root[p1] = p1;
                    root[p2] = p2;
                }
            }
            
            if(i<meetings.length) {
                pointer = i;
                time = meetings[i][2];
            } 
            if(i >= meetings.length) break;
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(isKnown[i]) result.add(i);
        }
        return result;
    }
    
    public int find(int x) {
        if(x != root[x]) {
            x = find(root[x]);
        }
        return x;
    }
    
    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        
        if(a == b) return;
        if(rank[a] > rank[b]) {
            root[b] = a;
        } else {
            root[a] = b;
            if(rank[a] == rank[b]) rank[b]++;
        }
        
    }
}