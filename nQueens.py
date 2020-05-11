"""
## Problem1
N Queens(https://leetcode.com/problems/n-queens/)

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.


"""
def nQueen(self,n):
    board=[['.']*(n) for i in range(n)]

    self.output=[]
    self.backTrack(n, board, 0)

    return self.output


def backTrack(self, board, n, i):
    #base
    if n==0:
        self.insert_output(board)
        return


    #recursive
    for j in range(len(board)):
        if self.isSafe(board,i , j):
            board[i][j]='Q'
            self.backTrack(board, n-1,i+1)
            board[i][j] = '.'

def insert_output(board):
    temp_list=[]
    for i in range(len(board)):
        temp=[]
        for j in range(len(board[0]):
            temp.append(board[i][j])

        temp_list.append(temp)
    self.output.append(temp_list)


# to check whether Q is safe to place ofr not
def isSafe(self,board, i , j ):
    #col
    for r in range(i):
        if board[r][j] == 'Q':
            return False


# diagonal left
    x=i-1
    y=j-1
    while x >=0 and y >=0:
        if board[x][y] == 'Q':
            return False
        x -=1
        y -=1

#diagonal right

    x = i - 1
    y = j + 1
    while x >= 0 and y < len(board):
        if board[x][y] =='Q':
            return False
        x -=1
        y +=1
