#Time Complexity : O((3^L)*m*n)
#Sapce Complexity : O(L)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if(self.dfs(board, i, j, word, 0)):
                        return True
        return False
    
    def dfs(self, board, i, j, word, index):
        #BaseCase 
        if(index == len(word)):
            return True
        
        #condition
        if(i >=0 and j >=0 and i < len(board) and j < len(board[0]) and word[index] == board[i][j]):
            board[i][j] = "*"
            if(self.dfs(board, i+1, j, word, index+1) or
            self.dfs(board, i, j+1, word, index+1) or
            self.dfs(board, i-1, j, word, index+1) or
            self.dfs(board, i, j-1, word, index+1)):
                return True
            board[i][j] = word[index]
