# // Time Complexity : N(3^L)     L: length of word
# // Space Complexity : O(L)  atck space
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# for each word in 2D array we check if its equal to word[0]
# if True: we backtrack on that
# in backtrack function we check for 4 directions using dirs array
# each call will have index increased and we will check that index with the updated row and col with dirs array
# When we find len(word) == index, we return True
# we convert visited number into # and put its value in temp variable
# in backtrack step we convert the number again to the original  

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        directions = [(1,0),(0,1),(-1,0),(0,-1)]
        
        def backtrack(i,j,index):
            #base
            if len(word) == index:return True
            
            if i<0 or j<0 or i>=m or j>=n or board[i][j]=="#": return False
            
            #logic
            # action
            if board[i][j] == word[index]:
                temp = board[i][j]
                board[i][j] = "#"

                #recursion
                for x,y in directions:
                    r = x+i
                    c = y+j
                    if backtrack(r,c,index+1):
                        board[i][j] = temp
                        return True

                #Backtrack
                board[i][j] = temp
            return False
        
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    if backtrack(i,j,0): 
                        return True
        return False
            
            
        