class Solution {
    public int[] constructRectangle(int area) 
    { int arr[]=new int[2];
        int a=(int)Math.sqrt(area);
        arr[0]=a;arr[1]=a;int min=0;
        while(area%a!=0)
        {
            a--;
        }
        int l=area/a;
        int w=a;

        return new int[] {l,w};
        
        
    }
}