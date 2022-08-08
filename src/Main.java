import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> arrayList = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию:");
            int operation = Integer.parseInt(scanner.nextLine());
            System.out.println("");
            Iterator<String> iterator = arrayList.iterator();
            switch (operation) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    String shopElement = scanner.nextLine();
                    arrayList.add(shopElement);
                    System.out.println("Итого в списке покупок: " + arrayList.size());
                    break;
                case 2:
                    iteratorPrint(iterator);
                    break;
                case 3:
                    iteratorPrint(iterator);
                    System.out.println("Какую хотите удалить? Введите номер или название\n");
                    String deleteElement = scanner.nextLine();
                    try {
                        int parse = Integer.parseInt(deleteElement);
                        String element = arrayList.get(parse-1);
                        arrayList.remove(parse);
                        System.out.println("Покупка " + "'" + element + "' удалена");
                    } catch (NumberFormatException e) {
                        arrayList.remove(deleteElement);
                        System.out.println("Покупка " + "'" + deleteElement + "' удалена");
                    }
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    String toFound = scanner.nextLine();
                    toFound = toFound.toLowerCase().trim();
                    System.out.println("Найдено:");
                    for (int i = 0; i < arrayList.size(); i++) {
                        String foundElement = arrayList.get(i).toLowerCase();
                        if (foundElement.contains(toFound)) {
                            System.out.println((i+1) + ". " + arrayList.get(i));
                        }
                    }
            }
        }
    }

    private static void iteratorPrint(Iterator<String> iterator) {
        int temp = 1;
        while (iterator.hasNext()) {
            System.out.println(temp + ". " + iterator.next());
            temp++;
        }
    }
}
