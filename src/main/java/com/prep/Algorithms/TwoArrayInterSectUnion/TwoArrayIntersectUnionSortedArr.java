package com.prep.Algorithms.TwoArrayInterSectUnion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Given two sorted arrays, find their union and intersection.
 * Input : arr1[] = {1, 3, 4, 5, 7}
           arr2[] = {2, 3, 5, 6} 
  Output : Union : {1, 2, 3, 4, 5, 6, 7} 
           Intersection : {3, 5}
 * 
 */
public class TwoArrayIntersectUnionSortedArr {
	
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {7, 1, 5, 2, 3};//{1, 3, 4, 5, 7};
    	Integer[] arr2 = new Integer[] {3, 8, 6, 20, 7};
    	
    	Integer[] intersectionArr = getIntesection(arr1, arr2);
    	
    	Integer[] unionArr = getUnion(arr1, arr2);
    	
    	System.out.println("Union : " + Arrays.asList(unionArr));
    	System.out.println("Intersection : " + Arrays.asList(intersectionArr));
    }

	private static Integer[] getUnion(Integer[] arr1, Integer[] arr2) {
		int arr1Pointer = 0;
		int arr2Pointer = 0;
		int unionArrPointer = 0;
		
		if(null == arr1) {
			return arr2;
		}
		if(null == arr2) {
			 return arr1;
		}

		int arr1Length = arr1.length;
		int arr2Length = arr2.length;
		Integer[] unionArr = new Integer[arr1Length + arr2Length];
		
		while(arr1Pointer < arr1Length && arr2Pointer < arr2Length) {
			int arr1Element = arr1[arr1Pointer];
			int arr2Element = arr2[arr2Pointer];
			
			if(arr1Element < arr2Element) {
				unionArr[unionArrPointer] = arr1Element;
				arr1Pointer++;
			} else if(arr1Element == arr2Element) {
				unionArr[unionArrPointer] = arr1Element;
				arr1Pointer++;
				arr2Pointer++;
				
			} else {
				unionArr[unionArrPointer] = arr2Element;
				arr2Pointer++;
			}
			
			unionArrPointer++;
		}
		
		if(arr1Pointer < arr1Length) {
			while(arr1Pointer < arr1Length) {
				unionArr[unionArrPointer++] = arr1[arr1Pointer];
				arr1Pointer++;
			}
		}
		
		if(arr2Pointer < arr2Length) {
			while(arr2Pointer < arr2Length) {
				unionArr[unionArrPointer] = arr2[arr2Pointer];
				arr2Pointer++;
			}
		}
		
		System.out.println("Union operation completed !! " + unionArr);
		return unionArr;
		
	}

	private static Integer[] getIntesection(Integer[] arr1, Integer[] arr2) {
		Map<Integer, Integer> arr1Map = new HashMap<>();
		Integer[] intersectionArr = new Integer[arr1.length + arr2.length];
		int index = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			arr1Map.put(arr1[i], i);
		}
		
		for(int j = 0; j < arr2.length; j++) {
			Integer mapElement = arr1Map.get(arr2[j]);
			if(null != mapElement) {
				intersectionArr[index++] = arr1[mapElement];
			}
		}
		return intersectionArr;
	}
}
