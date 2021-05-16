## Problem2
#Word Search(https://leetcode.com/problems/word-search/)

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board == None or len(board)==0:
                return False
        self.m = len(board)
        self.n = len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if self.backtrack(board, word,i,j,0):
                    return True
        return False
    def backtrack(self, board, word, i,j,index):
        #base:
        if index==len(word):
            return True
        if i<0 or j<0 or i==self.m or j==self.n or board[i][j]=='#':
            return False
        #logic:
        if board[i][j]==word[index]:
            dir = [[0,1],[0,-1],[1,0],[-1,0]]
            temp = board[i][j]
            board[i][j] = '#'
            for k in dir:
                r = i + k[0]
                c = j + k[1]
                if self.backtrack(board,word,r,c,index+1):
                    return True
            board[i][j] = temp
        return False
    
#Time Complexity: O(N *(3^L)) N = m*n L - length of the word
#Space Complexity: L
#Approach: Trverse the board then pass it to the backtrack method. In the backtrack method, find a letter that matches the word then move in different directions and keep changing the visited letter to another charecter and once we complete that loop revert it back to the original value. If it runs until the end of the word, return true else return false. 
    