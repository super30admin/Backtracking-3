# Time Complexity: (M * N) * 3^K where K is the length of the word we are searching
# Space Complexity: O(K) Length of the word we are searching
# Passed Leetcode
class Solution:
    
    def backtrack(self, path_set, board_index, word_index):
        
        i, j = board_index
        
        path_set.add((i, j))
        # print(path_set)
        if word_index == len(self.word) - 1:
            return True
        
        for k in range(len(self.x_vals)):
            
            x, y = i + self.x_vals[k], j + self.y_vals[k]
            
            if x >= 0 and y >= 0 and x < len(self.board) and y < len(self.board[0]) and (x, y) not in path_set and self.board[x][y] == self.word[word_index + 1]:
                
                found = self.backtrack(path_set, (x, y), word_index + 1)
                                                          
                if found:
                    return True
                
                path_set.remove((x, y))
        return False
                
        
    
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        self.x_vals = [1,-1,0,0]
        self.y_vals = [0,0,-1,1]
        self.board = board
        self.word = word
        for i in range(len(board)):
            
            for j in range(len(board[0])):
                
                if board[i][j] == word[0]:
                    
                    found = self.backtrack(set(), (i, j), 0)
                    if found:
                        return True
        return False