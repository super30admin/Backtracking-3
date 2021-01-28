class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        # Time Complexity: O(n!)
        # Space Complexity: O(n^2)
        
        board = [["." for j in range(0,n)] for i in range(0,n)]
        output = []
        def helper(n):
            nonlocal output
            nonlocal board
            if(n==len(board)):
                # add the board to output
                o = []
                for i in range(0,len(board)):
                    x = ""
                    for j in range(0,len(board)):
                        x += board[i][j]
                    o.append(x)
                
                output.append(o)
                return
            
            for i in range(0,len(board)):
                
                if(isValid(n,i)):
                    # action
                    board[n][i]="Q"
                    # recurse
                    helper(n+1)
                    # 
                    board[n][i]="."
            
            
        def isValid(n,i):
            
            # up, left diagonal and right diagonal
            for r in range(n,-1,-1):
                if(board[r][i]=="Q"):
                    return False
            
            c = i
            for r in range(n,-1,-1):
                if(c<0):
                    break
                if(board[r][c]=="Q"):
                    return False
                c-=1
            
            c = i
            for r in range(n,-1,-1):
                if(c==len(board)):
                    break
                if(board[r][c]=="Q"):
                    return False
                c+=1
            
            return True
        
        helper(0)
        return output
