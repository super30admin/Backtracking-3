//https://leetcode.com/problems/n-queens/
//// Time Complexity : O(N^N) backtracking visits all possibilities
//// Space Complexity : O(N^N) where N is board size, for stack space we visit for each 1 possibility
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :

// getting the output to look like leetcode wanted!
// need to be confident in .map vs for loop

//// Your code here along with comments explaining your approach

// insights:
// check row, column, diagonal
// check other queens position
// when checking a queen for placement
//   check directly up
//   check diagonal left up
//   check diagonal right up
//   (no need to check down we are inserting top to bottom, we won't have placed any queens in a row below)
//   (no need to check left or right, can only place queens in different rows)

// place dots throughout the matrix.  (we want the output to look like [. . Q .] for example)
// [. . . Q]
// [. Q . .]
// [Q . . .]
// [. . Q .]
var flat, solveNQueens;

flat = function(arr) {
  return arr.reduce(function(acc, a) {
    return acc.concat(Array.isArray(a) ? flat(a) : a);
  }, []);
};

solveNQueens = function(n) {
  var backtrack, board, isValid, makeOutput, output;
  // make n*n chars
  board = (function() {
    var results = [];
    for (var k = 0; 0 <= n ? k < n : k > n; 0 <= n ? k++ : k--){ results.push(k); }
    return results;
  }).apply(this).map(function(index) {
    return Array(n).fill('.');
  });
  output = [];
  makeOutput = function(board) {
    var i, k, ref, retlist;
    retlist = [];
    for (i = k = 0, ref = board.length; (0 <= ref ? k < ref : k > ref); i = 0 <= ref ? ++k : --k) {
      retlist.push(board[i].join(''));
    }
    return retlist;
  };
  isValid = function(i, j) {
    var c, r;
    r = i;
    c = j;
    // upper column
    while (r >= 0) {
      if (board[r][c] === 'Q') {
        return false;
      }
      r -= 1;
    }
    // left diagonal
    r = i;
    c = j;
    while (r >= 0 && c >= 0) {
      if (board[r][c] === 'Q') {
        return false;
      }
      r -= 1;
      c -= 1;
    }
    // right diagonal
    r = i;
    c = j;
    while (r >= 0 && c < board.length) {
      if (board[r][c] === 'Q') {
        return false;
      }
      r -= 1;
      c += 1;
    }
    return true;
  };
  backtrack = function(queensLeft, i) {
    var j, k, ref, results;
    if (queensLeft <= 0) { // base case, no queens left, valid answer
      return output.push(makeOutput(board));
    }
// place the queen
    results = [];
    for (j = k = 0, ref = board.length; (0 <= ref ? k < ref : k > ref); j = 0 <= ref ? ++k : --k) {
      if (isValid(i, j)) {
        board[i][j] = 'Q';
        backtrack(queensLeft - 1, i + 1);
        results.push(board[i][j] = '.');
      } else {
        results.push(void 0);
      }
    }
    return results;
  };
  backtrack(n, 0);
  return output;
};

solveNQueens(4);

//# sourceMappingURL=problem1-nqueens.js.map
