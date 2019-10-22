class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        int a = coordinates[0][0];
        int e = coordinates[0][1];
        int c = coordinates[1][0];
        int f  = coordinates[1][1];

        double[] values = solveTwoEquations(a,1,c,1,e,f);
        double m = values[0];
        double b = values[1];
        
        for(int i=2; i<coordinates.length; i++){
            if(!fitsLine(coordinates[i][0],coordinates[i][1], m,b)){
                return false;
            }
        }
        return true;

    }

    public static boolean fitsLine(double x, double y, double m, double b){
        if((m*x + b) == y){
            return true;
        }
        return false;
    }
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
