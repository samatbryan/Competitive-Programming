#include <bits/stdc++.h>
using namespace std;
#define sz(a) (int)((a).size())
#define pb push_back
#define x first
#define y second

typedef long long ll;
string s[105];
int used[405];
vector<pair<int , int> > g[405] ;
int cnt0 = 0 , cnt1 = 0;
void dfs(int u , int color)
{
    used[u] = 1;
    cnt0 += color == 0;
    cnt1 += color == 1;
    for(auto v : g[u])
    {
        if(!used[v.x])
            dfs(v.x , color ^ v.y);
    }
}
int main()
{
	int T;
	cin >> T;
	for(int i = 1; i <= T; i++)
      {
        memset(used , 0 , sizeof used);
        int n;
        cin >> n;
        for(int i = 0; i < 4 * n; i++)g[i].clear();
        for(int i = 0; i < n; i++)cin >> s[i];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
            {
                int diag1 = i - j + n - 1 , diag2 = 2 * n - 1 + i + j;
                g[diag1].pb({diag2 , s[i][j] == '.'});
                g[diag2].pb({diag1 , s[i][j] == '.'});
            }
        int ans = 0;
        for(int i = 0; i < 4 * n - 2; i++)
        {
            if(!used[i])
            {
                cnt0 = cnt1 = 0;
                dfs(i , 0);
                ans += min(cnt0 , cnt1);
            }
        }
        cout << "Case #" << i << ": " << ans << endl;
    }

	return 0;
}
