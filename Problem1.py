"""
time - exponential
space - o(m*n)
"""

class Solution:
    def backtrack(self,w,b, i, j, idx ):
        #base
        if (idx == len(w)):
            return True
        
        if (i < 0 or i >= len(b) or j < 0 or j >= len(b[0]) or b[i][j] == '#'):
            return False
        #logic
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        
        if b[i][j] == w[idx]:
            
            tmp = b[i][j] 
            b[i][j] = '#'
            #recurse
            for d in dirs:
                r = i + d[0]
                c = j + d[1]
                # print("rc",r,c)
                if self.backtrack(w, b,r, c, idx+1 ):
                    return True
            #backtrack  
            b[i][j] = tmp
            
        return False
    
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(self.b)):
            for j in range(len(self.b[0])):
                if self.backtrack(word,board,i,j,0):
                    return True
        return False