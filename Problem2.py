# 51. N-Queens
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [[False for _ in range(n)] for _ in range(n)] 

        def isSafe(i,j,n):
            r = i
            c = j

            while r >= 0:
                if board[r][c]:
                    return False
                r -= 1

            r = i
            c = j
            while r >= 0 and c >= 0:
                if board[r][c]:
                    return False
                r -= 1
                c -= 1 
            
            r = i
            c = j
            while c < n and r >= 0:
                if board[r][c]:
                    return False
                r -= 1
                c += 1

            return True

        def helper(i,n):
            #base
            if i == n:
                temp = []
                for r in range(n):
                    row = ""
                    for c in range(n):
                        if board[r][c]:
                            row += "Q"
                        else:
                            row += "."
                    temp.append(row)
                result.append(temp)
                return 

            #logic
            for j in range(n):
                if isSafe(i,j,n):
                    board[i][j] = True
                    helper(i+1,n)
                    board[i][j] = False

        result = []
        helper(0,n)
        return result

            





        