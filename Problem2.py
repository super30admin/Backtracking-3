#Time Complexity: O(N* 3** L) L is length of the word
#Space Complexity: O(L)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        row = len(board)
        col = len(board[0])
        dirr = [[0,1],[1,0],[0,-1],[-1,0]]
        
        def dfs(r,c,index):
            #base
            if r <0 or c < 0 or r==row or c == col or board[r][c] == '#':
                return False
            #logic
            if board[r][c] == word[index]:
                if index + 1 == len(word):
                    return True
                ch = board[r][c]
                board[r][c] = '#'
                for i in dirr:
                    new_row = i[0] + r
                    new_col = i[1] + c
                    if dfs(new_row,new_col,index+1):
                        return True
            #backtrack
                board[r][c] = ch
            return False
        for i in range(row):
            for j in range(col):
                if dfs(i,j,0):
                    return True
                
        return False