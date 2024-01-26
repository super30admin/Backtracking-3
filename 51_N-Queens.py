# Solution

# // Time Complexity : n! (n factorial), that's because, for each position in first we can have n-2 positions that can be
#                      occupied in next row, and n-4 positions in third row and so on. Since we cannot occupy same row,column
#                      and diagonal. So in total n(n-2)(n-4)(n-6).... leading to approximately say time complexity as n!
# // Space Complexity : n^2 since we are using 2D array/grid
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# This is an exhaustive approach
# Approach is to check all the possible options by keeping Q in one of the n positions of firt row and continue in further rows
# to check if we get a solution. Similarly in the first row now we can move by one more position and continue in further rows.
# We continue this DFS kind of solution tracking for each of the N positions of first row giving us the required solution.

def solveNQueens(n):

    def checkValid(matrix,row,col,n):
        tempRow = row
        while tempRow>=0:
            tempRow -= 1
            if matrix[tempRow][col] == "Q":
                return False

        tempRow = row
        tempCol = col
        while tempRow>0 and tempCol>0:
            if matrix[tempRow-1][tempCol-1] == "Q":
                return False
            tempRow -= 1
            tempCol -= 1
        
        tempRow = row
        tempCol = col
        while tempRow>0 and tempCol+1<n:
            if matrix[tempRow-1][tempCol+1] == "Q":
                return False
            tempRow -= 1
            tempCol += 1
        
        return True

    def backtrack(matrix,n,rowPivot,colPivot,result):
        if rowPivot>=n:
            temp = ""
            path = []
            for i in range(n):
                for j in range(n):
                    temp += matrix[i][j]
                path.append(temp)
                temp = ""
            result.append(path.copy())

            return
        
        for j in range(0,n):
            if checkValid(matrix,rowPivot,j,n):
                matrix[rowPivot][j] = "Q"
                backtrack(matrix,n,rowPivot+1,0,result)
                matrix[rowPivot][j] = "."                          
        return

    result = []
    matrix = [["." for _ in range(n)] for _ in range(n)]
    backtrack(matrix,n,0,0,result)
            
    return result

    # def checkValid(matrix,row,col,n):
    #     tempRow = row
    #     while tempRow>=0:
    #         tempRow -= 1
    #         if matrix[tempRow][col] == "Q":
    #             return False
        
    #     tempRow = row
    #     tempCol = col
    #     while tempRow>0 and tempCol>0:
    #         if matrix[tempRow-1][tempCol-1] == "Q":
    #             return False
    #         tempRow -= 1
    #         tempCol -= 1
        
    #     tempRow = row
    #     tempCol = col
    #     while tempRow>0 and tempCol+1<n:
    #         if matrix[tempRow-1][tempCol+1] == "Q":
    #             return False
    #         tempRow -= 1
    #         tempCol += 1
        
    #     return True

    # def backtrack(matrix,n,rowPivot,colPivot,path,result):
    #     if rowPivot>=n:
    #         result.append(path.copy())
    #         return
    #     tempStr = ""
    #     for i in range(rowPivot,n):
    #         for j in range(0,n):
    #             if j<colPivot:
    #                 tempStr += matrix[i][j]
    #             if checkValid(matrix,i,j,n):
    #                 tempStr_2 = tempStr
    #                 matrix[i][j] = "Q"
    #                 tempStr += matrix[i][j]
    #                 colTemp = j+1
    #                 while colTemp<n:
    #                     tempStr += matrix[i][colTemp]
    #                     colTemp += 1
    #                 path.append(tempStr)
    #                 backtrack(matrix,n,i+1,0,path,result)
    #                 path.pop()
    #                 tempStr = tempStr_2 + "."
    #                 matrix[i][j] = "."
    #             else:
    #                 tempStr += matrix[i][j]
            
    #         return            
    #     return

    # result = []
    # matrix = [["." for _ in range(n)] for _ in range(n)]
    # backtrack(matrix,n,0,0,[],result)    
    # return result

if __name__ == "__main__":
    n = 5
    print(solveNQueens(n))