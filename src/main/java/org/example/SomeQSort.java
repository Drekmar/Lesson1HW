package org.example;

import java.util.Comparator;
import java.util.List;

/**
 * The type Some q sort.
 *
 * @param <T> the type parameter
 */
/**
 * The type SomeQSort provides a QuickSort implementation for sorting lists.
 *
 * @param <T> the type parameter for elements in the list
 */
public  class SomeQSort<T> {






    /**
     * Sorts the list using QuickSort with the specified comparator.
     *
     * @param <T>        the type parameter for elements in the list
     * @param list       the list to be sorted
     * @param comparator the comparator to determine compare rules
     */
    public static  <T> void qSort(List<T> list, Comparator<T> comparator) {
        qSort(list, 0, list.size() - 1, comparator);
   }

    /**
     * Helper method to perform QuickSort on a sublist defined by low and high indices.
     *
     * @param <T>        the type parameter for elements in the list
     * @param list       the list to be sorted
     * @param low        the lower index of the sublist to be sorted
     * @param hight       the upper index of the sublist to be sorted
     * @param comparator the comparator to determine compare rules
     */
    private static  <T> void qSort(List<T> list,int low ,int hight, Comparator<T> comparator) {

            if (low<hight) {
                int splitIndex = partition(list, low, hight, comparator);
                qSort(list, low, splitIndex - 1, comparator);
                qSort(list, splitIndex + 1, hight, comparator);
            }
    }

    /**
     * Partitions the sublist into two parts and returns the index of the split element.
     *
     * @param <T>        the type parameter for elements in the list
     * @param list       the list to be partitioned
     * @param low        the lower index of the sublist to be partitioned
     * @param high       the upper index of the sublist to be partitioned
     * @param comparator the comparator to determine compare rules
     */
    private static  <T> int partition(List<T> list, int low, int high, Comparator<T> comparator) {
        T split = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), split) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }
    /**
     * Swaps the elements at the specified positions in the list.
     *
     * @param <T>  the type parameter for elements in the list
     * @param list the list in which to swap elements
     * @param i    the index of one element to be swapped
     * @param j    the index of the other element to be swapped
     */
    private static  <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}
