class Solution:
	def exist(self, board: List[List[str]], word: str) -> bool:
		# Time Complexity : O(4^mn) where m is the number of rows in the board and n is the number of columns in the board
		# For every element we have four choices(up, down, left, right) in backtracking
		rows = len(board)
		if rows == 0:
			return False
		columns = len(board[0])
		if columns == 0:
			return False
		visited = [[False for i in range(columns)] for j in range(rows)]
		for i in range(rows):
			for j in range(columns):
				if self.dfs(board, visited, word, i, j):
					return True
		return False
	
	def dfs(self, board, visited, word, i, j):
		r = len(board)
		c = len(board[0])
		# base case
		if len(word) == 0:
			return True
		if board[i][j] == word[0]:
			visited[i][j] = True
			if len(word) == 1:
				return True
			# look right
			if j < c - 1 and not visited[i][j + 1]:
				if self.dfs(board, visited, word[1:], i, j + 1):
					return True
			# look left
			if j > 0 and not visited[i][j - 1]:
				if self.dfs(board, visited, word[1:], i, j - 1):
					return True
			# look top
			if i > 0 and not visited[i - 1][j]:
				if self.dfs(board, visited, word[1:], i - 1, j):
					return True
			# look bottom
			if i < r - 1 and not visited[i + 1][j]:
				if self.dfs(board, visited, word[1:], i + 1, j):
					return True
		visited[i][j] = False
		return False