## Problem2
# Word Search(https://leetcode.com/problems/word-search/)

# Method-1: Using void based recursion
# M -- No. of Rows
# N -- No. of Cols
# L -- Length of the word
# Time Complexity : O((M*N) * (3 ^ (L)))
# TC: 3 ^ (L) --- for one DFS and we can have total M*N DFS

# Space Complexity : O(L) = O(L) -- recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach in three sentences only
# Wherever we match the first letter of the word to be searched in the grid, we start a fresh DFS. We have to keep track of our current path
# that is visited cells as reusing a used cell is not allowed. So when the recursion returns we need to backtrack the action of making the 
# cell visited, so that we can explore other paths from there. As other path could give us the word we are searching. For visited we are 
# temporarily changing the state of the matrix to #. At each node we have 3 options to explore as we go deep into the tree. Max depth
# of this tree would be the length of the word we are seaching. Here the input matrix remains preserved

class Solution(object):
    def __init__(self):
        self.isWordFound = False
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if(len(word) > (len(board) * len(board[0]))):
            # word length > matrix length
            return False
        
        def helper(board, word, strIdx, row, col, dirs):
            # base
            # first check if word has been found. this condition should come first
            if(strIdx == len(word)):
                # word found
                self.isWordFound = True
                return
                            
            # bounds and visited check
            if((row < 0) or (row >= len(board)) or (col < 0) or (col >= len(board[row])) or (board[row][col] == "#")):
                return

            if(self.isWordFound):
                # word already found
                return

            if(board[row][col] == word[strIdx]):
                # then only proceed further
                # action
                board[row][col] = "#"
                # till now word is matching, lets recurse further
                for k in range(len(dirs)):
                    nr = row + dirs[k][0]
                    nc = col + dirs[k][1]
                    # recurse
                    helper(board, word, strIdx + 1, nr, nc, dirs)
                    # if(self.isWordFound):
                    #     # word already found
                    #     return
                
                # backtrack
                board[row][col] = word[strIdx]

        m = len(board)
        n = len(board[0])
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        self.isWordFound = False
        for i in range(m):
            for j in range(n):
                if(board[i][j] == word[0]):
                    # start a fresh DFS
                    
                    helper(board, word, 0, i, j, dirs)
                    if(self.isWordFound):
                        # word already found
                        return True
        

        return False
    
sol = Solution()
print("Method-1: Using void based recursion")
print(sol.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"))
print(sol.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "SEE"))
print(sol.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCB"))
print(sol.exist([["A","E","E","D"],["S","F","C","S"],["A","D","E","E"]], "SFCEESDEE"))

# Method-2: Using boolean based recursion
# M -- No. of Rows
# N -- No. of Cols
# L -- Length of the word
# Time Complexity : O((M*N) * (3 ^ (L)))
# TC: 3 ^ (L) --- for one DFS and we can have total M*N DFS

# Space Complexity : O(L) = O(L) -- recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach in three sentences only
# The logic is exactly same. Just here we are using boolean based recursion. Here the input matrix changes as all the actions might not get 
# backtracked

class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if(len(word) > (len(board) * len(board[0]))):
            # word length > matrix length
            return False
        
        def helper(board, word, strIdx, row, col, dirs):
            # base
            # first check if word has been found. this condition should come first
            if(strIdx == len(word)):
                # word found
                return True
                            
            # bounds and visited check
            if((row < 0) or (row >= len(board)) or (col < 0) or (col >= len(board[row])) or (board[row][col] == "#")):
                return False

            if(board[row][col] == word[strIdx]):
                # then only proceed further
                # action
                board[row][col] = "#"
                # till now word is matching, lets recurse further
                for k in range(len(dirs)):
                    nr = row + dirs[k][0]
                    nc = col + dirs[k][1]
                    # recurse
                    if(helper(board, word, strIdx + 1, nr, nc, dirs)):
                        return True
                
                # backtrack
                board[row][col] = word[strIdx]

            return False

        m = len(board)
        n = len(board[0])
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        for i in range(m):
            for j in range(n):
                if(board[i][j] == word[0]):
                    # start a fresh DFS
                    
                    if(helper(board, word, 0, i, j, dirs)):
                        return True
                    
        return False
    
sol = Solution()
print("Method-2: Using boolean based recursion")
print(sol.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"))
print(sol.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "SEE"))
print(sol.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCB"))
print(sol.exist([["A","E","E","D"],["S","F","C","S"],["A","D","E","E"]], "SFCEESDEE"))


