//https://leetcode.com/problems/word-search/
//// Time Complexity : O(N^N)
//// Space Complexity : O(N^N) stack space
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :

// off by 1 error in the base case, comparing to length vs length - 1

//// Your code here along with comments explaining your approach

// for each position on the board
//   find the current character
//   if you find it, recurse looking for the next character (look up, down, left, right of current position)
//   if you've found all characters in the input, return true immediately
var exist;

exist = function(board, word) {
  var backtrack, directions, i, j, k, l, ref, ref1;
  directions = [[0, 1], [0, -1], [1, 0], [-1, 0]];
  backtrack = function(i, j, index) {
    var c, k, len, r, temp, x, y;
    // base case
    if (index >= word.length - 1) {
      return true;
    }
    temp = board[i][j];
    board[i][j] = '#';
// recurse
    for (k = 0, len = directions.length; k < len; k++) {
      [y, x] = directions[k];
      r = i + y;
      c = j + x;
      if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && (index + 1 < word.length) && word[index + 1] === board[r][c]) {
        if (backtrack(r, c, index + 1)) {
          return true;
        }
      }
    }
    board[i][j] = temp;
    return false;
  };
  for (i = k = 0, ref = board.length; (0 <= ref ? k < ref : k > ref); i = 0 <= ref ? ++k : --k) {
    for (j = l = 0, ref1 = board[0].length; (0 <= ref1 ? l < ref1 : l > ref1); j = 0 <= ref1 ? ++l : --l) {
      if (board[i][j] === word[0]) {
        if (backtrack(i, j, 0)) {
          return true;
        }
      }
    }
  }
  return false;
};

exist([["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "ABCCED");

exist([["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "SEE");

//# sourceMappingURL=problem2-word-search.js.map
