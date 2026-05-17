
# time: O(n*n!)
# space: O(n^2) + O(n)

from typing import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        # This initializes the grid of False values
        board = [[False]*n for _ in range(n)]
        
        print(f"=== Initializing empty board (All False) ===")
        self.print_board(board, n, indent="")
        print(f"============================================\n")
        
        self.helper(board, 0, n)
        return self.result 
    
    def print_board(self, board, n, indent=""):
        """Prints both the raw boolean array state and a visual grid side-by-side."""
        print(f"{indent}  [ Raw Memory State ]                   [ Visual Board ]")
        for r in range(n):
            # Format the raw boolean row string
            bool_row = "[" + ", ".join(f"True " if val else "False" for val in board[r]) + "]"
            # Format the visual row string
            visual_row = " ".join("Q" if board[r][c] else "." for c in range(n))
            print(f"{indent}  {bool_row}       -->       {visual_row}")

    def helper(self, board, row, n):
        indent = "  " * row
        
        if row == n:
            print(f"\n{indent}🎉 SUCCESS: Found a valid configuration!")
            self.print_board(board, n, indent)
            print()
            
            list_ = []
            for i in range(n):
                sb = []
                for j in range(n):
                    if board[i][j]:
                        sb.append("Q")
                    else:
                        sb.append(".")
                list_.append("".join(sb))
            self.result.append(list_)
            return
        
        print(f"{indent}--> Moving into Row {row}...")
        
        for j in range(n):
            if self.isValid(board, row, j, n):
                # Action: Flipping False to True
                print(f"\n{indent}  👑 CHOOSE: Changing board[{row}][{j}] from False to True:")
                board[row][j] = True
                self.print_board(board, n, indent)
                print()
                
                # Recurse
                self.helper(board, row + 1, n)
                
                # Backtrack: Flipping True back to False
                print(f"\n{indent}  ⏪ BACKTRACK: Resetting board[{row}][{j}] from True back to False:")
                board[row][j] = False
                self.print_board(board, n, indent)
                print()
            else:
                print(f"{indent}  ❌ SKIP: Row {row}, Col {j} is unsafe.")
                
        print(f"{indent}<-- Finished Row {row}. Popping back up.")

    def isValid(self, board, i, j, n):
        r, c = i, j
        while r >= 0:
            if board[r][c]: return False
            r -= 1
        
        r, c = i, j
        while r >= 0 and c >= 0:
            if board[r][c]: return False
            r -= 1
            c -= 1
        
        r, c = i, j
        while r >= 0 and c < n:
            if board[r][c]: return False
            r -= 1
            c += 1
        
        return True