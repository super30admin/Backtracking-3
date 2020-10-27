# O(N!) TIME AND O(N) SPACE WHERE N IS LEN OF BOARD

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        possibilities = []
        board = [["." for j in range(n)] for i in range(n)]
        self.explore(board,0,possibilities)
        return possibilities
    
    def explore(self,board,rowidx,possibilities):
        if rowidx == len(board):
            self.constructOutput(board,possibilities)
            return
        
        for j in range(len(board)):
            if self.isValid(board,rowidx,j):
                board[rowidx][j] = "Q"
                self.explore(board,rowidx + 1,possibilities)
                board[rowidx][j] = "."
                
                
        
    def isValid(self,board,row,col):
        for i in range(len(board)):
            for j in range(len(board)):
                if (board[i][j] == "Q") and (j == col or row + col == i + j or row - col == i - j):
                    return False
        return True
                
    
    def constructOutput(self,board,possibilities):
        current_poss = []
        for i in range(len(board)):
            current_row = []
            for j in range(len(board)):
                current_row.append(board[i][j])
            s = ''.join(current_row)
            current_poss.append(s[:])
        possibilities.append(current_poss[:])