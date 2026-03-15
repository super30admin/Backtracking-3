#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 79: Word Search
    Link: https://leetcode.com/problems/word-search/

    Problem:
    Given an m x n grid of characters and a string word, return true if word exists
    in the grid. The word must be constructed from sequentially adjacent cells
    (horizontally or vertically), and the same cell may not be used more than once.

    Approach:
    Backtracking DFS. For each cell matching word[0], run a recursive helper that
    checks bounds, character match, and marks cells as '#' to prevent revisiting.
    Restore the cell after recursion (backtrack).

    Optimization: pre-check character frequencies — if the board doesn't have enough
    of any character in word, return False immediately before any DFS.

    1️⃣ Build frequency map of board; decrement for each char in word; if any < 0 → False.
    2️⃣ For each cell matching word[0], call helper(r, c, idx=0).
    3️⃣ helper: base case idx == len(word) → True. Check bounds and char match.
    4️⃣ Mark board[r][c] = '#', recurse all 4 directions, restore board[r][c] = word[idx].

    // Time Complexity : O(m * n * 4^L)
        L = len(word); each DFS branch explores at most 4 directions per step.
    // Space Complexity : O(L)
        Recursive call stack depth equals the word length.

"""

from collections import defaultdict
from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        rows = len(board)
        cols = len(board[0])

        # Optimization: check if board has enough of each character
        hMap = defaultdict(int)
        for i in range(rows):
            for j in range(cols):
                hMap[board[i][j]] += 1

        for char in word:
            hMap[char] -= 1
            if hMap[char] < 0:
                return False

        def helper(r, c, idx):
            if idx == len(word):
                return True

            if r < 0 or r >= rows or c < 0 or c >= cols:
                return False

            if board[r][c] != word[idx]:
                return False

            board[r][c] = "#"

            for dx, dy in directions:
                if helper(r + dx, c + dy, idx + 1):
                    return True

            board[r][c] = word[idx]
            return False

        for i in range(rows):
            for j in range(cols):
                if board[i][j] == word[0]:
                    if helper(i, j, 0):
                        return True

        return False

    '''
    def exist(self, board: List[List[str]], word: str) -> bool:
        # DFS without frequency pre-check.
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        def helper(r, c, idx):
            if idx == len(word):
                return True
            if r < 0 or r >= len(board) or c < 0 or c >= len(board[0]):
                return False
            if board[r][c] != word[idx]:
                return False

            board[r][c] = "#"
            for dx, dy in directions:
                if helper(r + dx, c + dy, idx + 1):
                    return True
            board[r][c] = word[idx]
            return False

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if helper(i, j, 0):
                        return True
        return False
    '''

    '''
    def exist(self, board: List[List[str]], word: str) -> bool:
        # BFS approach — carries visited set per path (high memory cost).
        from collections import deque
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        rows, cols = len(board), len(board[0])

        def bfs(i, j):
            queue = deque()
            queue.append((i, j, 0, {(i, j)}))

            while queue:
                x, y, index, visited = queue.popleft()
                if index == len(word) - 1:
                    return True
                for a, b in directions:
                    rx, ry = x + a, y + b
                    if 0 <= rx < rows and 0 <= ry < cols and board[rx][ry] == word[index + 1] and (rx, ry) not in visited:
                        queue.append((rx, ry, index + 1, visited | {(rx, ry)}))
            return False

        for i in range(rows):
            for j in range(cols):
                if board[i][j] == word[0]:
                    if bfs(i, j):
                        return True
        return False
    '''
