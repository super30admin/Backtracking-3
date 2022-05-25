# TC - O(2^N) ---- Not sure. Please correct me if am wrong
# SC - O(N)
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """

        visited = set()
        size_word = len(word)
        rows = len(board)
        cols = len(board[0])
        index = 0
        dirs = [[0, 1], [0, - 1], [1, 0], [-1, 0]]

        def checkIfExists(index, row, col):
            if board[row][col] != word[index]:
                return False

            if index == size_word - 1:
                return True

            visited.add((row, col))

            for pos in dirs:
                r = pos[0] + row
                c = pos[1] + col
                if r >= 0 and r < rows and c >= 0 and c < cols and (r, c) not in visited:
                    result = checkIfExists(index+1, r, c)
                    if result:
                        return result

            visited.remove((row, col))

            return False

        for row in range(rows):
            for col in range(cols):
                visited = set()
                if checkIfExists(0, row, col):
                    return True

        return False
