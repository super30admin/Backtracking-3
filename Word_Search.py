# Time Complexity :O(M*N)
# Space Complexity :O(M*N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach




# DFS
class Solution:

    def helper(self, board, word, curr, r, c):
        # base
        if(curr==len(word)-1):
            self.result=True
            return
        # logic
        if(word[curr]==board[r][c]):
            for d in self.directions:
                nr=r+d[0]
                nc=c+d[1]
                if(nr>=0 and nr<len(board) and nc>=0 and nc<len(board[0])):
                    if(word[curr+1]==board[nr][nc] and self.visited[nr][nc]==False):
                        print(word[curr+1])
                        self.visited[nr][nc]=True
                        self.helper(board, word, curr+1, nr, nc)
        self.visited[r][c]=False

    def exist(self, board: List[List[str]], word: str) -> bool:
        self.result=False
        curr=0
        self.visited=[[False for i in range(len(board[0]))] for i in range(len(board))]

        self.directions=[(-1,0),(0,-1),(1,0),(0,1)]
        for i in range(len(board)):
            for j in range(len(board[0])):
                if(word[curr]==board[i][j]):
                    self.visited[i][j]=True
                    self.helper(board, word, curr, i, j)
        return self.result