Time complexity : using dfs approach O(M*N)
Space complexity : O(M*N)

/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {
    let row = board.length;
    let col = board[0].length;
    let k=0;
    for(let i=0;i<row;i++)
    {
        for(let j=0;j<col;j++)
            {   
                
                if(visit(board,word,i,j,k,row,col))
                {
                     return true;
                }
            }
             
    }
    function visit(board,word,x,y,k,row,col)
     {  
      
      if(x<0||y<0||x>=row||y>=col || board[x][y]!==word[k])
      {
          return false;
      }
      if(k===word.length-1)
      {
          return true;
      }
      board[x][y]='*';
      if(visit(board,word,x+1,y,k+1,row,col)
      || visit(board,word,x,y+1,k+1,row,col)
      || visit(board,word,x-1,y,k+1,row,col)
      || visit(board,word,x,y-1,k+1,row,col)
      )
      return true;
      board[x][y] = word[k];
     }
    
    return false;
};