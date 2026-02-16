# // Time Complexity : O(2^n)
# // Space Complexity : O(n)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        n = len(board)
        m = len(board[0])

        def recur(i, j, wrd_idx):            
            if wrd_idx == len(word):
                return True
                
            if i < 0 or i >= n or j < 0 or j >= m or board[i][j] != word[wrd_idx]:
                return False
            
            temp = board[i][j]
            board[i][j] = '#'  

            found = (recur(i-1, j, wrd_idx+1) or 
                    recur(i+1, j, wrd_idx+1) or 
                    recur(i, j-1, wrd_idx+1) or 
                    recur(i, j+1, wrd_idx+1))
            
            board[i][j] = temp
            return found

        for i in range(n):
            for j in range(m):
                if recur(i, j, 0):
                    return True

        return False