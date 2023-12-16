# TC: O(M X N)
# SC: O(M X N)

class Solution:
    dir1=[[0,1],[1,0],[0,-1],[-1,0]]
    flag=False

    def helper(self,board,i,j,w,word):
        if w==len(word):
            self.flag=True
            # print(li)
            print(i,j)
            print(w)
            return 

        for k in range(0,len(self.dir1)):
            r=i+self.dir1[k][0]
            c=j+self.dir1[k][1]

            if r>=0 and c>=0 and r<len(board) and c<len(board[0]) and board[r][c]==word[w] :
                # li.append((r,c))
                board[r][c]="#"
                self.helper(board,r,c,w+1,word)
                board[r][c]=word[w]

    def exist(self, board: List[List[str]], word: str) -> bool:
        self.flag=False
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                if board[i][j]==word[0]:
                    board[i][j]="#"
                    self.helper(board,i,j,1,word)
                    board[i][j]=word[0]
        
        return self.flag
        