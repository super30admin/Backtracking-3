# 79. Word Search
# https://leetcode.com/problems/word-search/

# Logic: Iterate the board. Compare current cell with the first letter in word. 
# If they match, Mark it as visited and start DFS. If the children to this node 
# doesnt equal the next letter in word, we need to backtrack and explore other 
# child nodes. While backtracking set the visited node to its original value.

# Time Complexiety: O(m*n*(3^L)) L is len(words)
# Space Complexiety: O(len(words))
class Solution:      
    def _helper(self, board, word, i, j, idx):
        # Base Case
        if idx == len(word):
            return True
        if 0 > i or i == len(board) or 0 > j or j == len(board[0]) or board[i][j] == '#':
            return False
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        
        if board[i][j] == word[idx]:
            temp = board[i][j]
            board[i][j] = '#'
            
            for _dir in dirs:
                newRow = i + _dir[0]
                newCol = j + _dir[1]

                if self._helper(board, word, newRow, newCol, idx+1):
                    return True

            board[i][j] = temp
        
        return False
        
        
    def exist(self, board, word):
        n = len(board)
        m = len(board[0])
        
        for i in range(n):
            for j in range(m):
                if self._helper(board, word, i, j, 0):
                    return True
        return False

obj = Solution()
print(obj.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],"SEE"))
print(obj.exist([["a"]],"a"))
