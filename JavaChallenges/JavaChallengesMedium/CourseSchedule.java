// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

 

// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.
// Example 2:

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Initialize in-degrees array to track the number of prerequisites for each course
        int[] inDegrees = new int[numCourses];
        
        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph and calculate in-degrees
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
            inDegrees[course]++;
        }
        
        // Initialize a queue for topological sorting
        Queue<Integer> queue = new LinkedList<>();
        
        // Add courses with in-degree 0 to the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Perform topological sorting
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int nextCourse : graph.get(course)) {
                // Decrease the in-degree of the next course
                inDegrees[nextCourse]--;
                
                // If the in-degree becomes 0, add it to the queue
                if (inDegrees[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        // Check if all courses can be finished (no cycles in the graph)
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] > 0) {
                return false;
            }
        }
        
        return true;
    }
}