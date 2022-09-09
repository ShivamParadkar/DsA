class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        
        vector<vector<string>> ans;
        
        unordered_map<string,vector<string>> mp;
        
        for(int i=0;i<strs.size();i++){
                string mycp = strs[i];
                sort(mycp.begin(),mycp.end());
            if(mp.find(mycp)!=mp.end()){
                mp[mycp].push_back(strs[i]);
            }
            else{
                string cp = strs[i];
                sort(cp.begin(),cp.end());
                mp.insert({cp,{strs[i]}});
            }
        }
        
        for(auto x:mp){
            vector<string> res;
            // cout<<x.first<<" : ";
            for(int i=0;i<x.second.size();i++){
                // cout<<x.second[i]<<" ";
                res.push_back(x.second[i]);
            }
            // cout<<endl;
            sort(res.begin(),res.end());
            ans.push_back(res);
        }
        
        return ans;
    }
};
