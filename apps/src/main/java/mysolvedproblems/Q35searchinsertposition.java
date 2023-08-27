package mysolvedproblems;

public class Q35searchinsertposition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums= {1,2,3,5};
		int target=6;
		int temp=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==target){
				System.out.println(i);
				temp=1;
			}
		}
		if(temp==0) {
		for (int i = 0; i < nums.length; i++) {
			if(nums[i-1]<nums[i] && nums[i+1]>nums[i] && i<nums.length-1) {
				System.out.println(i);
			}
		}
		}
	}

}
