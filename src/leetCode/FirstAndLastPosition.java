package leetCode;

public class FirstAndLastPosition {
	 public int[] searchRange(int[] nums, int target) {
	        
	        int res[]=new int[2];
	        res[0]=findStartIndex(nums,target);
	        res[1]=findEndIndex(nums,target);
	        
	        return res;
	    }

int findStartIndex(int[] nums, int target){
    int startIndex=-1;
    
    int start=0;
    int end=nums.length-1;
    while(start<=end){
        int mid=start+(end-start)/2;
        if(nums[mid]>=target){
            end=mid-1;
        }
        else{
            start=mid+1;
        }
        if(nums[mid]==target)
            startIndex=mid;
        
    }
    
    return startIndex;
}

int findEndIndex(int[] nums, int target){
    int endIndex=-1;
    
    int start=0;
    int end=nums.length-1;
    while(start<=end){
        int mid=start+(end-start)/2;
        
        if(nums[mid]<=target){
            start=mid+1;
        }
        else{
            end=mid-1;
        }
        if(nums[mid]==target)
            endIndex=mid;
    }
    
    return endIndex;
}
}
