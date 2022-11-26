import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //Задача на лайв-кодинг
    //Напишите метод, который возводит число в куб.
    //Задача на лайв-кодинг
    //Напишите пример перехвата и обработки исключения в секции throws-метода и передачи вызывающему методу.

    static int inCube(int number) {
        return number * number * number;
    }

    //При вызове метода могут возникнуть ошибки - ввели не число или ошибка ввода (нельзя ввести символы с клавиатуры)
    //Но здесь мы эти ошибки не обрабатываем
    //А отдаем (перебрасываем) их обработку в то место, которое вызывает данный метод
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
            //Если мы не хотим аварийно завершать работу программы (через выброс исключения),
            //то можно вывести текстовое сообщение об ошибке.
            //System.out.println("Ошибка ввода или введено не число, а текст");
        }
        System.out.println("Число " + n + " в кубе равно "  + inCube(n));
    }
}