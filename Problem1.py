class Solution:
	def solveNQueens(self, n: int) -> List[List[str]]:
		# Time Complexity : O(n^n) because for every queen there are n number of choices
		board = [[0 for i in range(n)] for j in range(n)]
		res = []
		self.placequeens(board, res, 0, n)
		return res
	
	def placequeens(self, board, res, r, n):
		# base case
		if r == n:
			temp = []
			for i in range(n):
				tempStr = ""
				for j in range(n):
					if board[i][j] == 1:
						tempStr += "Q"
					else:
						tempStr += "."
				temp.append(tempStr)
			res.append(temp)
			return False

		# recursive case
		for i in range(n):
			if self.issafe(board, r, i):
				board[r][i] = 1
				if self.placequeens(board, res, r + 1, n):
					return True
			board[r][i] = 0
		return False
	
	def issafe(self, board, i, j):
		# same column
		for k in range(i):
			if board[k][j] == 1:
				return False
		# left diagonal
		l = i - 1
		m = j - 1
		while l >= 0 and m >= 0:
			if board[l][m] == 1:
				return False
			l -= 1
			m -= 1
		# right diagonal
		l = i - 1
		m = j + 1
		while l >= 0 and m <= len(board) - 1:
			if board[l][m] == 1:
				return False
			l -= 1
			m += 1
		return True