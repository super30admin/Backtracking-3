from typing import  List
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board is None or len(board) == 0: return False
        if len(word) == 0: return True
        row = len(board)
        column = len(board[0])
        dir = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        def backtrack(rowindex: int, columnindex: int, index: int) -> bool:
            # base
            if rowindex >= row or columnindex >= column or rowindex < 0 or columnindex < 0 or board[rowindex][
                columnindex] == '#':
                return False
            if index == len(word):
                return True

            # logic
            if word[index] == board[rowindex][columnindex]:
                temp = board[rowindex][columnindex]
                board[rowindex][columnindex] = '#'
                for direction in dir:
                    r = direction[0] + rowindex
                    c = direction[1] + columnindex
                    if backtrack(rowindex=r, columnindex=c, index=index + 1): return True

                board[rowindex][columnindex] = temp
            return False

        for rowindex in range(row):
            for columnindex in range(column):
                if backtrack(rowindex=rowindex, columnindex=columnindex, index=0):
                    return True
        return False
