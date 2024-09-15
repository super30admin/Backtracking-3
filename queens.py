"""
Add N queens to an NxN cchess board such that no queen can kill the other

Approach : iterate over each row and add a queen by backtracting on column positions

Works on leet code : made silly mistake with the formatted function
Time complexity = O(N^N)
Space complexity =  O(N)

"""


class Solution(object):
    n = 0
    
    def is_valid(self, row, col, positions):
        
        # check if no other queen in col
        return len(filter(lambda y: (y[0] == row) or (y[1] == col) or ((y[0] - y[1]) == (row - col)) or (
            (y[0] + y[1]) == (row + col)), positions)) == 0
    
    def place_queen(self, row, col, positions):
        
        if not self.is_valid(row, col, positions):
            return []
        
        results = []
        positions += [(row, col)]
        row += 1
        
        if row >= self.n:
            results.append(positions[:])
        else:
            # valid and still not placed all queens
            
            for test_col in range(self.n):
                results += [i[:] for i in self.place_queen(row, test_col, positions)]
        
        positions.pop()
        return results
    
    def formatted(self, result_set):
        f_results = []
        for s in result_set:
            positions = dict(s)
            f_result = []
            for row in range(self.n):
                row_string = ""
                for col in range(self.n):
                    row_string += ('Q' if positions[row] == col else '.')  # mistake made here positions[row].get(coll)
                f_result += [row_string]
            f_results.append(f_result)
        return f_results
    
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        self.n = n
        result_set = []
        for test_col in range(n):
            result_set += self.place_queen(0, test_col, [])
        
        return self.formatted(result_set)


if __name__ == "__main__" :
    sol = Solution()
    print(sol.solveNQueens(4))