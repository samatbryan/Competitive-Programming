def countSetBits(n):
    count = 0
    while (n):
        n &= (n-1)
        count+=1
    return count

num_to_bits=[0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4];

# Recursively get nibble of a given number
# and map them in the array
def countSetBitsR(num):
    nibble = 0;
    if(0 == num):
        return num_to_bits[0];
    nibble = num & 0xf;

    return num_to_bits[nibble] + countSetBitsR(num >> 4);

def maxXorSum(arr, n, k):
    # n must be greater than k
    window_sum = arr[0]
    for i in range(1,k):
        window_sum = window_sum^arr[i]
    if n==k:
        if(countSetBitsR(window_sum)%2==0):
            return True
        else:
            return False
    else:
        for i in range(n-k):
            window_sum = window_sum ^ arr[i] ^ arr[i + k]
            if(countSetBitsR(window_sum)%2==0):
                return True
        return False
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
    array = [int(s) for s in input().split(" ")]
    #each modification
    for modify in range(1, Q+1):
        appended = 0
        P , V = [int(s) for s in input().split(" ")]
        array[P] = V #modified the array
        maxLength = 0

        # go through each subinterval
        xors = array[0]
        for x in array:
            xors =xors^x
        for c in range(N,1,-1):
            #use sliding window
            if(maxXorSum(array,N,c)):
                case.append(c)
                appended = 1
                break
        if(appended!=1):
            case.append(0)
    print("Case #{}:".format(i), ' '.join(str(x) for x in case ))
