#TIme COmplexity:exponential
#Space COmplexity:O(1)
#Leetcode submission: wrong answer......cannot get where is it going wrong
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        m=len(board)
        n=len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j]==word[0]:
                    self.helper(board,word,i,j,0)
                    return True
        return False
    def helper(self,board,word,row ,column,count):
        if count==len(word):
            return True
        if (row<0 and row>=len(board) and column<0 and column>=len(board[0]) and  board[row][column] !=word[count]):
            return False
        return  self.helper(board,word,row+1,column,count+1) or self.helper(board,word,row-1,column,count+1) or self.helper(board,word,row,column+1,count+1) or self.helper(board,word,row,column-1,count+1)
        board[row][column]=temp
        