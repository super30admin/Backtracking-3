# Time Complexity : O(m * n * 3^l)[m = num of rows, n = num of cols, l = length of word]
# Space Complexity : O(m * n)[m = num of rows, n = num of cols]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach(DFS + backgracking)
# 1. Traverse over the board in DFS manner and compare the char in word at each step
# 2. If the current char from board matches the char in word, proceed to the next char
# 3. If the current char from board does not match, backtrack and explore other directions 
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board:return False
        def backtrack(board, word, i, j, index):
            ## base
            if index == len(word):
                return True
            if i < 0 or i >= m or j < 0 or j >=n: # No need to add board[i][j] == '#' since it is already taken care on line 22 
                return False
            
            ## body
            
            if word[index] == board[i][j]:
                
                # action
                temp = board[i][j]
                board[i][j] = '#'
                
                # recurse
                for direction in directions:
                    x = i + direction[0]
                    y = j + direction[1]
                    
                    if backtrack(board, word, x, y, index+1):
                        return True
                
                # backtrack
                board[i][j] = temp
            return False
        
        m = len(board)
        n = len(board[0])
        directions = [[-1,0],[1,0],[0,1],[0,-1]]
        for i, row in enumerate(board):
            for j, col in enumerate(row):
                if backtrack(board, word, i, j, 0):
                    return True
        return False



"""
Testcase where DFS will not work

board:
A B R O
S F C L
L D R O

word:
SFCROLORB

Testcase to understand complexity

board:
A A A A A A
A A L A A A
A A A A A A


word:
AAAAAAAAAAAAAAAAAL

"""