#https://leetcode.com/problems/word-search/
#// Time Complexity : O(N^N)
#// Space Complexity : O(N^N) stack space
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#
# off by 1 error in the base case, comparing to length vs length - 1
#
#// Your code here along with comments explaining your approach
#
# for each position on the board
#   find the current character
#   if you find it, recurse looking for the next character (look up, down, left, right of current position)
#   if you've found all characters in the input, return true immediately

exist = (board, word) ->
  directions = [[0,1], [0, -1], [1, 0], [-1, 0]]

  backtrack = (i, j, index) ->
    # base case
    if index >= word.length - 1
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

  for i in [0...board.length]
    for j in [0...board[0].length]
      if board[i][j] is word[0]
        return true if backtrack(i, j, 0)

  false

exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],"ABCCED")
exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],"SEE")
