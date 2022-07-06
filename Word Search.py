class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        def helper(row, col, word_idx):
            if word_idx == len(word):
                return True
            
            if 0 > row or row >= len(board) or 0 > col or col >= len(board[0]) or board[row][col] != word[word_idx]:
                return False
            
            board[row][col] = "#"
            flag = False
            
            for i,j in [[0,1],[0,-1],[1,0],[-1,0]]:
                flag = helper(row+i, col+j, word_idx + 1)
                if flag:
                    break
            
            board[row][col] = word[word_idx]
            
            return flag
        
        for row in range(len(board)):
            for col in range(len(board[0])):
                if helper(row,col,0):
                    return True
        
        return False
            
