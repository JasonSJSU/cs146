package HW12;

import java.util.*;

public class HW12 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // Create a list to store all pipes including wells
        List<int[]> allPipes = new ArrayList<>();
        
        // Add all wells to the list as pipes with cost wells[i]
        for (int i = 0; i < n; i++) {
            allPipes.add(new int[]{0, i + 1, wells[i]});
        }
        
        // Add all given pipes to the list
        for (int[] pipe : pipes) {
            allPipes.add(pipe);
        }
        
        // Sort all pipes based on their cost
        Collections.sort(allPipes, (a, b) -> a[2] - b[2]);
        
        // Initialize variables to track minimum cost and union-find structure
        int minCost = 0;
        UnionFind uf = new UnionFind(n + 1);
        
        // Iterate through all pipes
        for (int[] pipe : allPipes) {
            int house1 = pipe[0];
            int house2 = pipe[1];
            int cost = pipe[2];
            
            // If the two houses are not already connected, connect them and add cost
            if (!uf.connected(house1, house2)) {
                uf.union(house1, house2);
                minCost += cost;
            }
        }
        
        return minCost;
    }

    public static void main(String[] args) {
        HW12 solution = new HW12();

        // Test Case 1
        int n1 = 2;
        int[] wells1 = {1, 1};
        int[][] pipes1 = {{1, 2, 1}, {1, 2, 2}};
        int result1 = solution.minCostToSupplyWater(n1, wells1, pipes1);
        System.out.println("Test Case 1: "  + result1);
    }

    // Union-Find (Disjoint Set) data structure implementation
    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }
    }
}
