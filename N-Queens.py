# Time Complexity: O(n*m * 3**(n*m))
# Space Complexity: O(n)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        global result, dirs
        dirs = [[-1, -1], [-1, 0], [-1, 1]]
        matrix = [[False for i in range(n)] for j in range(n)]
        result = []

        def issafe(matrix, r, c, n):
            global dirs
            for dirr in dirs:
                nr = r + dirr[0]
                nc = c + dirr[1]
                while nr >= 0 and nc >= 0 and nr < n and nc < n:
                    if matrix[nr][nc] == True:
                        return False
                    nr += dirr[0]
                    nc += dirr[1]
            return True

        def backtrack(matrix, r, n):
            global result
            # Base Case
            if r == n:
                li = []
                for i in range(n):
                    temp = ''
                    for j in range(n):
                        if matrix[i][j] == False:
                            temp += '.'
                        else:
                            temp += 'Q'
                    li.append(temp)
                result.append(li)
                # print(li)
                # print("BREAKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK")
                # print("R is", r)
                return
            # Logic
            for c in range(n):
                # Choose
                if issafe(matrix, r, c, n):
                    # Action
                    matrix[r][c] = True
                    # Recurse
                    backtrack(matrix, r + 1, n)

                # Backtrack
                matrix[r][c] = False

        backtrack(matrix, 0, n)

        # print(matrix)
        return result
