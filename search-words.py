class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if board == [] or len(board) == 0:
            return False
        dirs = ((1, 0), (0, 1), (-1, 0), (0, -1))

        def backtrack(board, word, i, j, index):
            if index == len(word):
                return True
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] == '#':
                return False

            if board[i][j] == word[index]:
                temp = board[i][j]
                board[i][j] = '#'
                for dir in dirs:
                    r = i + dir[0]
                    c = j + dir[1]
                    if backtrack(board, word, r, c, index + 1):
                        return True
                # print(temp)
                board[i][j] = temp

        for i in range(len(board)):
            for j in range(len(board[0])):
                if backtrack(board, word, i, j, 0):
                    return True
        return False

