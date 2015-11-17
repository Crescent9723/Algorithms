
public class MergeSort {

	public static void main(String[] args) {
		int arr[] = new int[]{2, 4, 30, 10, 3, 5, 1, 100, 50, 20};
		
		mergeSort(arr, new int[arr.length], arr.length);
		
		for (int sel : arr){
			System.out.println(sel);
		}
		
	}
	
	public static void mergeSort(int num[], int temp[], int size){
		partition(num, temp, 0, size-1);
	}

	private static void partition(int[] num, int[] temp, int left, int right) {
		if (right > left){
			int mid = (left + right) / 2;
			partition(num, temp, left, mid);
			partition(num, temp, mid+1, right);
			merge(num, temp, left, mid+1, right);
		}
	}

	private static void merge(int[] num, int[] temp, int left, int mid, int right) {
		int rightStart = mid;
		int tempIndex = left;
		while ((left <= mid-1) && (rightStart <= right)){
			if (num[left] < num[rightStart]){
				temp[tempIndex] = num[left];
				tempIndex++;
				left++;
			} else {
				temp[tempIndex] = num[rightStart];
				tempIndex++;
				rightStart++;
			}
		}
		
		while (left <= mid-1){
			temp[tempIndex] = num[left];
			tempIndex++;
			left++;
		}
		while (rightStart <= right){
			temp[tempIndex] = num[rightStart];
			tempIndex++;
			rightStart++;
		}
		
		for (int i = 0 ; i <= right ; i++){
			num[i] = temp[i];
		}
	}

}
