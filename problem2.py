class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.dirs=[(0,1),(1,0),(-1,0),(0,-1)]
        def helper(r,c,index,word):
            if index==len(word):
                return True
            if 0<=r<len(board) and 0<=c<len(board[0]) and board[r][c]!="#" and board[r][c]==word[index]:
                board[r][c]="#"
                for x,y in self.dirs:
                    r1=r+x
                    c1=c+y
                    if helper(r1,c1,index+1,word):
                        return True
                board[r][c]=word[index]
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==word[0]:
                    if helper(i,j,0,word):
                        return True
        return False
    #Time Complexity: O(N.3^L) where N is the number of cells in the board and L is the length of the word, 3 for 3 directions one cell can visit after 1st cell is visited
   #Space O(L), L=length of word
