class SlidingWindow {

    public SlidingWindow(int k) {
 	int size = 0;
	List<Integer> arr = new ArrayList<Integer>();
	int product=1;	
    }
    
    public void add(int val) {
    	if(size<3){
		arr.add(val);
		product *= val;
	}
	else{
		arr.remove(0);	
		arr.add(val);
		if(
	}
		
	}
	
	public int getProduct() {
	
	}
}
