# Time Complexity: O(N!)
# Space Complexity: O(N)
# passed Leetcode 


import copy
class Solution:
    
    def check_valid(self, queens, index):
        
        
        for i in range(len(queens)):
            
            if queens[i][0] == index[0]:
                return False
            
            if queens[i][1] == index[1]:
                return False
            
            if queens[i][0] > index[0]:
                #+1
                if queens[i][1] < index[1]:
                    #+1-1
                    
                    if queens[i][0] - index[0] == index[1] - queens[i][1]:
                        return False
                    
                else:
                    #+1+1
                    if queens[i][0] - index[0] == queens[i][1] - index[1] :
                        return False
            else:
                #-1
                if queens[i][1] < index[1]:
                    #-1 -1
                    if index[0] - queens[i][0] == index[1] - queens[i][1]:
                        return False
                else:
                    #-1+1
                    if index[0] - queens[i][0] == queens[i][1] - index[1]:
                        return False
        return True

    
    def backtrack(self, out, queens, curr_index):
        if curr_index == self.n:
            self.output.append(copy.deepcopy(out))
            return
        
        for i in range(self.n):
            
            if self.check_valid(queens, (curr_index, i)):
                curr_str = copy.deepcopy(self.str)
                curr_str[i] = "Q"
                queens.append((curr_index, i))
                out.append("".join(curr_str))
                self.backtrack(out, queens, curr_index + 1)
                out.pop()
                
                queens.pop()
                
            
    
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        self.output = []
        self.n = n
        str = ["."] * self.n
        # str = "".join(str)
        self.str = str
        self.backtrack([], [], 0)
        
        return self.output