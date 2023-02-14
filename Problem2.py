#Time Complexity :- O(exponential) which is m*n*3^l where l is length of string 
# Space Complexity :- O(l) which is recursive stack space  which is the length of the word that we are looking for

class Solution:
    dirs =[]
    m,n = 0, 0
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board is None or len(board) == 0:
            return False
        self.m = len(board)
        self.n = len(board[0])
        self.dirs = [[-1,0], [0,-1], [1,0],[0,1]]
        for i in range(self.m):
            for j in range(self.n):
                if self.backTrack(board, i, j, word, 0 ):
                    return True
        return False


    def backTrack(self, board, r, c, word, index):
        if index == len(word):
            return True
        if r<0 or c<0 or r==self.m or c ==self.n or board[r][c]=='#':
            return False

        if board[r][c] == word[index]:
            ch = board[r][c]
            board[r][c] = '#'
            for dir in self.dirs:
                nr = r + dir[0]
                nc = c + dir[1]
                if self.backTrack(board, nr,nc, word, index+1):
                    return True
            board[r][c] = ch
        return False




        