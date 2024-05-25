package ua.com.alevel;

import java.util.Arrays;

public class MatList<E extends Number> {
    private E[] numbers;
    int size;
    public MatList() {
        clear();
    }

    public MatList(E[] ... n) {
        this();
        for (E[] current : n) {
            add(current);
        }
    }

    public MatList(MatList ... n) {
        this();
        join(n);
    }

    public void add(E n) {
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] != null) {
                numbers[i] = n;
                size++;
                break;
            }
        }
    }

    public void add (E ... n) {
        for (E current : n) {
            add(current);
        }
    }

    public void join (MatList<E> ... ml) {
        for (MatList<E> currentMatList : ml) {
            add((E[])currentMatList.toArray());
        }
    }

    public void intersection (MatList<E> ... ml) {
        for (MatList<E> currentML : ml) {
            if(currentML.numbers.length > size) size = currentML.numbers.length;
        }
        E[] tempNumbers = numbers;
        clear();

        for (E number : tempNumbers) {
            boolean isInAllList = true;
            for (MatList<E> list : ml) {
                if(!list.contains((E) number)){
                    isInAllList = false;
                    break;
                }
                if(isInAllList) {
                    add(number);
                }
            }
        }
    }

    private boolean contains(E number) {
        for (E currentNumber : numbers) {
            if (currentNumber.equals(number)) {
                return true;
            }
        }
        return false;
    }

    public void sortDesc() {
        E temp;
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = numbers.length-1; j > 0; j--) {
                if(numbers[j].intValue() > numbers[i].intValue()) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public void sortDesc(int firstNumber, int lastNumber) {
        E temp;
        for (int i = firstNumber; i < lastNumber; i++) {
            for (int j = lastNumber; j > firstNumber; j--) {
                if(numbers[j].intValue() > numbers[i].intValue()) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public void sortDesc(int number) {
        E temp;
        for (int i = number; i < numbers.length-1; i++) {
            for (int j = numbers.length-1; j > number; j--) {
                if(numbers[j].intValue() > numbers[i].intValue()) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public void sortAsc() {
        E temp;
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = numbers.length-1; j > 0; j--) {
                if(numbers[j].intValue() < numbers[i].intValue()) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public void sortAsc(int firstNumber, int lastNumber) {
        E temp;
        for (int i = firstNumber; i < lastNumber; i++) {
            for (int j = lastNumber; j > firstNumber; j--) {
                if(numbers[j].intValue() < numbers[i].intValue()) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public void sortAsc(int number) {
        E temp;
        for (int i = number; i < numbers.length-1; i++) {
            for (int j = numbers.length-1; j > number; j--) {
                if(numbers[j].intValue() < numbers[i].intValue()) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public Number get(int count) {
        return numbers[count];
    }

    public Number getMax() {
        Number max = numbers[0];
        for (Number current : numbers) {
            if ((int)max < (int)current) max = current;
        }
        return max;
    }

    public Number getMin() {
        Number max = numbers[0];
        for (Number current : numbers) {
            if ((int)max > (int)current) max = current;
        }
        return max;
    }

    public Number getAverage() {
        int avarage = 0;
        for (Number current : numbers) {
            avarage += (int) current;
        }
        return avarage/size;
    }

    public Number getMedian() {
        Number median = 0;
        if(size%2==1) median = get(size/2 + 1);
        else median = get(size / 2).doubleValue() + 0.5;

        return median;
    }

    public E[] toArray() {
        E[] array = Arrays.copyOfRange(numbers, 0, size);
        return array;
    }

    public E[] toArray(int firstIndex, int lastIndex) {
        E[] array = Arrays.copyOfRange(numbers, firstIndex, lastIndex);
        return array;
    }

    public void clear() {
        numbers = (E[]) new Number[10];
        size = 0;
    }

    public MatList<E> cut(int firstIndex, int lastIndex){
        int size = lastIndex - firstIndex + 1;
        E[] newNumbers = (E[]) new Number[size];
        for (int i = 0; i < size; i++) {
            newNumbers[i] = numbers[firstIndex + i];
        }
        MatList<E> newList = new MatList<>();
        newList.numbers = newNumbers;
        newList.size = size;
        return newList;
    }

    public void clear(Number[] number) {
        int newSize = 0;
        E[] newNumbers = (E[]) new Number[size];
        for (Number list : numbers) {
            boolean found = false;
            for (Number check : number) {
                if(list.equals(check)) found = true;
            }
            if(!found) {
                newNumbers[newSize] = (E) list;
                newSize++;
            }
        }
        size = newSize;
        numbers = newNumbers;
    }
}