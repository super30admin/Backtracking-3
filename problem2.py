class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.rowlen = len(board)
        self.columnlen = len(board[0])

        for i in range(len(board)):
            for j in range(len(board[0])):
                if(self.helper(board,word,i,j,0)):
                    return True


    def helper (self,board,word,r,c,index):


        if index == len(word):
            return True

        if ((r<0) or (r>=self.rowlen) or (c<0) or (c>=self.columnlen) or board[r][c]=="#"):
            return False

        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        if board[r][c] == word[index]:
            print(board[r][c])
            temp = board[r][c]
            board[r][c] = "#"
            row = r
            column = c
            for i in dirs:
                newr = row + i[0]
                newc = column + i[1]
                if(self.helper(board,word,newr,newc,index+1)):
                    return True

            board[r][c] = temp

        return False





        
