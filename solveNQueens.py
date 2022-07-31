# Time Complexity : O(n^2*n)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        self.backtrack(n, result, [])
        return result

    def backtrack(self, n, result, temp):
        if temp:
            for i in range(len(temp)):
                # index of the Queen, diagonal variable
                index = temp[i].index("Q")
                diag = 1

                for row in temp[i + 1:]:
                    rightDiag = index + diag
                    leftDiag = index - diag
                    # top-down
                    if row[index] == "Q":
                        return
                    # right-diagonal
                    if rightDiag < n and row[rightDiag] == "Q":
                        return
                    # left-diagonal
                    if leftDiag >= 0 and row[leftDiag] == "Q":
                        return
                    diag += 1

            if len(temp) == n:
                result.append(temp)
                return

        for i in range(n):
            row = ["." for _ in range(n)]
            row[i] = "Q"
            self.backtrack(n, result, temp + ["".join(row)])
            row[i] = "."
