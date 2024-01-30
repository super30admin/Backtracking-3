'''

Time Complexity : O(m * n * 4^L)
Space Complexity : O(L)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach
In n^2 time we first find the element which matches the first letter of the word and then we check the neighboring elements recursively
to check for the element


'''

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        word = list(word)
        m = len(board)
        n = len(board[0])
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]

        def helper(board,word,i,j,ind):
            if ind + 1 == len(word):
                return True

            for k in dirs:
                nr = i + k[0]
                nc = j + k[1]

                if 0 <= nr < m and 0 <= nc < n:

                    if board[nr][nc] == word[ind+1] and board[nr][nc] != '#':

                        board[nr][nc] = '#'
                        x = helper(board,word,nr,nc,ind+1)
                        board[nr][nc] = word[ind+1]

                        if x:
                            return True

            return False


        for i in range(m):
            for j in range(n):

                if board[i][j] == word[0]:
                    board[i][j] = '#'
                    if helper(board,word,i,j,0):
                        return True
                    board[i][j] = word[0]


        return False