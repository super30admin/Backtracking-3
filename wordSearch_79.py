
# Time Complexity : O(n*m * n*m), when all the matrix has only As
# Space Complexity : O(1), without recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class Solution:
    
    def exist(self, board: List[List[str]], word: str) -> bool:
        #build a directions array
        dirn = [[-1,0], [1,0], [0,1], [0,-1]]
        
        #making recursive calls when first alphabet of the input is found on the board
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==word[0]:
                    if (self.backtracking(board, i, j, word, 0, dirn)):
                        return True
        return False
                
        
        
    def backtracking(self, board, i, j, word, index, dirn):
        
        #base case: is it the answer?
        if index>= len(word)-1:
            return True
        
        #put the letter in a temp so that we can replace the letters with # going forward and retain the letters while backtracking
        temp = board[i][j]
        board[i][j] = '#'
        
        #recursive case
        for d in dirn:
            r = i + d[0]
            c = j + d[1]
            
            if 0<=r<len(board) and 0<=c<len(board[0]) and index+1<len(word) and word[index+1]==board[r][c]:
                #breaking out of recursion when we have found the solution
                if (self.backtracking(board, r, c, word, index+1, dirn)):
                    return True
                
        #while backtracking, replace the # with original value so that we can search for other possibilities
        board[i][j] = temp
        
        return False
            
        
        