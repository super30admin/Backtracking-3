class Solution:
    result = True
    direction = []
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        self.direction = [[-1,0] , [1,0] , [0,1] , [0,-1]]

        for i in range(len(board)):
            for j in range(len(board[0])):

                if self.backtrack(board , i , j , 0,word):
                    return True
        

        return False

    def backtrack(self, board , row , col, word_index, word):
       
        if word_index == len(word):
            return True 

        #base
        if row < 0 or row == len(board) or col < 0 or col == len(board[0]) or board[row][col] == ".":
            return False
        
        

        #logic
        if board[row][col] == word[word_index]:
            
            ch = board[row][col]
    
            #action
            board[row][col] = "."
            for dirs in self.direction:
                nr = dirs[0] + row
                nc = dirs[1] + col

                #recurse
                if self.backtrack(board , nr , nc , word_index + 1,word):
                    return True

            #backtrack
            board[row][col] = ch

        return False 
