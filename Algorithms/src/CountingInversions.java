/*
An inversion in an array a[] is a pair of entries a[i] and a[j] such that i<j but a[i]>a[j]. 
Given an array, design a linearithmic algorithm to count the number of inversions.
*/

long merge(int[] arr, int[] left, int[] right) {
    int i = 0, j = 0, count = 0;
    while (i < left.length || j < right.length) {
        if (i == left.length) {
            arr[i+j] = right[j];
            j++;
        } else if (j == right.length) {
            arr[i+j] = left[i];
            i++;
        } else if (left[i] <= right[j]) {
            arr[i+j] = left[i];
            i++;                
        } else {
            arr[i+j] = right[j];
            //below code is added to merge sort implementation
            count += left.length-i;
            j++;
        }
    }
    return count;
}

long invCount(int[] arr) {
    if (arr.length < 2)
        return 0;

    int m = (arr.length + 1) / 2;
    int left[] = Arrays.copyOfRange(arr, 0, m);
    int right[] = Arrays.copyOfRange(arr, m, arr.length);

    return invCount(left) + invCount(right) + merge(arr, left, right);
}
