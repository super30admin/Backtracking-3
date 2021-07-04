'''
https://leetcode.com/problems/word-search/

Did it run on Leetcode: Yes
Did you face any problem: No

Time complexity: Exponential

Algorithm:
- DFS search at every index
- if a match found, then returning True to avoid further matching
'''

class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        
        if not board or not board[0] or not word:
            return False
        
        self.R,self.C= len(board),len(board[0])
        visited = [ [False for _ in range(self.C)] for _ in range(self.R) ]
        
        for i in range(self.R):
            for j in range(self.C):
                if self.search(i,j,0,word,board,visited):
                    return True
        
        return False
        
    def search(self,x,y,index,word,board,visited):
        
        # base case
        if index==len(word):
            return True
        
        if x<0 or x>=self.R or y<0 or y>=self.C:
            return False
        
        if word[index]!=board[x][y] or visited[x][y]:
            return False
        
        # backtrack logic
        visited[x][y] = True
        for pos in self.nextCordinates(x,y):
            if self.search(pos[0],pos[1],index+1,word,board,visited):
                return True
        # untrack visited
        visited[x][y]=False
        return False
    
    def nextCordinates(self,x,y):
        dirs = [(-1,0),(0,-1),(1,0),(0,1)]
        nextPos = []
        for dir in dirs:
            dx,dy = x+dir[0],y+dir[1]
            nextPos.append((dx,dy))
        return nextPos
        