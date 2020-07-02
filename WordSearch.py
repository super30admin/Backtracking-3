
---------------------------------- Word Search-------------------------------------
# Time Complexity : O(2^n*MXN) M is the length of the board, N is the length of the board and n is the length of string
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I have used recursive solution where I choose a index or not choose the index of the string or not choose the index.
# When ever we find the echar in the matrix we will search all 4 directions of the element in board and go in that direction if it matches with the next element in the string.
# Return True when all the elements of string are traversed that is when the index == len(s).

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(board, word,index,i,j):
            if index == len(word): # If we have seen all the matching characters in a word, we're done.
                return True
            else:
                if i < 0 or j < 0 or i > len(board)-1 or j > len(board[0])-1 or board[i][j] != word[index]:
                    return
                    
                temp = board[i][j]
                board[i][j] = '#'
                result = False or dfs(board, word, index+1,i+1,j) or dfs(board, word, index+1,i-1,j) or dfs(board, word, index+1,i,j-1) or dfs(board, word, index+1,i,j+1) 
                board[i][j] = temp
            return result
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(board, word,0,i,j):
                    return True
        return False