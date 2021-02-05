public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"10", "5", "6", "7"},
                {"1", "3", "6", "5"},
                {"1", "1", "1", "2"},
                {"3", "2", "1", "л"}
        };

        try {
            System.out.println(arrayTest(array));
        }catch (MyArraySizeException e){
            System.err.println("Массив не верного размера");
        }catch (MyArrayDataException e){
            System.err.println(("В ячейке массива с индексом: [" + (e.getI()) + "][" + (e.getJ()) + "] хранится не число."));
        }
    }

    public static int arrayTest(String[][] array) throws MyArraySizeException, MyArrayDataException{
        int count = 0;
        if (array.length != 4) throw new MyArraySizeException();
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) throw new MyArraySizeException();
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    count += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
    return count;
    }
}