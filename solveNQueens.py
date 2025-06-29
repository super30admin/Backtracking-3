# Time Complexity:O(N*N!)..Can do better if we use sets
# Space Complexity :O(N) recursion Stack
# Appraoch :
# There are 2 main things here one being checking if queen at postion is good ar not .This can be either done with sets or with just for loop.At start we have n possibilites to put Queen
# this gets reduced by m-2 for second and so on.every time we fix go untill end come back one time change postion and try again ..Use back tracking



class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        mat=[["." for _ in range(n)] for _ in  range(n)]
        ans=[]
        def is_safe(mat,r,c):   #[r][c]
            #going up
            for pos in range(r):
                if mat[pos][c]=="Q":return False
            #left dig
            ri,cj=r,c
            while(ri>=0 and cj>=0):
                if mat[ri][cj]=="Q":return False
                ri-=1
                cj-=1
            ri,cj=r,c
            #right dig
            while(ri>=0 and cj<n):
                if mat[ri][cj]=="Q":return False
                ri-=1
                cj+=1
            return True
        def back_helper(mat,r):  #here we know which row we are going no need to seprately itereate
            #base
            if r==n:
                temp=[]
                print(mat)
                for i in range(n):
                    temp1=""
                    for j in range(n):
                        temp1+=mat[i][j]
                    temp.append(temp1)
                ans.append(temp)
      
            #logic
            for cj in range(n):
                if is_safe(mat,r,cj):
                    mat[r][cj]="Q"
                    #recursion
                    back_helper(mat,r+1)
                    #backtrack
                    mat[r][cj]="."
        back_helper(mat,0)
        return ans
        




            



        
