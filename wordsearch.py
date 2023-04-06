#logic-loop through all elements,and do dfs,if char is equal to char at curr index of string,
#recurse again,if we reach end of str,return true
#TC-O(mn3**l)
#SC-O(l)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows=len(board)
        columns=len(board[0])
        path = set()

        def dfs(r,c,i):
            if i==len(word):
                return True
            if (r<0 or c<0 or r>=rows or c>=columns or (r,c) in path or board[r][c]!=word[i]):
                return False
            path.add((r,c))
            result = (dfs(r+1,c,i+1) or dfs(r-1,c,i+1) or dfs(r,c-1,i+1) or dfs(r,c+1,i+1) )
            path.remove((r,c))
            return result
            
        for i in range(rows):
            for j in range(columns):
                if dfs(i,j,0):
                    return True
        return False
        
        