import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int inCube(int number) {
        return number * number * number;
    }

    //При вызове метода может возникнуть ошибка
    //Но здесь мы эту ошибку не обрабатываем
    //А отдаем (перебрасываем) ее обработку в то место, которое вызывает данный метод
    static int inputNumber() throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number;
        System.out.print("Введите число ---> ");
        number = Integer.parseInt(bufferedReader.readLine());
        return number;
    }

    public static void main(String[] args) {
        int n;
        //А вот здесь надо уже обработать возможную ошибку
        try {
            n = inputNumber();
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException("Ошибка ввода или введено не число, а текст");
        }
        System.out.println("Число " + n + " в кубе равно "  + inCube(n));
    }
}