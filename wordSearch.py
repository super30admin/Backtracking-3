# // Time Complexity : O(3^L)
# // Space Complexity : O(L)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only
class solution:
    def search(self, board, word):
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if self.helper(board, i, j, 0, word):
                        return True
        
        return False

    def helper(self, board, r,c, i,word):
        '''
        We have to backtrack here because inorder to find a word we might cross paths while exploring. so we have index pointer that points towards index of word, row, col of board

        in our base case we check if index has finished or not. if yes then return true. In logic we see if the char at that index is same as the celll in board then move in all 3 directions

        and recurse. but before recurse we change the element to a dummy element that marks visited. after recursion we put back the element, this is the backtracking part. 
        
        '''
        # base
        if i == len(word):
            return True

        if r<0 or c<0 or r>= len(board) or c>= len(board[0]) or board[r][c] == "#":
            return False
        # logic
        dir = [[-1,0],[1,0],[0,1],[0,-1]]
        
        if word[i] == board[r][c]:

            board[r][c]= "#"


            for d in dir:
                nr = r+d[0]
                nc = c+d[1]

                if self.helper(board, nr, nc, i+1, word):
                    return True
            
            board[r][c] = word[i]

        return False
