#Time Complexity = O(n)
#Space Complexity = O(n)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        ROWS,COLS = len(board), len(board[0])
        visited = set()
        def backtrack(r,c,i):
            if i == len(word):
                return True
            if(min(r,c) < 0 or r>= ROWS or c >= COLS or word[i] != board[r][c] or (r,c) in visited):
                return False

            visited.add((r,c)) # Action 

            res = (backtrack(r+1,c,i+1) or # Backtrack
                backtrack(r-1,c,i+1) or
                backtrack(r,c+1,i+1) or
                backtrack(r,c-1,i+1)) 

            visited.remove((r,c)) #Undo Action
            
            return res

        for r in range(ROWS):
            for c in range(COLS):
                if backtrack(r,c,0):
                    return True
        return False