#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 51: N-Queens
    Link: https://leetcode.com/problems/n-queens/

    Problem:
    Place n queens on an n x n chessboard such that no two queens attack each other.
    Return all distinct solutions. Each solution is a list of strings where 'Q' = queen
    and '.' = empty.

    Approach:
    Backtracking row by row. Use three boolean arrays to track conflicts in O(1):
    - columnFilled[col]: column already has a queen.
    - mainDiagonalFilled[row - col + n]: top-left → bottom-right diagonal.
    - antiDiagonalFilled[row + col]: top-right → bottom-left diagonal.

    Place one queen per row, mark the three constraints, recurse to next row, then
    unmark (backtrack). When row == n, convert the board to the output format.

    1️⃣ For each column in the current row, check all three constraint arrays.
    2️⃣ If safe: place queen, mark constraints, recurse row+1, unmark.
    3️⃣ Base case row == n: serialize board to List[str] and append to results.

    // Time Complexity : O(n!)
        At most n! placements explored.
    // Space Complexity : O(n^2)
        Board storage + O(n) constraint arrays + O(n) call stack.

"""

from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board = [[False] * n for _ in range(n)]
        self.result = []
        self.columnFilled = [False] * (n + 1)
        self.mainDiagonalFilled = [False] * (2 * n)
        self.antiDiagonalFilled = [False] * (2 * n)

        def helper(row, n):
            if row == n:
                itrList = []
                for i in range(n):
                    temp = ""
                    for j in range(n):
                        temp += "Q" if self.board[i][j] else "."
                    itrList.append(temp)
                self.result.append(itrList)
                return

            for col in range(n):
                columnIndex = col
                mainDiagonalIndex = row - col + n
                antiDiagonalIndex = row + col

                if (not self.columnFilled[columnIndex] and
                        not self.mainDiagonalFilled[mainDiagonalIndex] and
                        not self.antiDiagonalFilled[antiDiagonalIndex]):
                    self.board[row][col] = True
                    self.columnFilled[columnIndex] = True
                    self.mainDiagonalFilled[mainDiagonalIndex] = True
                    self.antiDiagonalFilled[antiDiagonalIndex] = True

                    helper(row + 1, n)

                    self.board[row][col] = False
                    self.columnFilled[columnIndex] = False
                    self.mainDiagonalFilled[mainDiagonalIndex] = False
                    self.antiDiagonalFilled[antiDiagonalIndex] = False

        helper(0, n)
        return self.result
