'''
TC: O(m*n*3^L)
SC: O(L)
'''
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        rlen = len(board)
        if not rlen:
            return False
        clen = len(board[0])
        
        def issafe(a, b):
            if a >= 0 and b >= 0 and a < rlen and b < clen:
                return True
            return False
        
        def dfs(board, visited, indexa, indexb, word, targetindex):
            if board[indexa][indexb] != word[targetindex]:
                return False
            if targetindex + 1 == len(word):
                return True
            visited[indexa][indexb] = True
            xrange = [1, -1, 0, 0]
            yrange = [0, 0, 1, -1]
            
            for i in range(4):
                newx = indexa + xrange[i]
                newy = indexb + yrange[i]
                if issafe(newx, newy) and visited[newx][newy] != True:
                    if dfs(board, visited, newx, newy, word, targetindex + 1):
                        return True
            visited[indexa][indexb] = False
            return False
        
        visited = [[False for i in range(clen)] for j in range(rlen)]
        
        for i in range(rlen):
            for j in range(clen):
                if dfs(board, visited, i, j, word, 0):
                    return True
        
        return False