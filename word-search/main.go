package main

func exist(board [][]byte, word string) bool {
	m := len(board)    // row
	n := len(board[0]) // col
	//if len(word) == n && len(word) == m { return true }

	dir := [][]int{
		{-1, 0},
		{1, 0},
		{0, -1},
		{0, 1},
	}

	var dfs func(i int, j int, idx int) bool
	dfs = func(i int, j int, idx int) bool {
		// base
		if idx == len(word) {
			return true
		}
		// logic
		if i == m || j == n || board[i][j] != word[idx] {
			return false
		}
		tmp := board[i][j]
		board[i][j] = '.'
		for _, v := range dir {
			r := v[0]
			c := v[1]
			nr := i + r
			nc := j + c
			if nr >= 0 && nc >= 0 && nr <= m && nc <= n {
				// fmt.Println("inside if")
				ok := dfs(nr, nc, idx+1)
				if ok {
					return true
				}
			}
			// return true
		}
		board[i][j] = tmp
		// fmt.Println("returning false")
		return false
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == word[0] {
				ok := dfs(i, j, 0)
				if ok {
					return true
				}
			}
		}
	}
	return false

}
