#// Time Complexity : 3^n
# // Space Complexity : stack space  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        dr = [1,-1,0,0]
        dc = [0,0,1,-1]
        def backtrack(row,col,ind):
            if ind == len(word):
                return True
            if row < 0 or col < 0 or row >= len(board) or col >= len(board[0]):
                return False
            if board[row][col] == word[ind]:
                board[row][col] = "#"

                for i in range(4):
                    nr = row + dr[i]
                    nc = col + dc[i]
                    if backtrack(nr,nc,ind+1):
                        return True
                board[row][col] = word[ind]
            return False
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if backtrack(i,j,1):
                        return True
        return False

# Approach:
# 1. We will use backtracking to solve this problem. We will start from the first character of
# the word and check if it is present in the board. If it is present, we will mark
# it as visited and then check if the remaining characters of the word can be formed
# by moving in the four directions. If we can form the remaining characters, we will return  