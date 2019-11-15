
class Solution(object):
    # n= None
    # m= None
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        n = len(board[0])  # columns
        m = len(board)  # rows
        # visited array
        visited_array = [[False for i in range(n)] for j in range(m)]
        index = 0
        # at each point traverse through the elements
        for i in range(m):
            for j in range(n):
                if self.helper_dfs(board, i, j, word, visited_array, index):  # if word founf this returns true
                    return True
        return False  # at no point u find the string return False

    def helper_dfs(self, board, i, j, word, visited_array, index):
        # edge case 1
        if index == len(
                word):  # word found then the index will be equal to length as index starts afrom zero, in the previous recursive step only we must have found the word.
            return True
        # edge case2
        if i >= len(board) or i < 0 or j < 0 or j >= len(board[0]) or visited_array[i][j] or board[i][j] != word[index]:
            return False  # main step of algo
        visited_array[i][j] = True

        # backtrack logic
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        for dir in dirs:
            dfs_i = dir[0] + i  # row
            dfs_j = dir[1] + j  # column
            if self.helper_dfs(board, dfs_i, dfs_j, word, visited_array,
                               index + 1):  # index+1 to go to the next letter of word
                return True  # if the word if=s found it returns true
        visited_array[i][
            j] = False  # this when any other point where the search begins , then this is taken as unvisited array
        return False






