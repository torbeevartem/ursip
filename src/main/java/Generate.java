import java.util.List;

public class Generate {

/*
На вход будет переданы сущетвующие номера в виде масива целых чисел.

Необходимо вернуть номер следующего проекта, по следующей логике:
Если текущие номера проекта не содержат пропусков, то необходимо вернуть максимальный элемент + 1.
Если пропуски есть, необходимо вернуть минимальный из них.
Пропуском называется разница между номерами больше или равная единицы (f(1,3) содержит пропуск, а f(1,2) нет).
Переданные номера проектов могут дублироваться, но сгенерированный методом номер не должен повторять существующий.
Номера проектов неотрицательные.
1, 1, 2

Пример:
f(1,2,3) = 4
f(1,3) = 2
f(2) = 1

Сгенерированный номер необходимо вернуть в формате трехразрядной строки, т.е.:
f(1) = "001"
f(10) = "010"
f(100) = "100"

В реализации приветствуется функциональный стиль.
Оцениваться будет качество кода и его корректность.
Решение необходимо залить в публичный репозиторий и предоставить ссылку.
*/

    public static String generateNum(List<Integer> numbers) {

        isNull(numbers);

        if (numbers.size() == 1) {
            return checkElement(numbers);
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            int tmp1 = numbers.get(i);
            int tmp2 = numbers.get(i + 1);
            // если элемент 1,1,2 или 1,2,2
            if (tmp1 == tmp2) {
                continue;
            }
            // если пропуск в последовательности
            if (!isCompare(tmp1, tmp2)) {
                return toFormat(tmp2 - 1);
            }
        }
        // если все хорошо берём последний элемент
        int last = numbers.get(numbers.size() - 1);
        return toFormat(last + 1);
    }

    private static boolean isCompare(int arg1, int arg2) {
        return arg1 == arg2 - 1;
    }

    private static String toFormat(int arg) {
        return String.format("%03d", arg);
    }

    private static String checkElement(List<Integer> list) {
        int i = list.get(0);
        // если элемент 1 и равен 0
        if (list.get(0) == 0) {
            i = 0;
        }
        // если элемент 1 и равен 1
        if (list.get(0) == 1) {
            i = 1;
        }
        // если элемент 1 и больше чем
        if (list.get(0) > 1) {
            i = i - 1;
        }
        return toFormat(i);
    }

    private static void isNull(List<Integer> list){
        if (list == null) {
            throw new NullPointerException("List of numbers is empty");
        }
        if (list.size() == 1 && list.get(0) == null) {
            throw new NullPointerException("Element in list must not be null");
        }
    }
}

