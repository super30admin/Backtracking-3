#time: o(2^n)
#space:o(n)


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        height = len(board)
        width = len(board[0])
        
        p = len(word)
        
        def helper(r,c,pos):
            if pos>=p:
                return True
            elif 0<=r<height and 0<=c<width and board[r][c]==word[pos]:
                temp=board[r][c]
                board[r][c]=None
                if (helper(r-1,c,pos+1) or
                helper(r+1,c,pos+1) or helper(r,c-1,pos+1) or helper(r,c+1,pos+1)):
                    return True
                board[r][c]=temp
            return False
        
        for r in range(height):
            for c in range(width):
                if helper(r,c,0):
                    return True
                
        return False
                
        