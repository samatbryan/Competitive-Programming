class Solution:
    def knightProbability(self, N: int, K: int, r: int, c: int) -> float:
        row = r
        col = c
        dp = [[0 for x in range(N)] for y in range(N)]
        if(K==0):
            return 1

        for r in range(N):
            for c in range(N):
                p = 0
                if(r-2>=0 and c-1>=0):
                    p+=1
                if(r-2>=0 and c+1<N):
                    p+=1
                if(r+2<N and c-1>=0):
                    p+=1
                if(r+2<N and c+1<N):
                    p+=1
                if(r-1>=0 and c+2<N):
                    p+=1
                if(r-1>=0 and c-2>=0):
                    p+=1
                if(r+1<N and c+2<N):
                    p+=1
                if(r+1<N and c-2>=0):
                    p+=1
                dp[r][c] = p

        for r in range(N):
            for c in range(N):
                print(dp[r][c])
        print("\n")
        print(dp[row][col])

        for i in range(K-1):
            dp2 = [[0 for x in range(N)] for y in range(N)]
            for r in range(N):
                for c in range(N):
                    p = 0
                    if(r-2>=0 and c-1>=0):
                        p+=dp[r-2][c-1]
                    if(r-2>=0 and c+1<N):
                        p+=dp[r-2][c+1]
                    if(r+2<N and c-1>=0):
                        p+=dp[r+2][c-1]
                    if(r+2<N and c+1<N):
                        p+=dp[r+2][c+1]
                    if(r-1>=0 and c+2<N):
                        p+=dp[r-1][c+2]
                    if(r-1>=0 and c-2>=0):
                        p+=dp[r-1][c-2]
                    if(r+1<N and c+2<N):
                        p+=dp[r+1][c+2]
                    if(r+1<N and c-2>=0):
                        p+=dp[r+1][c-2]
                    dp2[r][c] = p
            dp = dp2
        print(dp[row][col])
        const = 1
        for i in range(K):
            const *= 1/8
        return dp[row][col]*const
