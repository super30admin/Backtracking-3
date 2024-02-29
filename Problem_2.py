#
# @lc app=leetcode id=79 lang=python3
#
# [79] Word Search
#

# @lc code=start
'''
Time Complexity - O(mn3^(mn)). For every starting word we have 4 directions to go to and after that 3 directions on avg for subsequent words.
Space Complexity - O(mn). We maintain a recursive stack in this case and worst case will be when the desired string will of the length of the string.

This code works on Leetcode.
'''
class Solution:
    def __init__(self):
        self.dirs = [[-1,0],[1,0],[0,-1],[0,1]] #create a directions array

    def exist(self, board: List[List[str]], word: str) -> bool:
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                if self.helper(board, word, i, j, 0, m , n): # check every element as a start of recursion on the board
                    return True
        return False
    
    def helper(self, board, word, r, c, idx, m, n):
        if idx == len(word): #if we were able to find all the characters of the word in the path
            return True
        if r < 0 or r==m or c<0 or c==n or board[r][c] == "#" or board[r][c] != word[idx]: # return back to parent if we are out of bounds or if the character has been considered or does not match character in the word at that index.
            return False
        if board[r][c] == word[idx]: #if chracter in string matches the character in grid position.
            board[r][c] = "#" #mark it visited.
            for dir in self.dirs: #check in the 4 directions
                nr = r + dir[0]
                nc = c + dir[1]
                if self.helper(board, word, nr, nc, idx+1, m , n): #return True if one of them is along the path
                    return True
            board[r][c] = word[idx] #we are backtracking here


        
# @lc code=end

