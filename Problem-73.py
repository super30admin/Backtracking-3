# leet code - 79 - Word Search - https://leetcode.com/problems/word-search/
# Time compleixty - O(M*N)3^N (since for every element we have 3 options to consider ). We are not considering the fourth direction because it is already visited
# Space Complexity - O(M*N)
# Backtracking approach -  Backtracking happens at two points - while going from one index to another index and if have two paths if first path doesn't satisfy then we backtrack and make that index unvisted. 


class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        m=len(board)
        n=len(board[0])
        idx=0
        visited=[[False for _ in range(n)] for _ in range(m)]
        
        for i in range(m):
            for j in range(n):
                if self.dfs(board,i,j,word,visited,idx):
                    return True
        return False
    
    def dfs(self,board,i,j,word,visited,idx):
        dir =[(1,0),(0,1),(-1,0),(0,-1)]
        #edge case
        if idx==len(word):
            return True
        if  i<0 or i>=len(board) or j<0  or j >=len(board[0]) or  visited[i][j] or board[i][j]!=word[idx]:
            return False
        visited[i][j]=True
        
        # backtrack logic
        for (r,c) in dir:
            new_r=i+r
            new_c = j+c
            if self.dfs(board,new_r,new_c,word,visited,idx+1):
                return True
        
        visited[i][j]=False
        return False
                