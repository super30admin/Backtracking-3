# time and space somplexity will ne exponential n^n
# getting correct output till n=4 after that getting more solutions than expected


class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        m = n
        board = [["." for i in range(n)] for j in range(n)]
        res = []
        def nqueen(n,i,black_col):
            if n == 0:
                temp = [''.join(i) for i in board]
                res.append(temp)
                return 
            for x in range(m):
                if not black_col:
                    board[i][x] = "Q"
                    black_col.append(x)
                    nqueen(n-1,i+1,black_col)
                    board[i][x] = "."
                    black_col.pop()
                else:
                    if x not in black_col and x!= black_col[-1] -1 and x!= black_col[-1] + 1:
                        board[i][x] = "Q"
                        black_col.append(x)
                        nqueen(n-1,i+1,black_col)
                        board[i][x] = "."
                        black_col.pop()
            return 
        nqueen(n,0,[])
        return res
        
            
        
        
        
        
        
        
        
        
        
        
        
        
        
# approch
        # n == 4
        # n * n chess board
#            1 2 3 4
#         1
#         2
#         3
#         4

#         not in same raw
#         not in same column 
#         not in diagonal row 
        
#         1,1: 1
#             2,3: 2 // no place posiible for 3rd queen
                
#         1,2:1
#             2,4:2
#                 3,1:3
#                     4,3:4 // one pssible solution
                        
                        
#         1,3:
#             2,1:
#                 3,4:
#                     4,2:// 2nd solution 
                    
        