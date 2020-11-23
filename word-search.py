# Time Complexity:- O(n*3^w) w=length of the word
# Space Complexity:- O(L) the recursion depth can max go upto the length of the word we are searching for
# Go through the entire matrix looking for the start letter of the word, check the four directions looking for the next letter
# IF we find the next letter recurse on it, if we cant find the next letter we backtrack and keep on doing this process
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        def backtrack(i,j,index):
            # base case
            if 0<=i<len(board) and 0<=j<len(board[0]):
                if word[index]!=board[i][j]:
                    return False
                if index==len(word)-1:
                    return True
            else:
                return False
            # action    
            temp=board[i][j]
            board[i][j]="#"
            for k,l in dirs:
                # recurse
                if backtrack(i+k,j+l,index+1):
                    return True
            # backtrack
            board[i][j]=temp
            
        for i in range(len(board)):
            for j in range(len(board[0])):
                if(backtrack(i,j,0)):
                    return True
        return False