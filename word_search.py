#TC==> O(n*m*3^L)
#SC==> O(n)
import itertools
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def backtrack(row, col, marked=set(), path=0):
            if row<0 or col<0 or row>=len(board) or col>=len(board[0]):
                return False
            if (row,col) in marked:
                return False
            if board[row][col] == word[path]:
                if path == len(word)-1:
                    return True
                marked.add((row,col))
                res = backtrack(row,col+1,marked,path+1) or backtrack(row,col-1,marked,path+1) or backtrack(row+1,col,marked,path+1) or backtrack(row-1,col,marked,path+1)
                marked.remove((row,col))
                return res
            return False
        return any(map(lambda x: backtrack(x[0], x[1]), itertools.product(range(len(board)), range(len(board[0])))))