class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [[False] * n for _ in range(n)]
        result = []
        self.backtrack(board, 0,result)
        return result
    
    def backtrack(self, board: List[List[bool]], r: int,result: List[List[str]]):
        #base case
        if r == len(board):
            li = []
            for i in range(len(board)):
                sb = []
                for j in range(len(board[0])):
                    if board[i][j]:
                        # there is a queen
                        sb.append('Q')
                    else:
                        sb.append('.')
                li.append(''.join(sb))
            
            result.append(li)


        #logic
        for c in range(len(board)):
            if self.isSafe(board,r,c):
                #action
                board[r][c] = True

                #recurse
                self.backtrack(board,r+1,result)

                #bakctrack
                board[r][c] = False

    def isSafe(self,board : List[List[bool]], r: int, c: int) -> bool:
        #up
        for i in range(r):
            if board[i][c]:
                return False
        #diagnol left
        i = r
        j = c
        while i >= 0 and j >=0:
            if board[i][j]:
                return False
            i -= 1
            j -= 1
        #diagnol right
        i = r
        j = c
        while i >= 0 and j < len(board):
            if board[i][j]:
                return False
            i -= 1
            j += 1

        return True
            

                
        