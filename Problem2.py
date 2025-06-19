
# Time Complexity : O(m*n.3^(l)), l=length of the word
# Space Complexity : O(l) , the recursive stack of the length of the word
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
# Three line explanation of solution in plain english:
"""1. We search board of letters using dfs in all 4 directins and use recursion to check if the word can be formed.
2. If the current character matches the word at the current index, we mark it as visited and continue the search.
3. If we reach the end of the word, we return true, and then backtrack by resetting character in the board as it was before to explore other possibilities."""
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        m=len(board)
        n=len(board[0])
        #call the helper function for each row and column and keep track of the letters in the word with idx pointer
        def helper(board,r,c,word,idx):
            dirs=[(-1, 0), (1, 0), (0, -1), (0, 1)]
            #check if there is out of bound conditions and search happens within the matrix
            if r<0 or c<0 or r==len(board) or c==len(board[0]):
                return
            #when the idx reaches the end of the word string then search is successful and return True
            if idx==len(word): return True
            #once a character is found while iterating over the board and the word(idx) mark it visited proceed the recursion
            if board[r][c]==word[idx]:
                board[r][c]='#'
                #recursively search in all 4 directions
                for d in dirs:
                    nr=r+d[0]
                    nc=c+d[1]
                    #if the recursion call was true return true at the current call
                    if helper(board,nr,nc,word,idx+1):
                        return True
                #reset the current character in the board to explore other directions 
                board[r][c]=word[idx]
            #return false if the current character does not match the word at idx or if the recursion did not find a match
            return False
        #explore each letters in the board and check if the first letter of the word is found then start the recursion 
        for i in range(m):
            for j in range(n):
                if word[0]==board[i][j]:
                    #call the recursion function when the source(first letter of word) return True if there is a match
                    if helper(board,i,j,word,0): return True
        return False
        