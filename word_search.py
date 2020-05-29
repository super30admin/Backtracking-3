#Problem: Word Search
#Time Complexity O(n*4^l),n number of elements in board, l number of letters in word
#Space complexity: O(l) for recursive stack
'''
We iterate through the board to find the first letter, then dfs from there and just going to valid letter one
by one until either we can't go further, or we formed the word. We backtrack and unsee them for every path attempt.
'''

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board:
            return False
        n=len(board)
        m=len(board[0])
        

        def helper(index,i,j):
            nonlocal n,m
            #base case:
            if not (0<=i<n and 0<=j<m) or board[i][j]=='#' :
                return
            #logic
            if word[index]!=board[i][j]:
                return
            if index==len(word)-1:
                return True
            #action
            prev=board[i][j]
            board[i][j]="#"
            #recurse
            dirs=[[0,1],[1,0],[-1,0],[0,-1]]
            for d in dirs:
                r,c=i+d[0], j+d[1]
                if helper(index+1,r,c):
                    return True
                
            #backtrack
            board[i][j]=prev
                
        for i in range(n):
            for j in range(m):
                if board[i][j]==word[0]:
                    if(helper(0,i,j)):
                        return True
        return False
