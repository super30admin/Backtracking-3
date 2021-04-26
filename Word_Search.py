class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        directions = [(0,1), (1,0), (0,-1), (-1,0)] # right, down, left, up
        N = len(word)
        m,n = len(board), len(board[0])
        
        ### Depth First Search
        def dfs(row, col, p_idx=0):
            
            ### Base Case
            if p_idx == N:
                return True
            
            # If out of bounds or character does not match
            if row < 0 or col < 0 or row == m or col == n or board[row][col] != word[p_idx]:
                return False
                        
            ### Logic
            
            # Action
            temp = board[row][col]
            board[row][col] = "#"
            p_idx += 1
            
            # Recursive dfs in all directions
            for di,dj in directions:
                n_row, n_col = row+di, col+dj
                found = dfs(n_row, n_col, p_idx)

                # If word is found, terminate search and return
                if found:
                    return found
            
            # BackTrack
            board[row][col] = temp
            return False
        
        
        for i in range(m):
            for j in range(n):
                if dfs(i,j):
                    return True
        return False


#### Complexity Analysis ####

# Time Complexity: O(Nx3^L) --> N = mxn (matrix), L = Length of word. 
# We might have to do DFS from each point coordinate, and a DFS traversal will take 3^L since at each step we have three choices bounded by length of the word.

# Space Complexity: O(L) --> Length of word contributed by recursive stack