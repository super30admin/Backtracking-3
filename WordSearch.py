def exist(self, board: List[List[str]], word: str) -> bool:
    def backtracking(i, j, board, word, index):
        directions = [[-1,0],[1,0],[0,-1],[0,1]]
        #base
        if index==len(word):
            return True
        
        temp = board[i][j]
        board[i][j]='#'
        
        #recursive
        for dirs in directions:
            r = i+dirs[0]
            c = j+dirs[1]
            
            if (r>=0 and c>=0 and r<len(board) and c<len(board[0]) and board[r][c]==word[index]):
                
                if (backtracking(r,c,board,word,index+1)):
                    return True
        board[i][j]=temp
    
    start = []
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j]==word[0]:
                start.append([i,j])
    flag = 0
    for i in start:
        if (backtracking(i[0], i[1], board, word, 1)):
            flag = 1
    return flag==1