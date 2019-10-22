public class Systems{
  public static double[] solveTwoEquations(double a, double b, double c, double d, double e, double f){
    double det = a*d - b*c;
    if(det ==0){
        return new double[]{-1,-1};
    }
    double x = (d*e - b*f)/det;
    double y = (a*f - c*e)/det;
    double[] res = new double[]{x,y};
    return res;
  }
}
