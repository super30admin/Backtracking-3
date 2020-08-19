#Time Complexity - O(n!)
#Space Complexity - O(n^2), n for the recursive stack and second n for each copy of path
#Works on leetcode - yes
#Approach - Here I am using "cols" to keep track of where the queen is place in which column, eg -  [1, 3, 0, 2] mean first queen is placed in column 1, 
#second queen is placed in column 3, etc. The i is the row. I use valid function to check if a queen can be placed. So, abs(nums[i]-nums[n]) is the distance between columns, and n-i is the distance between rows --> checking if on same diagonal.
#nums[i] == nums[n] checks if on same column --> we go through each row, so there is no need checking whether on the same row.
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        self.backtrack([-1]*n, 0, [],res)
        return res
    
    def backtrack(self,cols, i, path, res):
        if i==len(cols):
            #print("At : ", i,path)
            res.append(path)
            return 
        for k in range(len(cols)):
            cols[i]=k
            if self.valid(cols,i):
                temp = "."*len(cols)
                self.backtrack(cols,i+1,path+[temp[:k]+"Q"+temp[k+1:]], res)
        
    def valid(self,cols,n):
        for i in range(n):
            if  abs(cols[i]-cols[n])==n-i or cols[i]==cols[n]:
                return False
        return True