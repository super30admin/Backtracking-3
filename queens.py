# As taught in class, first check if it is sfe to place a queen in the row and then backtrck if lter the solution is not valid.
#Time Complexity: O(n!)
#Space Complexity: O(n)
m = 0
result = [[]]
def queens(n):
    board = [[0 for i in range(n)] for j in range(n)]
    m = n
    helper(board,m,0)
    return result

def helper(board,m,r):
    if r == m:
        temp = list()
        for i in range(m):
            st = []
            st1 = ""
            for j in range(m):
                if board[i][j] == 0:
                    st.append(".")
                    st1 = "".join(st)
                else:
                    st.append("Q")
                    st1 = "".join(st)
            temp.append(st1)
        result.append(temp)


    for i in range(m):
        if isSafe(board,m,r,i):
            board[r][i] = 1
            helper(board,m,r+1)
            board[r][i] = 0

def isSafe(board,m,r,c):
    for i in range(r):
        if board[i][c] == 1:
            return False
    i = r
    j = c
    while (i >= 0 and j >=0):
        if board[i][j] == 1:
            return False
        i = i - 1
        j = j - 1
    i = r
    j = c
    while (i >= 0 and j < m):
        if board[i][j] == 1:
            return False
        i = i - 1
        j = j + 1
    return True


n = 4
queens(n)
print(result)