Time: 2^n * n
Space: O(n)
Leetcode: https://leetcode.com/submissions/detail/586658996/

public class Solution {
    
    IList<IList<string>> result;
    
    public IList<IList<string>> Partition(string s) {
        result = new List<IList<string>>();
        
        Helper(s, new List<string>(), 0);
        return result;
    }
    
    private void Helper(string s, List<string> path, int index) {
        
        if(index == s.Length) {
            result.Add(new List<string>(path));
            return;
        }
        
        for(int i = index; i < s.Length; i++) {
            int endIndex = i;
            int startIndex = index;
            int length = endIndex - startIndex;
            string curr = s.Substring(index, length+1);
            
            if(IsPalindrome(curr)) {
                
                path.Add(curr);
                
                Helper(s, path, i+1);
                
                path.RemoveAt(path.Count - 1);
            }
            
        }
    }
    
    private bool IsPalindrome(String s){
            int i = 0;
            int j = s.Length - 1;
            while (true)
            {
                if (i > j)
                {
                    return true;
                }
                char a = s[i];
                char b = s[j];
                if (char.ToLower(a) != char.ToLower(b))
                {
                    return false;
                }
                i++;
                j--;
            }
    }
}