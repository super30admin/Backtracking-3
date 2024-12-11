class Solution {
    vector<vector<string>>result;  
private:
    bool isSafe(vector<string>&temp , int row, int col , int size)
    {
        //check all the possibilties
        //checl the cols
        int r = row;
        int c = col;
        while(r >= 0)
        {
            if(temp[r][c] == 'Q')
                return false;
            r--;
        }
        //check the rows
        r = row;
        c = col;

        while(c >= 0)
        {
            if(temp[r][c] == 'Q')
                return false;
            c--;
        } 
        //upward diagonal
        r = row;
        c = col;
        while(r >= 0 && c >= 0)
        {
            if(temp[r][c] == 'Q')
                return false;
            r--;
            c--;
        } 
        //downward diagonal 
        r = row;
        c = col;
        while(r >= 0 && c < size)
        {
            if(temp[r][c] == 'Q')
                return false;
            r--;
            c++;
        }  
        return true;
    }
private:
    void helper(vector<string>&temp,int row, int size)
    {
        //base case
        if(row == size)
        {
            result.push_back(temp);
            return;
        }

        //logic
        for(int i = 0; i < size; i++)
        {
            if(isSafe(temp,row,i,size))
            {
                temp[row][i] = 'Q';
                helper(temp,row+1,size);
                temp[row][i] = '.';
            }
        }
    }
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<string>temp(n,string(n,'.'));
        helper(temp,0,n);
        return result;
    }
};

//Time complexity is O(n!)
// space complexity is O(N^2)