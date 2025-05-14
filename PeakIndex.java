class Solution {

    int recure(int[] arr, int s, int e) {
        int mid = (s + e)/2;
        if(s >= e) return s;

        if(arr[mid] < arr[mid+1]) return recure(arr,mid+1,e);
        else return recure(arr,s,mid);

    }

    public int peakIndexInMountainArray(int[] arr) {
        // int start = 0;
        // int end = arr.length - 1;

        // while (start < end) {
        //     int mid = (start + end) / 2;

        //     if (arr[mid] < arr[mid + 1]) start = mid + 1;
        //     else end = mid;
        // }

        // return start;
        return recure(arr,0,arr.length-1);
    }
}
