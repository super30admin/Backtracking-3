# Time Complexity: O(mn*3^l) where m and n are the dimensions of the array and l is the length of the word.
# Space Complexity:  O(l).
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    dirs = [[0,-1], [0,1], [1,0], [-1,0]]
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if self.helper(board, i, j, 0, word):
                        return True
        return False

    def helper(self, board, i, j, index, word):
        if index == len(word):
            return True
        if  i  < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] == "." or board[i][j] != word[index]:
            return False
        temp = board[i][j]
        board[i][j] = "."
        for x,y in Solution.dirs:
            r = i + x
            c = j + y
            if(self.helper(board, r,c,index+1, word)):
                board[i][j] = temp
                return True
        board[i][j] = temp
        return False
