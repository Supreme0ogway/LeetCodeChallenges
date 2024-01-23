// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

// Example 1:

// Input:
// n = 5
// edges = [[0, 1], [0, 2], [0, 3], [1, 4]]

// Output:
// true
// Example 2:

// Input:
// n = 5
// edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]

// Output:
// false
// Note:

// You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
// Constraints:

// 1 <= n <= 100
// 0 <= edges.length <= n * (n - 1) / 2

class Solution {

    private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {
        adjacencyList.clear();  
    
        if (n == 1) return edges.length == 0;
    
        if (edges.length == 0) return false;
    
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjacencyList.putIfAbsent(node1, new ArrayList<>());
            adjacencyList.putIfAbsent(node2, new ArrayList<>());
            adjacencyList.get(node1).add(node2);
            adjacencyList.get(node2).add(node1);
        }
    
        Set<Integer> visited = new HashSet<>();
    
        if (!depthFirstSearch(edges[0][0], -1, visited)) return false;
    
        return visited.size() == n;
    }

    private boolean depthFirstSearch(int node, int previous, Set<Integer> visited) {
        if (visited.contains(node)) return false;

        visited.add(node);

        for (int neighbor : adjacencyList.get(node)) {
            if (neighbor == previous) continue;

            if (!depthFirstSearch(neighbor, node, visited)) return false;
        }

        return true;
    }
}