#Time Complexity : O(n*4^L) WHERE l IS LENGTH OF STRING and N is number of elemnts in matrix
# Space Complexity : O(L) where l length of string be stored in stack and m*n for visited array
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        
        visited = [[0 for j in range(len(board[0]))]for i in range(len(board))]
        
        if len(board) == 0:
            return False
        
        
        def backtrack(board,word,i,j):
          
            if i < 0 or j< 0 or i >= len(board) or j >= len(board[0]) or visited[i][j]:
                return False
            dirs = [(0,1),(1,0),(-1,0),(0,-1)]
            if board[i][j] == word[0]:
                if(len(word) == 1):
                    return True
                visited[i][j] = True
                for d in dirs:
                    r = i +d[0]
                    c = j +d[1]
                    if (backtrack(board,word[1:],r,c)):
                        return True
                visited[i][j] = False
            return False
        for i in range(len(board)):
            for j in range(len(board[0])):
                if backtrack(board,word,i,j):
                    return True
        return False
===================================================================================================
#Time Complexity : O(n*4^L) WHERE l IS LENGTH OF STRING and N is number of elemnts in matrix
# Space Complexity : O(L) where l length of string be stored in stack
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        
        if len(board) == 0:
            return False
        
        
        def backtrack(board,word,i,j):
            if i < 0 or j< 0 or i >= len(board) or j >= len(board[0]) or board[i][j] == '#':
                return False
            if board[i][j] == word[0]:
                if len(word)==1:
                    return True
                prev = board[i][j]
                board[i][j]= "#"
                for d in dirs:
                    r = i +d[0]
                    c = j +d[1]
                    if backtrack(board,word[1:],r,c):
                        return True
                board[i][j] = prev
            return False
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if backtrack(board,word,i,j):
                    return True
        return False  