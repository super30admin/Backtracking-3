# Time: O(m*n*3^L) where L is the lenght of the word and we have 3 options to move in each step as we mark visited.
# Space: O(L) - for the recursion stack and the path taken.

# Question: Given an m x n grid of characters board and a string word, return true if word exists in the grid.

# We loop on the given matrix and for each character in the cell we call the isWord function.
# The isWord function checks if the word exists starting from the current position. If not we return False
# And if the current character matches the word's current index, we mark it as visited and call the isWord function for all 4 directions and incrementing the idx. 
# We go till the end and if idx == len(word) we return True and if it goes out of bounds we return False and even if any of the calls return False by not matching with the character the if True condition doesn't pass and we keep on returning False.
# i.e If any of the calls return True, we return True. If not we backtrack and mark the cell as unvisited and return False.

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        direc = [[1,0],[0,1],[-1,0],[0,-1]]

        for i in range(m):
            for j in range(n):
                found = self.isWord(board,word,0,i,j,m,n,direc)
                if found: return found
        return False
    
    def isWord(self,board,word,idx,row,col,m,n,direc):
        if idx == len(word): return True
        if not (0 <= row < m and 0 <= col < n): return False

        if board[row][col] == word[idx]:
            board[row][col] = '#'
            for r,c in direc:
                nr = r + row
                nc = c + col    
                if self.isWord(board,word,idx+1,nr,nc,m,n,direc): return True
            board[row][col] = word[idx]
        return False
