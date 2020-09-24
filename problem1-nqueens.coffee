#https://leetcode.com/problems/n-queens/
#// Time Complexity : O(N^N) backtracking visits all possibilities
#// Space Complexity : O(N^N) where N is board size, for stack space we visit for each 1 possibility
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#
# getting the output to look like leetcode wanted!
# need to be confident in .map vs for loop
#
#// Your code here along with comments explaining your approach

# insights:
# check row, column, diagonal
# check other queens position
# when checking a queen for placement
#   check directly up
#   check diagonal left up
#   check diagonal right up
#   (no need to check down we are inserting top to bottom, we won't have placed any queens in a row below)
#   (no need to check left or right, can only place queens in different rows)
#
# place dots throughout the matrix.  (we want the output to look like [. . Q .] for example)
# [. . . Q]
# [. Q . .]
# [Q . . .]
# [. . Q .]

flat = (arr) ->
  arr.reduce(
    (acc, a) -> acc.concat(
      if Array.isArray(a) then flat(a) else a
    ),
    [])

solveNQueens = (n) ->
  # make n*n chars
  board = ([0...n].map (index) -> Array(n).fill('.'))
  output = []

  makeOutput = (board) ->
    retlist = []

    for i in [0...board.length]
      retlist.push(board[i].join(''))

    retlist

  isValid = (i, j) ->
    r = i
    c = j

    # upper column
    while r >= 0
      return false if board[r][c] is 'Q'
      r -= 1

    # left diagonal
    r = i
    c = j
    while r >= 0 and c >= 0
      return false if board[r][c] is 'Q'
      r -= 1
      c -= 1

    # right diagonal
    r = i
    c = j
    while r >= 0 and c < board.length
      return false if board[r][c] is 'Q'
      r -= 1
      c += 1

    true

  backtrack = (queensLeft, i) ->
    if queensLeft <= 0 # base case, no queens left, valid answer
      return output.push(makeOutput(board))

    # place the queen
    for j in [0...board.length]
      if isValid(i, j)
        board[i][j] = 'Q'
        backtrack(queensLeft - 1, i + 1)
        board[i][j] = '.'

  backtrack(n, 0)
  output

solveNQueens(4)
