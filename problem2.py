#time complexity: O(n*m*3^len(word))
#space complexity: O(len(word))
#ran on leetcode: Yes
#DFS with backtracking. when there is a match between a charcter in word and board, recurse in all 4 directions. After all recursion, backtrack to remove the current index from visited since this index can be visited by some other recursion. when all the charcters in word has been processed return True. Else return False. 
class Solution:
    def backtrack(self, index,i,j, word,seen,board):
        if(index==len(word)):
            return True
        if(i<0 or i>=len(board) or j < 0 or j>=len(board[0])):
            return False

        if(board[i][j]==word[index] and seen[i][j]==False):
            seen[i][j]=True
            a=self.backtrack(index+1,i+1,j,word,seen,board)
            if(a):
                return a
            b=self.backtrack(index+1,i-1,j,word,seen,board)
            if(b):
                return b
            c=self.backtrack(index+1,i,j-1,word,seen,board)
            if(c):
                return c
            d=self.backtrack(index+1,i,j+1,word,seen,board)
            seen[i][j]=False
            return a or b or c or d
        else:
            return False

    def exist(self, board: List[List[str]], word: str) -> bool:
        seen=[]
        for i in board:
            temp=[]
            for j in i:
                temp.append(False)
            seen.append(temp)
        #print(seen)
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                ans=self.backtrack(0,i,j,word,seen,board)
                if(ans==True):
                    return True
        return False
