#Time complexity : O(n!) here n is given dimension of board for example if n = 4 then for putting in first row we will have n option then for putting in second row we will have (n-2) as same column as first row avoid and can't put diagonal then for third row it is (n-3) as diagonal both removed, column removed 
#Thus it is euqivalent to n(n-1)(n-2)(n-3)... = n!
#Space complexity : O(n*n) where n is creating of boolean matrix
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=7cZkbmXlRjM&ab_channel=%7BS30%7D
class Solution:
    def __init__(self):
        self.result = []
    def solveNQueens(self, n: int) -> List[List[str]]:
        #null condition
        if n == 0:
            return self.result
        #creating the a boolean board of n*n and initially assigning the value false to it 
        board = [[False for j in range(n)] for i in range(n)]
        self.backtrack(board, 0, n)
        return self.result
    def backtrack(self, board: List[List[str]], row :int, n : int):
        #base case
        #when index goes out of bound for the row then we will perform base condition i.e. when base condition is reached at that time a valid matrix will be created with all n queen placed in it
        if row == n:
            #creating new list for appending the 
            li = []
            #iterating over each row
            for i in range(n):
                #using string builder here i.e., in each iteration we will attach the answer queen or not for creating the board
                sb = ""
                #iterating over each column of a row
                for j in range(n):
                    if board[i][j]:
                        #for appending in the string builder 
                        sb+="Q"
                    else:
                        sb+="."
                #appending the whole row to the main board
                li.append(sb)
            #appending the whole board to the result
            self.result.append(li)

        #logic 
        #recursion will handle the case of the row and iteration will handle the column iteration
        for column in range(n):
            if self.issafe(board, row, column, n):
                #action 
                #from if we will come to know that is the current position is safe to keep the queen if fuction gives true than we will place the queen and further we will call the recursion function for the next row
                board[row][column] = True
                #recurse
                self.backtrack(board, row+1,n)
                #backtrack
                #backtracking will work when further recursion on the rows are not possible or either we have already got the actual output and we are going back for finding other possibilites
                board[row][column] = False
    def issafe(self, board: List[List[str]], row :int, column : int, n: int):
        #checking upper half column of particular column
        for i in range(row):
            #checking if there is a queen in upper columns for a particular column
            if board[i][column]:
                return False
        #checking the right diagonal if there is queen present of not
        i = row
        j = column
        while i>=0 and j>=0:
            if board[i][j]:
                return False
            i-=1
            j-=1
        #checking the left diagonal if there is queen present of not
        i = row
        j = column
        while i>=0 and j<n:
            if board[i][j]:
                return False
            i-=1
            j+=1
        return True
                
        
