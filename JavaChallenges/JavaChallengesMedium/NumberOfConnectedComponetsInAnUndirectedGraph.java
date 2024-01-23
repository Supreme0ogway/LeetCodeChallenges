// There is an undirected graph with n nodes. There is also an edges array, where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.

// Return the total number of connected components in that graph.

// Example 1:

// Input:
// n=3
// edges=[[0,1], [0,2]]

// Output:
// 1
// Example 2:

// Input:
// n=6
// edges=[[0,1], [1,2], [2, 3], [4, 5]]

// Output:
// 2
// Constraints:

// 1 <= n <= 100
// 0 <= edges.length <= n * (n - 1) / 2

class Solution {
    //make parent and rank
    private int[] par;
    private int[] rank;

    public int countComponents(int n, int[][] edges) {
        //go through adding 1-n to arrays
        par = new int[n];
        rank = new int[n];
        
        for(int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = i;
        }

        //set what you return to max nodes given
        int result = n;

        //loop thorugh all edges
        for(int i = 0; i < edges.length; i++) {
            //check all rows of index 0,1 for (node 0, node 1)
            if(unionFind(edges[i][0], edges[i][1]) == 1) {
                result--;//decrements it for each union
            }
        }

        return result;//this returns the final res
    }

    //this helps find the root of the component node
    private int find(int node) {
        int result = node;

        //while the parent spot is not the node 
        //loop through setting the connections to 
        //the right spot
        //res is the root of each connection
        while(par[result] != result) {
            par[result] = par[par[result]];
            result = par[result];
        }

        return result;
    }

    private int unionFind(int n1, int n2) {
        //find both connection node's parent/root node
        int p1 = this.find(n1);
        int p2 = this.find(n2);

        //this makes sure that it doesn't decrement for 
        //a same node inter
        if(p1 == p2) {
            return 0;
        }

        //change the parent if this \/
        if(rank[p2] > rank[p1]) {
            par[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            par[p2] = p1;
            rank[p1] += rank[p2];
        }

        return 1;
    }
}
