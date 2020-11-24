class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        def helper(i, j, index):
            if index == len(word):
                return True
            else:
                if 0<=i<len(board) and 0<=j<len(board[0]) and board[i][j] == word[index]:
                    temp = board[i][j]
                    board[i][j] = "*"
                    for row, col in [[i+1, j],[i,j+1], [i-1,j], [i,j-1]]:
                        if helper(row, col, index+1):
                            return True
                    board[i][j] = temp
                return False

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if helper(i,j, 0):
                        return True
        return False
    

    Time: N*3^L
    Space: L  