class Solution {

  public int[] sortArray(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
    return nums;
  }

  private void quickSort(int[] nums, int l, int h) {
    if (l < h) {
      int p = partition(nums, l, h);
      quickSort(nums, l, p - 1);
      quickSort(nums, p + 1, h);
    }

  }

  public int partition(int[] nums, int start, int stop) {

    int randomIdx = start + (int) (Math.random() * (stop - start) + 1);
    swap(nums, randomIdx, stop);
    int pivotIdx = stop;
    int pivotPosition = start;

    for (int i = start; i < stop; i++) {

      if (nums[i] < nums[pivotIdx]) {
        swap(nums, i, pivotPosition);
        pivotPosition++;
      }
    }

    swap(nums, pivotIdx, pivotPosition);
    return pivotPosition;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

}
