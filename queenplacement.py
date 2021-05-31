class Solution:
    # TC: O(N!) follow the fabnocci
    # SC: O(N x N) to store the board state: matrix of size N x N.
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        board = [[0] * n for _ in range(n)]

        def issafe(board, row, cindex):

            # upperdiagnoal right
            r = row
            c = cindex
            while r >= 0 and c < n:
                if board[r][c] == 'q': return False
                r -= 1
                c += 1
            # upperdiagnoal left
            r = row
            c = cindex
            while r >= 0 and c >= 0:
                if board[r][c] == 'q': return False
                r -= 1
                c -= 1

                # check column
            for rindex in range(0, row):
                if board[rindex][cindex] == 'q': return False
            return True

        def backtrack(row):
            # base

            if row == n:
                temp_list = []
                for i in range(n):
                    curr_str = ''
                    for j in range(n):
                        if board[i][j] == 'q':
                            curr_str += 'Q'
                        else:
                            curr_str += '.'
                    temp_list.append(curr_str)
                result.append(temp_list)
                return

                # conver t the result into list

            # Logic
            for cindex in range(0, n):
                if (issafe(board, row, cindex)):
                    # action
                    board[row][cindex] = 'q'
                    # recrursive
                    backtrack(row + 1)
                    board[row][cindex] = 0

        backtrack(0)
        return result
