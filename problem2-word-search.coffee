#https://leetcode.com/problems/word-search/
#// Time Complexity :
#// Space Complexity :
#// Did this code successfully run on Leetcode :
#// Any problem you faced while coding this :
#
# internalizing backtracking problems
#
#// Your code here along with comments explaining your approach

exist = (board, word) ->
  directions = [[0,1], [0, -1], [1, 0], [-1, 0]]

  exist = () ->
    for i in [0...board.length]
      for j in [0...board[0].length]
        if board[i][j] is word[0]
          return true if backtrack(i, j, 0)

  backtrack = (i, j, index) ->
    # base case
    if index >= word.length
      return true

    temp = board[i][j]
    board[i][j] = '#'

    # recurse
    for [y, x] in directions
      r = i + y
      c = j + x

      if r >= 0 and r < board.length and c >= 0 and c < board[0].length and (index + 1 < word.length) and word[index+1] is board[r][c]
        return true if backtrack(r, c, index + 1)

    board[i][j] = temp

    return false




