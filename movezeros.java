class Solution {
    public void moveZeroes(int[] nums) {
        int n= nums.length;
        ArrayList< Integer> temp= new ArrayList<>(); //temporary for storage
        for(int i=0;i<n;i++){
            if(nums[i]!=0)
            temp.add(nums[i]);
        }
        int nz= temp.size(); // all non zero elemnets
         for(int i=0;i<nz;i++){
            nums[i]= temp.get(i);
         }
         for(int i=nz; i<n;i++){
            nums[i]=0;
         }   
    }
}
