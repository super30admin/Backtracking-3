# 79. Word Search
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m = len(board)
        n = len(board[0])
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]

        def helper(idx,i,j):
            #base
            if idx == len(word):
                return True

            if i < 0 or j < 0 or i >= m or j >= n or board[i][j] == "$":
                return 
            
            #logic
            if word[idx] == board[i][j]:
                board[i][j] = "$"
                for dir_ in dirs:
                    r = i + dir_[0]
                    c = j + dir_[1]
                    if helper(idx+1,r,c):
                        return True
                board[i][j] = word[idx]  

        for i in range(m):
            for j in range(n):
                if helper(0,i,j):
                    return True

        return False

        

        
        