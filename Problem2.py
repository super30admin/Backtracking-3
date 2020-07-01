# Time Complexity : O(m x n x 3^n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    m, n = None, None 
    def exist(self, board, word):
        self.m, self. n = len(board), len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if (self.dfs(board, word, i, j, 0)):
                    return True 
        return False 
    
    def dfs(self, board, word, i, j, indx):
        # base 
        if indx == len(word):
            return True 
        if i < 0 or j < 0 or i == len(board) or j == len(board[0]) or board[i][j] == '#':
            return 
        
        # logic 
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        if word[indx] == board[i][j]:
            temp = board[i][j]
            board[i][j] = '#'
            for dir in dirs:
                r = i + dir[0]
                c = j + dir[1]
                if self.dfs(board,word,r,c,indx+1):
                    return True 
            board[i][j] = temp 

if __name__ == "__main__":
    s = Solution()
    board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
    word = "ABCED"
    res = s.exist(board,word)
    print(res)