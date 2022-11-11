#Time complexity - O(2^n)
#Space Complexity - O(n)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        colSet = set()
        upperDiag = set()
        lowerDiag = set()
        board = [['.' for _ in range(n)] for _ in range(n)]

        def explore(row):
            nonlocal board
            nonlocal colSet
            nonlocal upperDiag
            nonlocal lowerDiag
            if row == n:
                result.append(convert(board))
                return 
            
            for col in range(n):
                if col  in colSet:
                    continue
                if row - col  in upperDiag:
                    continue
                if row + col  in lowerDiag:
                    continue
                
                colSet.add(col)
                upperDiag.add(row - col)
                lowerDiag.add(row + col)
                board[row][col] = 'Q'
                explore(row + 1)
                board[row][col] = '.'
                colSet.remove(col)
                upperDiag.remove(row - col)
                lowerDiag.remove(row + col)
        
        def convert(board):
            arr = []
            for row in range(n):
                string = ""
                for col in range(n):
                    string += board[row][col]
                arr.append(string)
            return arr
            
        explore(0)
        return result
