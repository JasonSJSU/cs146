from typing import List

class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        #list of all pipes and wells
        all_pipes = [[0, i + 1, wells[i]] for i in range(n)]
        
        # Add all pipes to list
        all_pipes.extend(pipes)
        
        # Sort pipes based on cost
        all_pipes.sort(key=lambda x: x[2])
        
        # Initialize variables to track minimum cost and union-find structure
        min_cost = 0
        parent = list(range(n + 1))

        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        def union(x, y):
            root_x = find(x)
            root_y = find(y)
            parent[root_x] = root_y

        # Iterate through all pipes
        for pipe in all_pipes:
            house1, house2, cost = pipe
            
            # If the two houses are not already connected, connect them and add cost
            if find(house1) != find(house2):
                union(house1, house2)
                min_cost += cost

        return min_cost

# Test Cases
solution = Solution()

# Test Case
n = 2
wells = [1, 1]
pipes = [[1, 2, 1], [1, 2, 2]]
result = solution.minCostToSupplyWater(n, wells, pipes)
print("Test Case:", result)
