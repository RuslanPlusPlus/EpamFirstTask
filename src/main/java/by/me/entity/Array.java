package by.me.entity;

import by.me.exception.ArrayException;

public class Array {
    private int[] array;

    public Array(int[] array){
        this.array = array;
    }

    public Array(int n){
        if (n < 1) {
            throw new IllegalArgumentException("Array size cannot be less than 1");
        }
        this.array = new int[n];
    }

    public int getSize(){
        return this.array.length;
    }

    public int getElement(int i) throws ArrayException{
        if (checkRange(i)){
            return this.array[i];
        }
        else{
            throw new ArrayException();
        }
    }

    public void setElement(int i, int value) throws ArrayException{
        if (checkRange(i)){
            this.array[i] = value;
        }
        else {
            throw new ArrayException();
        }
    }

    private boolean checkRange(int i){
        return i >= 0 && i < this.array.length;
    }
}
