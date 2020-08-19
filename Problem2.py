#Time Complexity - O(m*n * 4^L) where L is the length of the word and m*n is the board size
#Space Complexity - O(n^2), n for the recursive stack and second n for each copy of path
#Works on leetcode - yes
#Approach - We start going through the board to find first letter of the word, when we find it, we call the backtracking function. Now in the
#helper function, we check if the first letter of the word matches the cell in board,  if yes and it's the last word, we return True. Otherwise
#we mark the position as " " and check recursively if the adjacent cells have next letter of the word. Once this is done, we backtrack and set
#position to it's original value.
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not word:
            return True
        if not board:
            return False
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.help(word,board,i,j):
                    return True
        return False
    
    def help(self,word,board,i,j):
        if word[0]==board[i][j]:
            if not word[1:]:
                return True
            board[i][j]=' '
            for x,y in [(i+1,j),(i-1,j),(i,j-1),(i,j+1)]:
                if 0<=x<len(board) and 0<=y<len(board[0]):
                    if self.help(word[1:], board,x,y):
                        return True
            board[i][j]=word[0]
        return False