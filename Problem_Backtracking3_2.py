class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        status = [False]
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                self.search(board, i, j, list(reversed(word)), status, set())
        return status[0]
    
    def search(self, board, i, j, stack, status, visited):
        if status[0]:
            return
        if not stack:
            status[0] = True
            return
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
            return
        if board[i][j] != stack[-1]:
            return 
        visited.add((i, j))
        s = stack.pop()
        for (ii, jj) in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
            if (ii, jj) in visited:
                continue
            self.search(board, ii, jj, stack, status, visited) 
        visited.remove((i, j))
        stack.append(s)

TC : O(mn)
SC: O(mn)