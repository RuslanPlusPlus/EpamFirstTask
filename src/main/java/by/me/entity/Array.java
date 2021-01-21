package by.me.entity;

import by.me.exception.ArrayException;

import java.util.Arrays;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array1 = (Array) o;
        if (!compareArrays(this, array1)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    private boolean compareArrays(Array array1, Array array2){
        if (array1.getSize() != array2.getSize()){
            return false;
        }
        int n = array1.getSize();
        try {
            for (int i = 0; i < n; i++) {
                if (array1.getElement(i) != array2.getElement(i)) {
                    return false;
                }
            }
        }catch (ArrayException e){

        }
        return true;
    }

    @Override
    public String toString() {
        return "Array{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
