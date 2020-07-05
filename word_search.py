class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        index = 0
        for i in range(m):
            for j in range(n):
                if self.backtrack(board, word, m, n, i, j, index):
                    return True
        return False
        
    def backtrack(self, board, word, m, n, i, j, index):
        #base
        if index == len(word):
            return True
        if (i<0 or j<0 or i == m or j == n):
            return False
        #logic
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        if word[index] == board[i][j]:
            #action
            temp = board[i][j]
            board[i][j] = '#'
            #recurse
            for dir_ in dirs:
                r = i + dir_[0]
                c = j + dir_[1]
                if self.backtrack(board, word, m, n, r, c, index+1):
                    return True
            #backtrack
            board[i][j] = temp
        return False

#time complexity - O(m*n*3^L), where m,n are dimensions of the board given and L is the length of the word

#space complexity - O(n)

#all test cases passed 