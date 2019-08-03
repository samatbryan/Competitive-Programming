import psyco
psyco.full()
def countSetBits(n):

    count = 0
    while (n):
        n &= (n-1)
        count+=1

    return count
def xorsum(array, x,y):
    res = array[x]
    for i in range(x+1,y+1):
        res=res^array[i]
    return res
#start
t = int(input())
#each test case
solution = []
for i in range(1, t + 1):
    case = []
    N, Q = [int(s) for s in input().split(" ")]
    array = []
    array = [int(s) for s in input().split(" ")]
    dp = [[0]*N]*N
    #each modification
    for modify in range(1, Q+1):
        P , V = [int(s) for s in input().split(" ")]
        array[P] = V #modified the array
        maxLength = 0

        # go through each subinterval
        for x in range(N):
            for y in range(x,N):
                xors = xorsum(array,x,y)
                if(countSetBits(xors)%2==0):
                    temp = y-x+1
                    if(temp>maxLength):
                        maxLength = temp
        case.append(maxLength)
    print("Case #{}:".format(i), ' '.join(str(x) for x in case ))
