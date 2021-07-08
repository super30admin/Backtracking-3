"""
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
Given below
"""

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        """
        Idea is to run a DFS on the first matching letter from the input string,
        update the visited element by dummy char and backtrack if the path is not valid
        so that other valid path sees the char again.
        """
        def dfs(board,i,j,word,index):
            if index == len(word) - 1:
                return True
            temp = board[i][j]
            
            #mark visited
            board[i][j] = '#'
            
            directions = [(0,1),(0,-1),(1,0),(-1,0)]
            for x,y in directions:
                valx = x + i
                valy = y + j
                if valx >=0 and valx < len(board) and valy >=0 and valy < len(board[0]) and index + 1 < len(word) and word[index + 1] == board[valx][valy]:
                    board[i][j] = '#'
                    if dfs(board,valx,valy,word,index+1):
                        return True
            
            #reseting the visiting
            board[i][j] = temp
            return False
        
        if not board or not board[0]:
            return False
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if dfs(board,i,j,word,0):
                        return True
                
        return False