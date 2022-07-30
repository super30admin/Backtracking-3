from pip import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if(len(board)==0):
            return False
        m = len(board)
        n = len(board[0])
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        def traverse(board, word,i, j):
            if(len(word)==0):
                return True
            if(i<0 or i>=m or j<0 or j>=n or board[i][j]!=word[0]):
                return False
            ret = False
            board[i][j] = '#'
            for a,b in dirs:
                if(traverse(board, word[1:], i+a, j+b) is True):
                    ret = True
                    break
            board[i][j] = word[0]
            return ret
        queue = []
        for i in range(m):
            for j in range(n):
                if(board[i][j] == word[0]):
                    queue.append([i,j])
        while(len(queue)!=0):
            curr = queue.pop(0)
            ret = traverse(board, word, curr[0], curr[1])
            if(ret is True):
                return True
        return False
                    
            
                
                
                
                
                
        
        
        