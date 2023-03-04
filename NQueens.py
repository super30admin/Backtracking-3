"""
Rasika Sasturkar
Time Complexity: O(n^2)+O(n) = O(n^2), creating the board - n^2 & recursive stack of n.
Space Complexity: O(n!)
"""


def solveNQueens(n: int):
    """
    We maintain a boolean board of n*n and if we place the queen
    we can mark it as True
    """
    result = []
    board = [[False for _ in range(n)] for _ in range(n)]

    def backtrack(board, r):
        """
        There is one pointer for the row in board and if it goes out
        of bounds that means all Queens are placed. We check in every
        row if placing the queen at that position is safe or not. If
        the column pointer goes out of bounds then we backtrack to previous
        iteration changing the position of the previously placed queen.
        """
        # base case
        if r == n:
            res = []
            for i in range(n):
                temp = []
                for j in range(n):
                    if board[i][j]:
                        temp.append("Q")
                    else:
                        temp.append(".")
                res.append("".join(temp))
            result.append(res)
        # logic
        # check safe column
        for c in range(n):
            if isSafe(board, r, c):
                board[r][c] = True  # action
                backtrack(board, r + 1)  # recurse
                board[r][c] = False  # backtrack

    def isSafe(board, r, c):
        """
        To check if the placing the queen at board[i][j] is safe, i.e.
        there is no queen in the same column above it, there is no queen
        in the left diagonal above it and there is no queen in the right
        diagonal above it.
        """
        # same column
        for i in range(r):
            if board[i][c]:
                return False

        # upper left
        i, j = r, c
        while i >= 0 and j >= 0:
            if board[i][j]:
                return False
            i -= 1
            j -= 1

        # upper right
        i, j = r, c
        while i >= 0 and j < n:
            if board[i][j]:
                return False
            i -= 1
            j += 1

        return True

    backtrack(board, 0)
    return result


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(solveNQueens(n=4))  # return [['.Q..', '...Q', 'Q...', '..Q.'], ['..Q.', 'Q...', '...Q', '.Q..']]
    print(solveNQueens(n=1))  # return [['Q']]


if __name__ == "__main__":
    main()
