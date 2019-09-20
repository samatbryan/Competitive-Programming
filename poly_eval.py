def eval(coeff):
	res = coeff[0]
	k = 1
	for i in range(1,n):
		k*=k
		res += k*coeff[i]
	return res]
	
