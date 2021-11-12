//Leetcode: https://leetcode.com/submissions/detail/586227875/
namespace HelloWorld
{
    public class Solution {
 
        public IList<IList<string>> SolveNQueens(int n) {
            
            List<IList<string>> solutions = new List<IList<string>>();
            List<int> state = new List<int>();
            Search(state, solutions, n);
            return solutions;
        }
        
        private bool IsValidState(List<int> state, int n) {
            if(state.Count == n) {
                return true;
            }
            return false;
        }
        
        private HashSet<int> GetCandidates(List<int> state, int n){
            if (state.Count == 0)
            {
                return Enumerable.Range(0, n).ToHashSet();
            }
            int position = state.Count;
            HashSet<int> candidates = Enumerable.Range(0, n).ToHashSet();

            for (int i = 0; i < state.Count; i++)
            {
                candidates.Remove(state[i]);
                int distance = position - i;
                candidates.Remove(distance + state[i]);
                candidates.Remove(state[i] - distance);
            }

            return candidates;
        }
        
        private void Search(List<int> state, List<IList<string>> solutions, int n ){
            if(IsValidState(state, n) == true) {
                    solutions.Add(StateToString(state, n));
                }

                foreach(int candidate in GetCandidates(state, n)) {
                    state.Add(candidate);
                    Search(state, solutions, n);
                    state.Remove(candidate);
                }
        }
        
        private List<string> StateToString(List<int> state, int n)
            {
            
                List<string> str = new List<string>();
                foreach(int i in state)
                {
                    String stat = "";
                    for (int j=0; j<i; j++) {
                        stat += ".";
                    }
                    stat += "Q";
                    for (int k = 0; k < n-i-1 ; k++)
                    {
                        stat += ".";
                    }
                    str.Add(stat);
                }
                return str;
        }
        
    }
}