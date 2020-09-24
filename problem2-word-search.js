//https://leetcode.com/problems/word-search/
//// Time Complexity :
//// Space Complexity :
//// Did this code successfully run on Leetcode :
//// Any problem you faced while coding this :

// internalizing backtracking problems

//// Your code here along with comments explaining your approach
var exist;

exist = function(board, word) {
  var backtrack, directions;
  directions = [[0, 1], [0, -1], [1, 0], [-1, 0]];
  exist = function() {
    var i, j, k, l, ref, ref1;
    for (i = k = 0, ref = board.length; (0 <= ref ? k < ref : k > ref); i = 0 <= ref ? ++k : --k) {
      for (j = l = 0, ref1 = board[0].length; (0 <= ref1 ? l < ref1 : l > ref1); j = 0 <= ref1 ? ++l : --l) {
        if (board[i][j] === word[0]) {
          if (backtrack(i, j, 0)) {
            return true;
          }
        }
      }
    }
  };
  return backtrack = function(i, j, index) {
    var c, k, len, r, temp, x, y;
    // base case
    if (index >= word.length) {
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
};

//# sourceMappingURL=problem2-word-search.js.map
