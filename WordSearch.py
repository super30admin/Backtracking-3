# Time Complexity : O(numRows * numCols * 3 ^(length of word))
# Space Complexity : O(length of word) + O(numRows * numCols) for recursive stack, visited set.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        # dfs
        def dfs(row, col, visited, index):
            # base
            if index == len(word):
                return True
            
            # logic
            ret = False
            for d in dirs:
                adjRow, adjCol = row + d[0], col + d[1]
                if 0 <= adjRow < numRows and 0 <= adjCol < numCols:
                    if board[adjRow][adjCol] == word[index] and (adjRow, adjCol) not in visited:
                        visited.add((adjRow, adjCol))
                        ret = dfs(adjRow, adjCol, visited, index + 1)
                        visited.remove((adjRow, adjCol))
                        if ret:
                            return ret
            
            return ret
        
        ret = False
        numRows = len(board)
        numCols = len(board[0])
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        for i in range(numRows):
            for j in range(numCols):
                if board[i][j] == word[0]:
                    visited = set()
                    visited.add((i, j))
                    ret = dfs(i,j, visited, 1)
                    visited.remove((i, j))
                    if ret:
                        return True
                
        return ret