# Time Complexity: O(n!)
# Space Complexity: O(n^2)
class Solution:
    result = []

    #     Getting into printable form
    def getBoard(self, mat):
        m = []

        for i in mat:
            m.append(''.join(i))
        return m

    def backtrack(self, r, c, diag, adiag, mat):
        #         Base case
        if r == len(mat):
            self.result.append(self.getBoard(mat))
            return
        #         Logic
        # Iterate ove rthe couln and checking if the diagonal , anti-diagonal and col value are already present in set if not then add it to the set and call function recursively and after that update the sets by removing respective elements from sets
        for i in range(len(mat)):
            curr_diag = r - i
            curr_adiag = r + i

            if i in c or curr_diag in diag or curr_adiag in adiag:
                continue

            c.add(i)
            diag.add(curr_diag)
            adiag.add(curr_adiag)
            mat[r][i] = 'Q'

            self.backtrack(r + 1, c, diag, adiag, mat)

            c.remove(i)
            diag.remove(curr_diag)
            adiag.remove(curr_adiag)
            mat[r][i] = '.'

    #          Driver function
    # Creating the n sized matrix and pas to the backtrack function
    def solveNQueens(self, n):
        self.result = []
        mat = [['.'] * n for i in range(n)]

        self.backtrack(0, set(), set(), set(), mat)

        return self.result
