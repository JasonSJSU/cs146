package Lab6;
import java.util.ArrayList;
import java.util.List;

public class Lab6 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create an adjacency list for the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

        //array to track the visit state of each course
        int[] visited = new int[numCourses];

        //check for cycles in the graph using DFS
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adjList, visited)) {
                //cycle found
                return false;  
            }
        }
        //no cycles
        return true;  
    }

    //helper method to perform DFS and detect cycles
    private boolean hasCycle(int node, List<List<Integer>> adjList, int[] visited) {
        //states: 0 = unvisited, 1 = visiting, 2 = visited
        if (visited[node] == 1) {
            //node is in the visiting state, cycle detected
            return true;
        }
        if (visited[node] == 2) {
            //node is already fully visited, no cycle in this path
            return false;
        }

        //mark the node as visiting
        visited[node] = 1;

        //visit all the neighbors of the current node
        for (int neighbor : adjList.get(node)) {
            if (hasCycle(neighbor, adjList, visited)) {
                //cycle detected in the neighbor
                return true;  
            }
        }

        //mark the node as fully visited
        visited[node] = 2;
        //no cycles
        return false;
    }

    public static void main(String[] args) {
        Lab6 solution = new Lab6();

        //test case 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(solution.canFinish(numCourses1, prerequisites1));

        //test case 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(solution.canFinish(numCourses2, prerequisites2));
    }
}
