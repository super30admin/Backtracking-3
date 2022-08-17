"""
Runtime Complexity:
exponential. O(3^L * (m*n)) - where L is the length of the word. 3 is the number of directions we would look and m,n are rows and columns respectively.
Space Complexity:
O(L) - recursive stack which is dominated by the length of the word.
Yes, the code worked on leetcode.
Issues while coding- NO
"""

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board:
            return False
        m = len(board)
        n = len(board[0])
        dirs = [[-1,0],[1,0],[0,-1],[0,1]] #up, down, left, right
        
        def backtrack(board,word,r,c,index):
            if index == len(word):  
                return True
            if r<0 or c<0 or r>=m or c>=n or board[r][c]=='#':
                return False

            if word[index] == board[r][c]:  #means the character in the word is present in the board. Check for directions and traverse to find the existence of word.
                temp = board[r][c]
                board[r][c]= '#'    #marking a symbol on visited letters.

            #check for directions
                for d in dirs:
                    nr = r + d[0]
                    nc = c + d[1]

                    if backtrack(board,word,nr,nc,index+1):
                        return True
                board[r][c] = temp

            return False

        for i in range(m):
            for j in range(n):
                if backtrack(board,word,i,j,0):
                    return True
        return False


