# Time Complexity O(MxNx3^L)..L being length of word
# Space Complexity: O(L)..Recursion Stack
# Approach:
# First find starting pos of word on board.if found make it visted .then do DFS in all 3 directions , we return true if length of word is same as indx that we are trying  to search
# edge caes single letter or 
#  A A A A A 
#  A A A A A
#  A A A A B with AB


# bfs VS dfs VS backtracking
# DFS -> use when we dont need visted ..like we need to comback
# BFS with back tracking is not preferred we dont know which one needs to be makred



class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m,n=len(board),len(board[0]) #[m][n]
        word_len=len(word)
        dir=[[0,1],[0,-1],[1,0],[-1,0]]
        def helper(board,ridx,cidx,widx):
            #base
            if widx==word_len:return True
           
            #logic
            if -1<ridx<m and -1<cidx<n and board[ridx][cidx]==word[widx]:
                temp=board[ridx][cidx]
                board[ridx][cidx]="_"
                for d in dir:
                    
                    
                    if helper(board,ridx+d[0],cidx+d[1],widx+1):return True
                board[ridx][cidx]=temp
                return False

        for r in range(m):
            for c in range(n):
                if helper(board,r,c,0):
                    return True
        return False
