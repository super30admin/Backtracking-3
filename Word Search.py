#Time Complexity: O(M × N × 4^L) 
#Outer Loop: You start DFS from every cell → M × N calls.
#DFS Branching: In each DFS call, you can move in 4 directions (up, down, left, right), but you can't revisit the same cell.
#Max DFS Depth: The max depth is L (length of the word), as we stop searching when the word is matched or failed.
#Worst Case: At each level, the DFS can branch up to 4 times (except for visited cells), giving a max of 4^L combinations.

#Space Complexity: Recursive DFS Stack: At most, you'll go L levels deep in the recursive call stack (i.e., one call per character of the word). Visited Path Set: You use a path set to keep track of visited coordinates. Its max size is also L. O(L) for recursion stack + O(L) for visited set → O(L) 
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m = len(board)
        n = len(board[0])
        path = set()
        def dfs(r,c,i):
            #Base Case 1
            if(i == len(word)):
                return True
            #Base Case 2
            if(r<0 or c<0 or r>=m or c>=n or word[i]!=board[r][c] or (r,c) in path):
                return False
            #Visited Nodes Path
            path.add((r,c))
            result = (dfs(r,c+1,i+1) or dfs(r,c-1,i+1) or dfs(r+1,c,i+1) or dfs(r-1,c,i+1))
            #Remove the Node if it doesn't match the word
            path.remove((r,c))
            return result
        #Loop to start the DFS with the first character of word matching with all it's occurences in the board
        for r in range(m):
            for c in range(n):
                if(dfs(r,c,0)):
                    return True
        return False        






















        