#Time complexity : O(mn*(3^L))i.e. everytime we are going over 3 neighbiours as one neighbour is already visited for going over the recursion function 
#Space complexity : O(L) space of the recursive stack i.e. it won't store more then the length of string
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=7cZkbmXlRjM&ab_channel=%7BS30%7D
class Solution:
    directions = [[0,1], [1,0], [-1,0], [0,-1]]
    def exist(self, board: List[List[str]], word: str) -> bool:
        #storing the dimension of board in m and n
        m = len(board)
        n = len(board[0])
        #iterating over the board for finding the first word alpabet occurance
        for i in range(m):
            for j in range(n):
                #if the first word occurance is found then we will call the backtrack function
                if word[0] == board[i][j]:
                    #backtrack function will go over all the first letter alphater in word till the word is searched
                    if self.backtrack(board, i,j, word, 0):
                        return True
        return False
    #it is boolean function
    def backtrack(self, board: List[List[str]], row :int, column:int, word: str, index:int) -> bool:
        #base condition
        #if the word index go out of bound then we will return true as the word search is found
        if index == len(word):
            return True
        #if by iterating over the diretion if we found index out of bound for the board then we will return false
        #further if we find the particular position is already visited then we return false
        if row<0 or column< 0 or row== len(board) or column == len(board[0]) or board[row][column] == '#':
            return False
        
        #logic
        #checking the alphabet at the index is same in the index at word
        if board[row][column]==word[index]:
            #further we will call the backtrack function on it by iterating over the direction matrix
            for direction in self.directions:
                nr = row + direction[0]
                nc = column + direction[1]
                #action
                board[row][column] ='#'
                #recurse
                #we are putting the condition to check if there is further alphabet present in the neighbour or not if not present then it will return false so that we won't go further
                if self.backtrack(board, nr, nc, word, index+1):
                    return True
                #backtrack
                board[row][column] =word[index]
        return False        
