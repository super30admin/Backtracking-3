# tc O(n! * n^2), sc O(n^2).
colsseen = set()
posdseen = set()
negdseen = set()

def dfs(row):
    if row == n:
        res.append(["".join(row) for row in path])
        return
    
    for col in range(n):
        if col in colsseen or row+col in posdseen or row-col in negdseen:
            continue

        colsseen.add(col)
        posdseen.add(row+col)
        negdseen.add(row-col)
        path[row][col] = "Q"
        dfs(row+1)
        path[row][col] = "."
        colsseen.remove(col)
        posdseen.remove(row+col)
        negdseen.remove(row-col)

res = []
path = [["." for _ in range(n)] for _ in range(n)]
dfs(0)
return res