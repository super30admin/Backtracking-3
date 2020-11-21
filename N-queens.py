class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """

        def issafe(row, i):
            for j in range(row):
                if board[j][i] == 1:
                    return False
            k = i
            l = row
            while k >= 0 and l >= 0:

                if board[l][k] == 1:
                    return False
                k -= 1
                l -= 1
            k = i
            l = row
            while k < n and l >= 0:
                # print(k,l,n)
                if board[l][k] == 1:
                    return False
                k += 1
                l -= 1
            return True

        def backtrack(row):
            # print(row)
            # print(n)
            if row == n:
                li = []
                for a in range(len(board)):
                    s = ''
                    for b in range(len(board[0])):
                        if board[a][b] == 1:
                            s += 'Q'
                        else:
                            s += '.'
                    # print(s)
                    li.append(s)
                result.append(list(li))

            for i in range(n):
                # action
                if issafe(row, i):
                    board[row][i] = 1
                    # recurse
                    backtrack(row + 1)
                    # backtrack
                    board[row][i] = 0

        result = []
        board = []
        for i in range(n):
            board.append([])
            for j in range(n):
                board[i].append(0)
        #         print(board)

        #         board[1][1]=1
        # print(board)
        backtrack(0)
        return result

        # time -O(n!) space=n**2-board| li in result = so thats the output
