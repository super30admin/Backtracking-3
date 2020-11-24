// Time Complexity : O(n!)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create a board to mark positions
call recursive with 0 index

in recursive
base case: if index is n
create string for each level by appending . for each 0 board value and Q for 1 value
append all to temp array and then to result

logic
for each row
check if current index and i are safe
if so set board at current position to 1
recursively call for next row
set board value to 0 again

is safe function check if any previous row same column is 1 then return false
check above diagonals have 1 then return false
*/
package main

import "fmt"

var res [][]string
var board [][]int
func solveNQueens(n int) [][]string {
	res = [][]string{}
	board = make([][]int, n)
	for i := 0; i<n;i++ {
		board[i] = make([]int, n)
	}

	h(n, 0)
	return res
}

func h(n int, index int) {
	if index == n {
		temp := []string{}
		for y:=0;y<n;y++ {
			s := ""
			for z :=0;z<n;z++ {
				if board[y][z] == 0 {
					s += "."
				} else {
					s += "Q"
				}
			}
			temp = append(temp, s)
		}
		res = append(res, temp)
		return
	}

	for i:=0; i<n;i++ {
		if isSafe(n, index, i) {
			board[index][i] = 1
			h(n, index + 1)
			board[index][i] = 0
		}
	}
}

func isSafe(n int, index int, i int) bool {
	for x := 0; x<= index;x++ {
		if board[x][i] == 1 {
			return false
		}
	}

	x := index
	y := i
	for x >= 0 && y >= 0 {
		if board[x][y] == 1 {
			return false
		}
		x--
		y--
	}
	x = index
	y = i
	for x >= 0 && y < n {
		if board[x][y] == 1 {
			return false
		}
		x--
		y++
	}
	return true
}

func MainNQueen() {
	fmt.Println(solveNQueens(4)) //expected [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
}
