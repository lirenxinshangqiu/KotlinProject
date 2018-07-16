package com.example.main.datastructure.java.array;

/**
 * Created by ls on 18/7/16.
 */
public class Array<E> {
    private E[] data;
    private int size;//数组元素个数


    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 默认数组容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 指定位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        checkIsFull();
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("输入index有误！");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void checkIndexIsAllegal(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("输入index有误！");
        }
    }

    /**
     * 向数组第一个位置添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 获取指定索引元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        checkIndexIsAllegal(index);
        return data[index];
    }

    /**
     * 修改指定位置元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        checkIndexIsAllegal(index);
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        checkIndexIsAllegal(index);
        E ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {//防止复杂度震荡，数组容量为四分之一的时候在进行缩容
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int length = data.length;
        builder.append(String.format("Array:size = %1$d,capacity = %2$d \n", size, length));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    private void checkIsFull() {
        int length = data.length;
        if (size == length) {//如果数组容量满了，需要扩容
            resize(2 * length);
        }
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
