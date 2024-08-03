####79. Word Search##################################################################################################
// Time Complexity : not able to deduce
// Space Complexity : k
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
We used recursion with direction array important thing to do is to make sure the element is changed to # once it is found also backtracked if the element is not found.

class Solution:
    def __init__(self):
        self.flag=False

    def exist(self, board: List[List[str]], word: str) -> bool:
        print('test',ord('b')-ord('a'))
        r=len(board)
        c=len(board[0])
        #l1=[]
        dirl=[[0,1],[1,0],[0,-1],[-1,0]]
        len1=len(word)
        for m in range(r):
            for n in range(c):
                if board[m][n]==word[0]:
                    board[m][n]='#'
                    #print(r,c,m,n,word[0])
                    self.backtrack(board,word,r,c,m,n,1,dirl)
                    if self.flag:
                        return True
                    board[m][n]=word[0]
                    #print('new start:',word[0],board)
        return self.flag

    def backtrack(self,board,word,r,c,rc,cc,idx,dirl):
        #base
        
        if idx==len(word):
            #print('base:',board)
            self.flag=True
            return


        #logic
        
        for i in dirl:
            rn,cn=rc+i[0],cc+i[1]
            if rn>=0 and cn>=0 and rn<r and cn<c:
                if board[rn][cn]==word[idx]:
                    tmp=board[rn][cn]
                    board[rn][cn]='#'
                    #print(board)
                    self.backtrack(board,word,r,c,rn,cn,idx+1,dirl)
                    board[rn][cn]=tmp
        #board[rc][cc]==word[idx]
        #False



        