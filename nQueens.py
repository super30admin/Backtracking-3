# TC: O(n!)
# SC: O(n) auxiliary
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res=[]
        rdiag=set()
        ldiag=set()
        cols=set()
        path=[]
        count=n
        def helper(n,row,path,count,rdiag,ldiag,cols,res):
            #base
            if row==n and count==0:
                res.append(path.copy())
            #logic
            for i in range(n):
                if (i in cols) or (row+i in rdiag) or (row-i in ldiag):
                    continue
                
                #action
                path.append(i)
                cols.add(i)
                rdiag.add(row+i)
                ldiag.add(row-i)
                #recurse
                helper(n,row+1,path,count-1,rdiag,ldiag,cols,res)
                #backtrack
                path.pop()
                cols.remove(i)
                rdiag.remove(row+i)
                ldiag.remove(row-i)
        
        helper(n,0,path,count,rdiag,ldiag,cols,res)

        #building string chessboard
        result=[]
        for board in res:
            brd=[]
            for col in board:
                row_str=""
                for i in range(n):
                    if i==col:
                        row_str+='Q'
                    else:
                        row_str+='.'
                brd.append(row_str)
            result.append(brd)


        return result


                


