import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка:");
        String stringSize = scanner.nextLine();
        int size = Integer.parseInt(stringSize);

        System.out.println("Введите верхнюю границу для значений:");
        String stringBound = scanner.nextLine();
        int bound = Integer.parseInt(stringBound);

        logger.log("Создаём и наполняем список");
        List<Integer> source = createList(size, bound);

        System.out.println("Вот случайный список: " + listToString(source));
        logger.log("Просим пользователя ввести входные данные для фильтрации");

        System.out.println("Введите порог для фильтра:");
        String stringThreshold = scanner.nextLine();
        int threshold = Integer.parseInt(stringThreshold);
        List<Integer> resultList = new Filter(threshold).filterOut(source);

        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + listToString(resultList));
        logger.log("Завершаем программу");
    }

    public static List<Integer> createList(int size, int bound) {

        List<Integer> source = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            source.add(random.nextInt(bound));
        }

        return source;
    }

    public static String listToString(List<Integer> source) {

        StringBuilder sb = new StringBuilder();

        for (Integer item : source) {
            sb.append(item);
            sb.append(" ");
        }

        return sb.toString();
    }
}
