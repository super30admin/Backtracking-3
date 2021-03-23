'''
Time complexity: O(n*n)3^len(word)
Space complexity: O(n^2)
'''
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.dirs = [[1,0], [-1,0], [0,1], [0,-1]]
        if not board or len(board) == 0 or not board[0] or len(board[0]) == 0:
            return False
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if self.backtracking(board, i, j, word, 0):
                        return True
        return False
    
    def backtracking(self, board, i, j, word, index):
        if index == len(word) - 1:
            return True
        temp = board[i][j]
        
        board[i][j] = '#'
        for dir in self.dirs:
            r = i + dir[0]
            c = j + dir[1]
            
            if r >= 0 and r < len(board) and c >= 0 and c < len(board[0]) and board[r][c] == word[index + 1]:
                if self.backtracking(board, r, c, word, index + 1):
                    return True
                
        board[i][j] = temp
        return False
    