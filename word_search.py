# SC: O(MN)
# TC : O(MN)
class Solution:
    res = False
    def exist(self, board: List[List[str]], word: str) -> bool:
        dirs = [[0,1], [1,0], [-1,0], [0,-1]]
        
        def func(board, i, j, path , visited ):
            if "".join(path) == word:
                self.res = True
                return  

            for d in dirs:
                new_i = i + d[0]
                new_j = j + d[1]
                if new_i < len(board) and new_i >= 0  and new_j >= 0 and new_j < len(board[0]) and board[new_i][new_j]==word[len(path)] and (not visited[new_i][new_j]):
                    # action
                    path.append(board[new_i][new_j])
                    visited[new_i][new_j] = True
                    # recurse
                    func(board, new_i, new_j, path, visited)
                    # retreat 
                    _ = path.pop(-1)
                    visited[new_i][new_j] = False

        visited = []    
        for i in range(len(board)):
            temp = []
            for j in range(len(board[0])):
                temp.append(False)
            visited.append(temp)    
                
        for i in range(len(board)):
            for j in range(len(board[0])):
                if word[0] == board[i][j]:
                    visited[i][j] = True
                    func(board, i, j, [word[0]], visited)
                    visited[i][j] = False
                    if self.res: return self.res
        return self.res
                        
