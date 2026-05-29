class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board or not board[0]:
            return False

        rows, cols = len(board), len(board[0])
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        
    
        def bfs(start_i, start_j):
            queue = deque()
            queue.append((start_i, start_j, 0, {(start_i, start_j)}))
            
            while queue:
                i, j, idx, visited = queue.popleft()

                if idx == len(word) - 1:
                    return True

                for di, dj in directions:
                    new_i, new_j = i + di, j + dj

                    if 0 <= new_i < rows and 0 <= new_j < cols and (new_i, new_j) not in visited:
                        if board[new_i][new_j] == word[idx + 1]: 
                            new_visited = visited.copy()
                            new_visited.add((new_i, new_j))
                            queue.append((new_i, new_j, idx + 1, new_visited))

            return False

        for i in range(rows):
            for j in range(cols):
                if board[i][j] == word[0]:
                    if bfs(i, j):
                        return True

        return False

# Time: O(m * n * 4^L) where L is length of the word
# space: O(M * N * L)