class Solution {
    vector<pair<int,int>>directions{{-1,0},{0,-1},{1,0},{0,1}};
    bool flag = false;

private:
    void DFS(vector<vector<char>>& board,int r , int c, int index,string word)
    {
        
        // check if the next letter exist
        if(r < 0 || c < 0 || r >= board.size() || c >= board[0].size() || board[r][c] != word[index]) 
            return;
        //base case
        if(index == word.size()-1)
        {
            flag = true;
            return;
        }            
        //logic
        // go for all the neighbouring nodes
        char temp = board[r][c];
        board[r][c] = '#'; //visited
        index++;
        for(auto [dr,dc] : directions)
        {
            int new_r = r + dr;
            int new_c = c + dc;
            DFS(board,new_r,new_c,index,word);
        }
        board[r][c] = temp;
        return;
    }
public:
    bool exist(vector<vector<char>>& board, string word) {
        // iterate throough each char inside the board and match it with the frist
        for(int i = 0 ; i < board.size(); i++)
        {
            for(int j = 0 ; j < board[0].size(); j++)
            {
                if(board[i][j] == word[0])
                    DFS(board,i,j,0,word);
            }
        }
        return flag;
    }
};

// Time complexity O(mxn) here we are also exploring the 4 directions so for the length of word at each char it will do 4 iteration so 4x4x4x4.. 4^l so the final TC : 4^lxmxn
//space complexity O(L)