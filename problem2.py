class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(i,j,word):
            if i<0 or j<0 or j>=len(board[0]) or i>=len(board):
                return False
            if len(word)==0:
                return True
            if board[i][j]==word[0] and (i,j) not in visit:
                visit.add((i,j))
                if dfs(i-1,j,word[1:]): return True
                if dfs(i,j-1,word[1:]) : return True
                if dfs(i+1,j,word[1:]) : return True
                if dfs(i,j+1,word[1:]): return True
                visit.remove((i,j))

        if board[0][0]==word:
            return True 
        for i in range(len(board)):
            for j in range(len(board[0])):
                visit=set()
                if dfs(i,j,word):
                    return True
        return False
        