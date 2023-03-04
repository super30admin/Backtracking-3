"""
Rasika Sasturkar
Time Complexity: O(m*n + 3^L), searching the first character on board, and
                for every character of the word we search in 3 directions.
Space Complexity: O(L), where L is length of the word.
"""


def exist(board, word: str) -> bool:
    """
    We use DFS to search for the word on the given board. We check the character
    in the 4 directions-top, right, bottom, left and proceed in that direction in
    which we find the character by marking it as visited. If later we can't find the
    word and want to return from any recursive call, we use backtracking to mark it
    as unvisited.
    """
    dirs = [[1, 0], [-1, 0], [0, -1], [0, 1]]
    # null case
    if board is None:
        return False
    m = len(board)
    n = len(board[0])

    def backtrack(board, word, i, j, idx):
        # base case
        if idx == len(word):
            return True
        if i < 0 or j < 0 or i == m or j == n or board[i][j] == "*":
            return False

        # logic
        if board[i][j] == word[idx]:
            # action
            char = board[i][j]
            board[i][j] = "*"  # marked as visited

            # recurse
            for dirn in dirs:
                nr = i + dirn[0]
                nc = j + dirn[1]
                if backtrack(board, word, nr, nc, idx + 1):
                    return True
            # backtrack
            board[i][j] = char

        return False

    for i in range(m):
        for j in range(n):
            if backtrack(board, word, i, j, 0):
                return True

    return False


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]],
                word="ABCCED"))  # returns True
    print(exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]],
                word="SEE"))  # returns True
    print(exist(board=[["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]],
                word="ABCB"))  # returns False


if __name__ == "__main__":
    main()
