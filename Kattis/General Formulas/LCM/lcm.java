// LCM of two numbers

// LCM(A,B) = A*B / GCD(A,B)
public int gcd(int a, int b){
  if(b==0){
    return a;
  }
  return(b, a%b);
}


public int lcm(int a, int b){
  return (a*b)/gcd(a, b); 
}
