// ## Problem2
// Word Search(https://leetcode.com/problems/word-search/)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : I was having trouble traversing with board and word simultaneously

var exist = function(board, word) {
    // Time Complexity :O(N∗M∗3^L) L is lenght of word
    // Space Complexity : O(1)
    let n = board.length
    let m = board[0].length
    let directions = [[-1,0], [0,1], [1,0], [0,-1]];

    function dfs(r,c,index){
        if(index == word.length){
            return true
        }
        if(r <0 || c >= m || r>=n || c<0 || board[r][c]!= word[index] || board[r][c] == "#"){
            return false
        }
        let temp = board[r][c]
        board[r][c] = "#"
        for(let [dr,dc] of directions){
            let nr = r+dr
            let nc = c+dc
            
            if(dfs(nr,nc,index+1)){
            return true
            }

            
        }
        board[r][c] = temp
        return false


    }
    for(let i=0;i<n;i++){
        for(let j=0;j<m;j++){
            if(board[i][j]==word[0]){
                //got the starting point
                //send a visted as well
                if(dfs(i,j,0)){ //! new way of calling recursivly
                    return true
                }
            }
        }
    }
    return false
};

// var exist = function(board, word) {
//     // Time Complexity :O(N∗M∗3^L) L is lenght of word
//     // Space Complexity : O(L)
//     let n = board.length
//     let m = board[0].length
//     let directions = [[-1,0], [0,1], [1,0], [0,-1]];

//     function dfs(r,c,index,visited){
//         if(index == word.length){
//             return true
//         }
//         let key = `${r},${c}`;
//         if(r <0 || c >= m || r>=n || c<0 || board[r][c]!= word[index] || visited.has(key)){
//             return false
//         }
//         visited.add(key)
//         for(let [dr,dc] of directions){
//             let nr = r+dr
//             let nc = c+dc
            
//             if(dfs(nr,nc,index+1,visited)){
//             visited.delete(key)
//             return true
//             }

            
//         }
//         visited.delete(key)
//         return false


//     }
//     for(let i=0;i<n;i++){
//         for(let j=0;j<m;j++){
//             if(board[i][j]==word[0]){
//                 //got the starting point
//                 //send a visted as well
//                 let visted = new Set()
//                 if(dfs(i,j,0,visted)){
//                     return true
//                 }
//             }
//         }
//     }
//     return false
// };