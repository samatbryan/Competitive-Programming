t = int(input())


for i in range(1, t + 1):
    N, R, C, SR, SC = [int(s) for s in input().split(" ")]
    instructions = input()
    SR = SR-1
    SC = SC-1
    dict = {}
    dict[(SR,SC)] = 1
    for ins in instructions:
        if(ins=='N'):
            while((SR,SC) in dict):
                SR-=1
        if(ins=='S'):
            while((SR,SC) in dict):
                SR+=1
        if(ins=='E'):
            while((SR,SC) in dict):
                SC+=1
        if(ins=='W'):
            while((SR,SC) in dict):
                SC-=1
        dict[(SR,SC)] = 1

    print("Case #{}: {} {}".format(i, SR+1, SC+1))
