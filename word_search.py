
# Time Complexity :
# O(4^MN)

# Space Complexity :
# O (L) - max stack depth

# Did this code successfully run on Leetcode :
#Yes
 
#We do a DFS + backtracking from each element of the array. If at any DFS path, we find the word, we return True, else False
#In the DFS function, we check if first letter of the word is at the position of the board we are looking at, then we mark it as visited, call DFS on all it's neighbours word a shoter word (1st char removed)
#If any of the paths finds a solution, we are done and return True. Else return False. At the end of the loop we also mark the current location is unvisited for further DFS runs to explore it

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        #Checking if enough number each character exists on the board
        if not (cnt := Counter(word)) <= Counter(chain(*board)):      
            return False
        self.n = len(board)
        self.m = len(board[0])
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                if board[i][j] != word[0]:
                    continue
                if self.helper(board,i,j,word):
                    return True 
        return False

    def helper(self,board,i,j,word):
        if len(word) == 0 : 
            return True
        if board[i][j] != word[0] :
            return False
        board[i][j] = "#"
        if len(word) == 1:
            return True
        neighbours = [(0,-1),(0,1),(1,0),(-1,0)]
        for loc in neighbours:
            x = i + loc[0]
            y = j + loc[1]
            if self.is_valid_index(x,y) :
                if self.helper(board,x,y,word[1:]) == True :
                    return True 
        board[i][j] = word[0]
        return False

    def is_valid_index(self,x,y):
        if x < 0 or x >= self.n :
            return False
        if y < 0 or y >= self.m :
            return False
        return True
