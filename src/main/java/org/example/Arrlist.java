package org.example;

import java.util.*;

/**
 * This is my version of Arraylist
 *
 * @param <E> the type elemenst in this list
 */
public class Arrlist<E> extends AbstractList<E> implements List<E>{
    /**
     * Here contains inner dada
     * */
    private Object[] contentArray;
    /**
     * This field used for size contol
     * */
    private int size;
/**
 *  Base array size
 * */
    private static final int baseSize = 20;

    /**
     *
     * */
    private static final Object[] emptyArray = {};

    /**
     * Instantiates a new Arrlist with base capasity.
     */
    public Arrlist() {
        this.contentArray = new Object[baseSize];
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Instantiates a new Arrlist with some initial capasity .
     *
     * @param initSize the initial capasity
     */
    public Arrlist(int initSize) {
        if (initSize > 0) {
            this.size = initSize;
            this.contentArray = new Object[size];
        } else if (initSize == 0) {
            size = 0;
            this.contentArray = emptyArray;
        }
    }

    /**
     * Instantiates a new Arrlist containing the elements of some array .
     *
     * @param itemArray the array whose elements are to be placed
     */
    public Arrlist(Object[] itemArray) {
        this.size = itemArray.length;
        this.contentArray = Arrays.copyOf(itemArray, size);
    }

    /**
     * Trims the capacity of this list instance to be the list's current size.
     */
    public void trimToSize() {
        if (size < contentArray.length) {
            if (size == 0) {
                contentArray = emptyArray;
            } else {
                contentArray = Arrays.copyOf(contentArray, size);
            }
        }
    }


    /**
     * Add some element to the end of this list.
     *
     * @param item element to be added
     */

    public boolean add(E item) {
        ensureCapacity(size + 1);
        contentArray[size++] = item;
        return true;
    }

    /**
     * Inserts some element at the specified position .
     *
     * @param index index at which the specified element is to be inserted
     * @param item element to be inserted
     */
    @Override
    public void add(int index, E item) {
        indexCheck(index);
        ensureCapacity(size + 1);
        System.arraycopy(contentArray, index, contentArray, index + 1, size - index);
        contentArray[index] = item;
        size++;
    }


    /**
     * Replaces the element at the specified position with the
     * specified element.
     *
     * @param index index of the element to replace
     * @param item  element to be stored at the specified position
     * @return the element previously at the specified position
     */
    public E set(int index, E item) {
        indexCheck(index);
        E oldValue =  elementData(index);
        contentArray[index] = item;
        return oldValue;
    }


    private E elementData(int index) {
        return (E) contentArray[index];
    }

    /**
     * Add all elements the of some array
     *@param items element to be added
     *
     */
    public void addAll(Object[] items) {
        ensureCapacity(size + items.length);
        System.arraycopy(items, 0, contentArray, size, items.length);
        size += items.length;
    }

    /**
     * Ensures that the array has enough capacity to hold the specified number of
     * elements.
     *
     * @param minCapacity the desired minimum capacity
     */
    public void ensureCapacity(int minCapacity) {
        if (minCapacity - contentArray.length > 0) {
            int newCapacity = Math.max(baseSize, contentArray.length * 2);
            contentArray = Arrays.copyOf(contentArray, newCapacity);
        }
    }

    /**
     *Removes the element at the specified position
     *
     * @param index the index of the element to be removed
     */
    public void delete(int index) {
        indexCheck(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(contentArray, index + 1, contentArray, index, numMoved);
        }
        contentArray[--size] = null;
    }
    /**
     * Removes all the elements from this list.
     */
    public void clear() {
        contentArray = emptyArray;
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     */
    @Override
    public E get(int index) {
        indexCheck(index);
        return (E) contentArray[index];
    }
    /**
     * Checks if the given index is in range. If not, throw a runtime exception.
     *
     * @param index the index to check
     */
    private void indexCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

}
