# Time Complexity: O(3^L), L = Length of String
# Space Complexity: O(L)
# Did this run successfully on Leetcode: Yes
# Any issues faced while coding: Took a few tries to get the code correct
# Explain your approach: Use backtracking and check in atleast 3 directions (4 directions for starting character),
# and try to find the word, backtrack if wrong path, and use a visited array to keep track of visited chars


class Solution:

    def exist(board, word):

        m, n = len(board), len(board[0])
        if m == 0 or n == 0 or board is None or board[0] is None:
            return False 

        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        def backtrack(board, word, i, j , index):

            # base 
            if i < 0 or i == m or j < 0 or j == n or board[i][j] == "#":
                return False
            
            if index == len(word):
                return True

            # logic
            if word[index] == board[i][j]:

                # for a single character word and single element 2d array
                if index == len(word) - 1:
                    return True

                

                # action
                ch = board[i][j]
                board[i][j] = "#"

                # recurse
                for d in dirs:
                    r = i + d[0]
                    c = j + d[1]
                    if backtrack(board, word, r, c, index+1):
                        return True
                    
                # backtrack
                board[i][j] = ch
                
            return False 
        
        for i in range(m):
            for j in range(n):
                if backtrack(board, word, i, j, 0):
                    return True 
        
        return False
            