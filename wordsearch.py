 ##Time Complexity : O(m*n*(3^L)) --> exponential
##Space Complexity : O(1); recursive stack space - O(L) --> L = length of the word
##Did this code successfully run on Leetcode : Yes
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        result = False
        for rows in range(len(board)):
        	for column in range(len(board[0])):
        		if self.dfs(board, word, rows, column, 0):
        			return True
        return False

    def dfs(self, board, word, rows, column, curr_len):
    	if rows < 0 or column < 0 or rows >= len(board) or column >= len(board[0]):
    		return False
    	if board[rows][column] == word[curr_len]:
    		c = board[rows][column]
    		board[rows][column] = '#'

    		if curr_len == len(word) - 1:
    			return True
    		elif (self.dfs(board, word, rows-1, column, curr_len+1) or self.dfs(board, word, rows+1, column, curr_len+1) or self.dfs(board, word, rows, column-1, curr_len+1) or self.dfs(board, word, rows, column+1, curr_len+1)):
    			return True

    		board[rows][column] = c
    	return False
        