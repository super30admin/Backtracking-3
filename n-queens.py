'''
Did it run on leet code: Not working for n=6 or above
Did you face any problem: check how queen is under attack

Time complexity: Exponential

Algorithm:
- Take an array called queen positions whose length will be equal to n because `n` positions.
- At every row , we traverse for each col we check if the current queen if placed at (row,col)
is under attack from the queens present in queen position array.

- condition to check for attack
    - if same row 
    - if same col 
    - if row-col values is same. This for diagonal from top-left to bottom-right
    - if row+col value is same. This for diagonal from top-right to bottom-left

- we repeat this procedure for every row

'''


class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        solutions = []
        
        for col in range(n):
            queenPositions = [(0,col)]
            if self.solveNQueenFor(n,1,queenPositions):
                solutions.append(queenPositions[:])
        
        result = self.generateSolutionFormat(solutions,n)
        return result
    
    def solveNQueenFor(self,n,row,queenPositions):
        
        if row==n:
            return True
        
        
        for col in range(n):
            isSafe = True
            
            # checking if current queen is under attack 
            for i in range(row):
                if self.checkForAttack((row,col),queenPositions[i]):
                    isSafe = False
                    break
            
            if isSafe:
                queenPositions.append((row,col))
                if self.solveNQueenFor(n,row+1,queenPositions):
                    return True
                else:
                    queenPositions.pop()
        
        return False
            
    
    def checkForAttack(self,queen1,queen2):
        r1,c1 = queen1
        r2,c2 = queen2
        
        if r1==r2 or c1==c2 or r1-c1==r2-c2 or r1+c1==r2+c2:
            return True
        else:
            return False
    
    def generateSolutionFormat(self,solutions,n):
        
        result = []
        for solution in solutions:
            board = [["." for _ in range(n)] for _ in range(n)]
            
            for position in solution:
                r,c = position
                board[r][c] = "Q"
            
            for k in range(len(board)):
                board[k]="".join(board[k])
            
            result.append(board)
        
        return result
    
        
        
        