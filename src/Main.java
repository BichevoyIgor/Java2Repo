import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

    }

    //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public static <T> void changeElementIntArray(T[] arr, int i, int j) {
        if (i >= arr.length || j >= arr.length || i == j) {
            System.out.println("Нельзя поменять местами указанные элементы");
        } else {
            T a = arr[i];
            arr[i] = arr[j];
            arr[j] = a;
        }
    }

    //2. Написать метод, который преобразует массив в ArrayList;
    public static <T> ArrayList<T> convertToArrayList(T[] arr) {
        ArrayList<T> list = new ArrayList<>();
        Collections.addAll(list, arr);
        return list;
    }

}

//3. Большая задача:
abstract class Fruit {
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}

class Apple extends Fruit {
    public Apple(float w) {
        super(w);
    }
}

class Orange extends Fruit {
    public Orange(float w) {
        super(w);
    }
}

class Box<T extends Fruit> {
    private ArrayList<T> fruitInBox = new ArrayList<>();

    public void setCount(T fruit) {
        fruitInBox.add(fruit);
    }

    public float getWeight() {
        if (fruitInBox.size() > 0) {
            return fruitInBox.size() * fruitInBox.get(0).getWeight();
        } else return 0;
    }

    public ArrayList<T> getFruitInBox() {
        return fruitInBox;
    }

    public void addFromAnotherBox(Box<T> box) {
        fruitInBox.addAll(box.getFruitInBox());
        box.getFruitInBox().clear();
    }

    public void putToAnotherBox(Box<T> box) {
        box.addFromAnotherBox(this);
    }

    public boolean compare(Box box) {
        if (this.getWeight() - box.getWeight() == 0) {
            return true;
        } else return false;
    }
}

