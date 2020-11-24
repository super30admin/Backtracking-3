# As taught in class, I used backtracking to find the required word
# Time Complexity: exponeential
#Space Complexity: O(1) as I manipulate the saame array
def findWord(arr,word):
    m = len(arr)
    n = len(arr[0])
    for i in range(m):
        for j in range(n):
            if helper(arr,word,0,0,0):
                return True
    return False

def helper(arr,word,r,c,index):
    if index == len(word):
        return True
    if (r < 0 or r > len(arr) or c <0 or c > len(arr[0]) or arr[r][c] == "#"):
        return False
    dirs = [(0,1),(1,0),(0,-1),(-1,0)]
    if arr[r][c] == word[index]:
        temp = arr[r][c]
        arr[r][c] = "#"
        for dir in dirs:
            row = r + dir[0]
            col = c + dir[1]
            if helper(arr,word,row,col,index+1):
                return True
        arr[r][c] = temp
    return False




arr= [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
word = "ABCCED"
findWord(arr,word)