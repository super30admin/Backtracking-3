#Time Complexity : O((mn)*3^l) where m is number of rows, n is number of cols and l is length of the word to be found
#Space Complexity : O(l) where l is the length of the word to be found
#Did this code successfully run on Leetcode : Yes

class Solution:
    def helper(self, board, r, c, ind, word):
        #check if we've reached the end of the word, if we have that means we've found the word and can return True
        if len(word) == ind:
            return True
        #if we go out of bounds or the letter in the curr index of the word doesn't match the letter in the index of the board or we've already visited the curr index on the board return False
        if r < 0 or r >= len(board) or c < 0 or c >= len(board[0]) or word[ind] != board[r][c] or board[r][c] == "*":
            return False
        #keep current value of board stored
        curr = board[r][c]
        #mark current index as visited
        board[r][c] = '*'
        dirs = [[0,1], [1,0], [0,-1], [-1,0]]
        #dfs in all four directions to find the word
        for x, y in dirs:
            #if from any direction we find the word, return True
            if self.helper(board, x+r, y+c, ind+1, word):
                return True
        #backtrack and change the value on the board to the original value
        board[r][c] = curr
        #if we haven't found the word in any direction return False
        return False


    def exist(self, board: List[List[str]], word: str) -> bool:
        if (not board or len(board) == 0) and word:
            return False

        #iterate through the board
        for r in range(len(board)):
            for c in range(len(board[0])):
                #if first letter of word matches current board value perform dfs from that location
                if word[0] == board[r][c]:
                    #if word is found on the board return True
                    if self.helper(board, r, c, 0, word):
                        return True
        return False
