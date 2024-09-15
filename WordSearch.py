#TC:O(mn(3^L))
#SC:O(L)
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        
        if board==None or len(board)==0:
            return False
        m=len(board)
        n=len(board[0])
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        def backtrack(board,i,j,word,index):
            #base
            if index==len(word):return True
            if i<0 or j<0 or i==m or j==n or board[i][j]=='#': return False
            #logic
            if word[index]==board[i][j]:
                #action
                board[i][j]='#'
                for k in range(len(dirs)):
                    r=i+dirs[k][0]
                    c=j+dirs[k][1]
                    
                    #recurse
                    if(backtrack(board,r,c,word,index+1)): return True
                #backtrack
                board[i][j]=word[index]
                
        
        
        for i in range(m):
            for j in range(n):
                if word[0]==board[i][j]:
                    if(backtrack(board,i,j,word,0)): return True
        return False

#code by harsh
'''
def exist2(self, board, word):
    # idea is to make all the dfs aware if the board was found earlier, so they can quit looking.
    # we can achieve this by either keep it a global variable or send as reference.
    found = [False]
    m, n = len(board), len(board[0])
    dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    # search for all word[0] to do dfs on
    for i in range(m):
        for j in range(n):
            if found[0] == False and board[i][j] == word[0]:
                # since we already matched first char of word, mark it as visited and call dfs from second char in
                # word.
                # sending fresh copy of visited for every DFS.
                visited = [[False] * n for i in range(m)]
                visited[i][j] = True
                self.dfs2(board, i, j, word, 1, m, n, found, dirs, visited)

    return found[0]

def dfs2(self, board, r, c, word, index, m, n, found, dirs, visited):
    # base
    if index == len(word):
        found[0] = True
        return
    if found[0]:
        return
    # logic
    for dir in dirs:
        nr = r + dir[0]
        nc = c + dir[1]
        if 0 <= nr < m and 0 <= nc < n and board[nr][nc] == word[index] and visited[nr][nc] is False:
            temp = [visited[i][:] for i in range(m)]
            temp[nr][nc] = True
            self.dfs2(board, nr, nc, word, index + 1, m, n, found, dirs, temp)
'''