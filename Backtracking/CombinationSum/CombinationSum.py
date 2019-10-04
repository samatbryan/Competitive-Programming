res = []


def backtrack(candidates, target, index, end, sum, tmp):
    global res

    if sum == target:
        cpy = []
        for i in range(len(tmp)):
            cpy.append(tmp[i])
        res.append(cpy)
        return
    if sum>target:
        return
    for i in range(0,end-index):
        tmp.append(candidates[index+i])
        backtrack(candidates, target, index+i, end, sum+candidates[index+i], tmp)
        tmp.pop()

def combinationSum(candidates, target):
    backtrack(candidates,target,0,len(candidates), 0, [])
    global res
    return res


x = combinationSum([1,2,3],10)
print(x)

1 + 3
2 + 2
