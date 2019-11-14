#Accepted on Leetcode
# Time complexity - O(M*N)
# Space complexity - O(M*N)


class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0] and self.dfs(board, 0, i, j, word):
                    return True
        return False
    
    def dfs(self, board, count, i, j, word):
        if count == len(word):
            return True
        if i<0 or i >= len(board) or j<0 or j >= len(board[0]) or board[i][j]!=word[count]:
            return False
        temp = board[i][j]
        board[i][j] = ''
        found = self.dfs(board, count+1, i+1,j,word) or self.dfs(board, count+1, i-1,j,word) or self.dfs(board, count+1, i,j+1,word) or self.dfs(board, count+1, i,j-1,word)
        board[i][j] = temp
        return found