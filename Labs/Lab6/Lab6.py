def canFinish(numCourses, prerequisites):
    from collections import defaultdict

    # create adjacency list for the graph
    adj_list = defaultdict(list)
    for dest, src in prerequisites:
        adj_list[src].append(dest)
    
    # states: 0 = unvisited, 1 = visiting, 2 = visited
    visited = [0] * numCourses
    
    # helper function to perform DFS and detect cycles
    def has_cycle(v):
        if visited[v] == 1:
            # cycle found
            return True  
        if visited[v] == 2:
            # fully visited, no cycles
            return False  
        
        # mark the node as visiting
        visited[v] = 1
        for neighbor in adj_list[v]:
            if has_cycle(neighbor):
                #cycle found
                return True 
        # mark as fully visited
        visited[v] = 2
        #no cycles
        return False
    
    # check each course for cycles
    for course in range(numCourses):
        if has_cycle(course):
            # cycle found
            return False  
    # no cycles
    return True  

#test case 1
numCourses1 = 2
prerequisites1 = [[1, 0]]
print(canFinish(numCourses1, prerequisites1))

#test case 2
numCourses2 = 2
prerequisites2 = [[1, 0], [0, 1]]
print(canFinish(numCourses2, prerequisites2))
