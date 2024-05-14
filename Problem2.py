## Problem2
# Word Search(https://leetcode.com/problems/word-search/)


# Approach
# Recursively call the helper function and pass the board, i, j. word and index of word all set to 0 at first. 
# In helper function, if word[idx] == board[i][j], mark it as visited and check all 4 directions. If they are within bounds, call helper function again with next index
# If idx == len(word), it means you reached the end of the word and found all chars, set flag = True and return flag

# Time Complexity: O((m*n)(3**k))
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def helper(self,board, i, j, word, idx):
        # base
        if idx == len(word):

            self.flag = True
            return
        
        if (i<0 or j<0 or i == self.m or j == self.n or board[i][j] == '#'):
            return

        # logic

        if word[idx] == board[i][j]:
            board[i][j] = '#'
            for d in self.dirs:
                r = i + d[0]
                c = j + d[1]
                self.helper(board, r, c, word, idx+1)
            board[i][j] = word[idx]

    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        self.dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        self.flag = False

        for i in range(self.m):
            for j in range(self.n):
                if not self.flag:
                    self.helper(board, i, j , word, 0)
                else:
                    break
        return self.flag