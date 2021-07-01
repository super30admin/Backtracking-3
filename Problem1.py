# Time Complexity : O(n!)(n*n-1*n-2...*2*1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#checking all possible options 

class Solution:
    def __init__(self):
        self.paths = []
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.helper(n,[],0)
        out = []
        for i in range(len(self.paths)):
            x = []
            for j in range(n):
                b = ""
                for k in range(n):
                    if k != self.paths[i][j]:
                        b += "."
                    else:
                        b += "Q"
                x.append(b)
            out.append(x)
        print(len(self.paths))
        return out
    
    def helper(self,n,path,level):
        if level == n:
            self.paths.append(path.copy())
            return;
        
        if level == 0:
            for i in range(0,n):
                path.append(i)
                self.helper(n,path,level+1)
                path.pop()
        else:
            prev = path[len(path)-1]
            for i in range(0,n):
                if i not in path:
                    r = level - 1
                    c = i - 1
                    dont = False
                    while r >= 0 and c >= 0:
                        if path[r] == c:
                            dont = True
                            break
                        r -= 1
                        c -= 1
                    r = level - 1
                    c = i + 1
                    while r >= 0 and r < n and c < n:
                        if path[r] == c:
                            dont = True
                            break
                        r -= 1
                        c += 1
                    if dont == False:
                        path.append(i)
                        self.helper(n,path,level+1)
                        path.pop()