#Time Complexity : O(mn * 4^n)
#Space Complexity : O(mn)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        def explore(i, j, index):
            if index == len(word):
                return True    
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j]!= word[index]:
                return False 
            board[i][j] = "#"
            if explore(i+1, j, index+1):
                return True 
            if explore(i-1, j, index+1):
                return True
            if explore(i, j+1, index+1):
                return True
            if explore(i, j-1, index+1):
                return True
            board[i][j] = word[index]
            return False
            
        for i in range(len(board)):
            for j in range(len(board[0])):
                if explore(i, j, 0):
                    return True
        return False