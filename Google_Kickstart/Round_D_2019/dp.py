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
    #dp = [[0]*N]*N
    #each modification
    for modify in range(1, Q+1):
        P , V = [int(s) for s in input().split(" ")]
        array[P] = V #modified the array
        maxLength = 0

        # go through each subinterval
        for x in range(N):
            temp = x+1
            xors = array[x]
            while(temp<N):
                xors = xors^array[temp]

                if(countSetBitsR(xors)%2==0):
                    tempLength = temp-x+1
                    if(tempLength>maxLength):
                        maxLength = tempLength
                temp+=1
        case.append(maxLength)
    print("Case #{}:".format(i), ' '.join(str(x) for x in case ))
