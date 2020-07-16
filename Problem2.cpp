//Time Comp: O(N*3^L)
//Space Comp: O(L)

class Solution {
public:
    int m;
    int n;
    bool exist(vector<vector<char>>& board, string word) {
        n = board.size();
        m = board.at(0).size();
        for(int i=0; i<n; i++){
            for(int j=0; j<m;j++){
                    if(dfs(board,word,i,j,0)) return true;
                }
            }
        return false;
        }
    private:
        bool dfs(vector<vector<char>>& board,string word, int i, int j, int index){
            if(i<0 || i>n-1 || j<0 || j>m-1 ||board[i][j] == '#' || board[i][j]!=word.at(index)) return false;
            if(index == word.size()-1) return true;
            
            char temp = board[i][j];
            board[i][j] = '#';
            
            auto p1 = make_pair(0,1);
            auto p2 = make_pair(0,-1);
            auto p3 = make_pair(1,0);
            auto p4 = make_pair(-1,0);
            vector<pair<int,int>> dirs{p1,p2,p3,p4};
            for(auto dir: dirs){
                int r = i + dir.first;
                int c = j + dir.second;
                if(dfs(board,word,r,c,index+1)) return true;
            }
            board[i][j] = temp;
            return false;
        }
};