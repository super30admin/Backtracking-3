#Time complexity: O((m*n) * (word length))
#Space complexity: O(word length)

#Accepted on Leetcode

#Approach:
#Use recursion (with backtracking), for each square execute a dfs -> maintain a wordIndex(charIndex more appropriate name) and check all 4 directions for each square (to determine if next character found)
#If next letter found, increase word index by 1 and continue dfs -> else backtrack to previous position and continue checking 
#As soon as entire word found anywhere set a global variable to true and continue


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        n = len(board)
        m = len(board[0])
        self.dirns = [[-1,0],[1,0],[0,-1],[0,1]] # U D L R

        for i in range(n):
            for j in range(m):
                if self.recurse(board, i, j, word, 0) == True:
                    return True

        return False

    def recurse(self, board, i, j, word, wordIndex):
        #base
        if wordIndex == len(word):
            return True
        
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] == '#':
            return False

        #logic
        if board[i][j] == word[wordIndex]:
            boardVal = board[i][j]
            #action
            board[i][j] = '#'
            for dirn in self.dirns:
                nr = i + dirn[0]
                nc = j + dirn[1]
                #recurse
                if self.recurse(board, nr, nc, word, wordIndex + 1):
                    return True
            
            #backtrack
            board[i][j] = boardVal
        
        return False
        
            