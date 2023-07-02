public class Main {
    public static void main(String[] args) {
        int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        System.out.print("The length of the LIS is "
                + LIS(arr, 0, arr.length, Integer.MIN_VALUE));
    }

    // Функция для нахождения длины самой длинной возрастающей подпоследовательности
    public static int LIS(int[] arr, int i, int n, int prev)
    {
        // Базовый случай: ничего не осталось
        if (i == n) {
            return 0;
        }

        // случай 1: исключить текущий элемент и обработать
        // оставшиеся элементы
        int excl = LIS(arr, i + 1, n, prev);

        // случай 2: включить текущий элемент, если он больше
        // чем предыдущий элемент в LIS
        int incl = 0;
        if (arr[i] > prev) {
            incl = 1 + LIS(arr, i + 1, n, arr[i]);
        }

        // вернуть максимум из двух вышеперечисленных вариантов
        return Integer.max(incl, excl);
    }
}