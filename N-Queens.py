#Time:O(n!)
#Space:O(n*n)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        self.curr_matrix  = [["." for _ in range(n)] for _ in range(n)] #matrix for each dfs
        self.col_set = set() #columns set to track queen positions
        self.ans = [] #list to store all possible combinations
        def traverse(x):
            """
            Function to traverse the possible paths for placing queen
            """
            
            #Base Condition N queens have been placed
            if x==n:
                self.ans.append(["".join(row[:]) for row in self.curr_matrix])
                return
            
            
            for y in range(n):
                
                #check if a queen is already placed in that column
                if y in self.col_set:
                    continue
                
                #check if a queen can be placed at this position without falling on diagonal path of any other queen
                if self.is_allowed(x,y,n):
                    
                    #update the position in column set and place queen in matrix
                    self.col_set.add(y)
                    self.curr_matrix[x][y] = "Q"
                    
                    #explore next row
                    traverse(x+1)
                    
                    #remove the changes while backtracking
                    self.col_set.remove(y)
                    self.curr_matrix[x][y] = "."
        
        #caller function
        traverse(0)
        return self.ans
    
    
    def is_allowed(self,x,y,n):
        """
        Checks if there's a queen at diagonal elelements, return False if found else True
        """
        #check on left diagonal
        x_left = x-1
        y_left = y-1
        while(x_left>=0 and y_left>=0 and x_left<n and y_left<n):
            if self.curr_matrix[x_left][y_left] == "Q":
                return False
            x_left = x_left-1
            y_left = y_left-1
        
        #check on right diagonal
        x_right = x-1
        y_right = y+1
        while(x_right>=0 and y_right>=0 and x_right<n and y_right<n):
            if self.curr_matrix[x_right][y_right] == "Q":
                return False

            x_right = x_right-1
            y_right = y_right+1
        
        return True
    