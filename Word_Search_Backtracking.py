# Created by Aashish Adhikari at 2:22 PM 2/2/2021

'''
Time Complexity:
O(k . 3 ^L)

Space Complexity:
O(L) where L is the length of the word. This is the size required to maintain the recursive stack under the hood.
The temp variable that is created at each node is also maintained in the recursive stack and doesnt have to be handled separately.
'''


class Solution(object):


    def backtrack(self, board, word, index, r, c):

        # base case
        if index == len(word):
            return True

        if r < 0 or c < 0 or r == len(board) or c == len(board[0]) or board[r][c] == "#":
            return False


        # logic
        if word[index] == board[r][c]:

            # ACTION
            mark_parent = board[r][c]
            board[r][c] = "#"           # this makes sure all the letters that have been encountered till now in the current solution equal #

            # RECURSE
            for dir in self.dirs:

                row = dir[0] + r
                col = dir[1] + c


                if self.backtrack(board, word, index+1, row, col):
                    return True


            # BACKTRACK
            board[r][c] = mark_parent
        return False




    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """

        if len(word) == 0:
            return True

        self.dirs = [[-1,0], [1,0], [0,-1], [0,1]]



        for i in range(len(board)):
            for j in range(len(board[0])):


                if self.backtrack(board, word, 0, i, j):
                    return True

        return False



