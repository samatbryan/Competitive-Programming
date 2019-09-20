def inversions(n):
	res = 0
	z = len(n)-1
	while(z>0 and n[z]!=0):
		z-=1
	o = z	
	while(z>0 and o>=0):
		if(n[z]==0):
			while(o>=0 and n[o]!=1):
				o-=1
			if(o>=0):
				n[o] = 0
				n[z] = 1
				res += z-o
				o-=1
		z-=1	
	return res

th = [1,1,1]
print(inversions(th))

