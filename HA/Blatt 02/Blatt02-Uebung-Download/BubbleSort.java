public class BubbleSort {
	public static void sort(int[] a) {
		int i;
		int j;
		int temp;
		for(j= a.length-1;j>0;j--){
			for (i=0;i< j;i++){
				if (a[i]>a[i+1]){
					temp=a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
				}
			}
		}
	}
}

