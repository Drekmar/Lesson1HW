package org.example;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;


/**
 * WARNING! Do not use it!
 *
 * First  try
 *
 * */
@Deprecated
public class SomeArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess {

    private Object elementData[];

    private int size;

    private static final int baseSize=20;
    private static final Object[] emptiArray={};

   // private static final int maxSize = Integer.MAX_VALUE- 8;
    public  SomeArrayList(){
    this.elementData = new Object[baseSize];

    }

    public SomeArrayList(int initSize){
        if (initSize>0){
            this.size=initSize;
            this.elementData= new Object[size];
        } else if (initSize==0) {size=0; this.elementData=emptiArray;

        }
    }
    public SomeArrayList(Object[] itemArray) {
        this.size=itemArray.length;
        this.elementData=itemArray;

    }

    public void  trimToSize(){
        if (size<elementData.length){
            if (size==0){
                elementData=emptiArray;
            } else {elementData=Arrays.copyOf(elementData,size);
            this.size=size;}
        }
    }

    public void set(Object item,int index){
        indexCheck(index);
        elementData[index]=item;



   }
    public void add(Object[] itemarray){//!!!!!!!!!!!!!!!!!!!!!!!!!1
trimToSize();
        this.size=size+itemarray.length;
        Object buff[]=new  Object[size];
        System.arraycopy(elementData,0,buff,0,elementData.length);
        System.arraycopy(itemarray,0,elementData,elementData.length,itemarray.length);
        elementData=buff;




    }

    public boolean add(Object item){
        trimToSize();
        this.size=size+1;
        Object buff[]=new  Object[size];
        System.arraycopy(elementData,0,buff,0,elementData.length);
        elementData=buff;
        emptiArray[size]=item;

   return true; }

    public void add(Object item, int index){
        indexCheck(index);

        trimToSize();
        this.size=size+1;

        Object[] left=Arrays.copyOfRange(elementData,0,index);
        Object[] right=Arrays.copyOfRange(elementData,index+1,elementData.length);
        System.arraycopy(right,0,elementData,index,right.length);
        elementData[index]=item;

    }
public void sizeCheck (int itemSize ){
    if (itemSize-elementData.length>0){}
}
    public void delete(int index){
        indexCheck(index);
        Object[] left=Arrays.copyOfRange(elementData,0,index-1);
        Object[] right=Arrays.copyOfRange(elementData,index+1,elementData.length);
        System.arraycopy(right,0,elementData,index,right.length);


    }
    private void riseSize(){


    }

    public void clear(){
        elementData=emptiArray;
    }


    @Override
    public E get(int index) {
        indexCheck(index);
        return (E) elementData[index];
    }
    private void indexCheck(int index) {
        if (index >= size || index<0 )
            throw new IndexOutOfBoundsException();
    }
    @Override
    public void forEach(Consumer<? super E> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return super.spliterator();
    }

    @Override
    public int size() {
        return size;
    }
    public boolean isEmpty() {

        if (size==0){return true;}
        else return false;
    }
    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {

        Arrays.sort(elementData);
    }
}
