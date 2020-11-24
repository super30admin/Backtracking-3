// Time Complexity : O(mn3Pow(wordlen))
// Space Complexity : O(len(word))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create dirs array for 4 directions
for each row and column call recursive with i, j, index 0
if any one is true return true

in recursive function
if index == len(word) return true
else if position out of range or value on board == # return false

if word[index] == board[i][j]
get value of board at position in a temp
for each direction call recursive again with next index and if any one is true return true
replace board at position
if none satisfy return false
*/
package main

import "fmt"

var m,n int
var dirs [][]int
func exist(board [][]byte, word string) bool {
	m = len(board)
	n = len(board[0])
	dirs = [][]int{{0,1}, {-1,0}, {0,-1}, {1,0}}
	for i:=0;i<m;i++ {
		for j:=0;j<n;j++ {
			if h1(board, word, i, j, 0) {
				return true
			}
		}
	}
	return false
}

func h1(board [][]byte, word string, i, j, index int) bool {
	if index == len(word) {
		return true
	}
	if i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#' {
		return false
	}

	if word[index] == board[i][j] {
		temp := board[i][j]
		board[i][j] = '#'
		for x:=0;x<len(dirs);x++ {
			r := i + dirs[x][0]
			c := j + dirs[x][1]
			if h1(board, word, r, c, index + 1) {
				return true
			}
		}
		board[i][j] = temp
	}
	return false
}


func MainWordSearch() {
	fmt.Println(exist([][]byte{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED")) //expected true
}
