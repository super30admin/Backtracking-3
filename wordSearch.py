'''
time complexity: O(exp)
space complexity: O(L)
L is len of word
'''
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if(len(board) == 0): return False 
        global dirs
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.backtrack(board,i,j,0,word): return True
        return False
    
    def backtrack(self,board,i,j,idx,word):
        if(idx==len(word)): return True
        if(i<0 or j<0 or i>=len(board) or j>=len(board[0])):
            return False
        
        
        if(board[i][j] == word[idx]):
            board[i][j] = '#'
            for d1,d2 in dirs:
                newi = i + d1
                newj = j + d2
                if self.backtrack(board,newi,newj,idx+1,word):
                    return True
            board[i][j]=word[idx]
        return False
                
                    
        