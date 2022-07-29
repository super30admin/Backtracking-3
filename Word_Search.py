class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m=len(board)
        n=len(board[0])
        l=len(word)
        
        def word_search(row,col,position):
            if position>=l:
                return True
            elif (row>=0 and row<m)and(col>=0 and col<n)and board[row][col]==word[position]:
                temp=board[row][col]
                board[row][col]=None
                if word_search(row-1,col,position+1) or word_search(row+1,col,position+1) or word_search(row,col-1,position+1) or word_search(row,col+1,position+1):
                    return True
                
                board[row][col]=temp
                return False
            
        for i in range(m):
            for j in range(n):
                if word_search(i,j,0):
                    return True
                
        return False