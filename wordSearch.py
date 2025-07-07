# TC: O(m*n*4^L), L is len(word)
# SC: O(L)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        dirs=[(0,1),(1,0),(0,-1),(-1,0)]
        flag=False
        def helper(board, word, row, col, i):
            nonlocal dirs, flag
            #base
            if flag:
                return
            
            #action
            if board[row][col]==word[i]:
                temp=board[row][col]
                board[row][col]='#'
                i+=1
                if i==len(word):
                    flag=True
                    return
                for d in dirs:
                    r=d[0]
                    c=d[1]
                    if row+r>=0 and row+r<len(board) and col+c>=0 and col+c<len(board[0]):
                        #recurse
                        helper(board, word, row+r, col+c, i)
                #backtrack
                board[row][col]=temp
                
        
        for row in range(len(board)):
            for col in range(len(board[0])):
                if board[row][col]==word[0]:
                    helper(board,word,row,col,0)
                    if flag:
                        return flag

        
        return flag