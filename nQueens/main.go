package main

import "strings"

// iterate row wise and check if any column above or diagonally of that is not true
func solveNQueens(n int) [][]string {

	// generate the nxn board
	board := make([][]bool, n)
	for idx, _ := range board {
		board[idx] = make([]bool, n)
	}

	var result [][]string
	// now try placing queens
	var backtrack func(row int)
	backtrack = func(row int) {
		// base
		if row == n {
			tmp := []string{}
			for i := 0; i < n; i++ {
				tmpStr := new(strings.Builder)
				for j := 0; j < n; j++ {
					if board[i][j] == true {
						tmpStr.WriteString("Q")
					} else {
						tmpStr.WriteString(".")
					}
				}
				tmp = append(tmp, tmpStr.String())
			}
			result = append(result, tmp)
			return
		}

		//logic
		// we loop over cols, row is controlled by recursion
		for i := 0; i < n; i++ {
			if canBePlaced(row, i, board) {
				// action
				board[row][i] = true
				// recurse
				backtrack(row + 1)
				// backtrack
				board[row][i] = false
			}
		}

	}
	backtrack(0)
	return result
}

func canBePlaced(r, c int, board [][]bool) bool {
	n := len(board)
	dirs := [][]int{{-1, 0}, {-1, -1}, {-1, 1}}
	for _, dir := range dirs {
		newR := r + dir[0]
		newC := c + dir[1]
		for newR >= 0 && newR < n && newC >= 0 && newC < n {
			if board[newR][newC] == true {
				return false
			}
			// continue in the same direction as long as we are inbound
			newR = newR + dir[0]
			newC = newC + dir[1]
		}
	}
	return true
}