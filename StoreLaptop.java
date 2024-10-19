import java.util.*;

public class StoreLaptop{
    public static void main(String[] args) {
        Set<Laptop> laptopSet = new HashSet<>();

        Laptop asus1 = new Laptop(4,500, "Windows", "black");
        Laptop asus2 = new Laptop(4,1000, "Windows", "black");
        Laptop lenovo1 = new Laptop(8,500, "Windows", "black");
        Laptop lenovo2 = new Laptop(8,500, "Linux", "grey");
        Laptop macbook1 = new Laptop(8,1000, "IOS", "black");
        Laptop macbook2 = new Laptop(16,1000, "IOS", "white");

        laptopSet.add(asus1);
        laptopSet.add(asus2);
        laptopSet.add(lenovo1);
        laptopSet.add(lenovo2);
        laptopSet.add(macbook1);
        laptopSet.add(macbook2);

        Scanner sc = new Scanner(System.in);

        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "RAM");
        criteria.put(2, "memoryHD");
        criteria.put(3, "OS");
        criteria.put(4, "color");
        criteria.put(0, "Выберите в случае прекращения продолжения настройки фильтра");

        Map<Integer, Object> filters = new HashMap<>();

        Set<String> laptopResult = new HashSet<>();

        boolean check = true;

        while (check) {

            System.out.println("Введите цифру, соответствующую критерию: ");
            for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

            int num = sc.nextInt();

            if (num == 0) {
                check = false;
            }

            switch (num) {
                case 1:
                    System.out.println("Введите минимальное количество оперативной памяти: _ Гб");
                    int filterRam = sc.nextInt();
                    filters.put(1, filterRam);
                    break;
                case 2:
                    System.out.println("Введите минимальное количество памяти на жестком диске: _ Гб");
                    int filterMHD = sc.nextInt();
                    filters.put(2, filterMHD);
                    break;
                case 3:
                    System.out.println("Введите желаемую операционную систему: Windows, Linux, IOS");
                    String filterOS = sc.nextLine();
                    filters.put(3, filterOS);
                    break;
                case 4:
                    System.out.println("Введите желаемый цвет ноутбука");
                    String filterColor = sc.nextLine();
                    filters.put(4, filterColor);
                    break;
                default:
                    break;
            }
        }

        if (filters.isEmpty()) {
            System.out.println("Вы не ввели ни одного критерия поиска, предлагаем весь ассортимент:");
            System.out.println(laptopSet);
        } else {
            for (Laptop laptop : laptopSet) {
                switch () {
                    case 1:
                        if (laptopSet.contains(entry.getValue())) {

                        }
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                }
            }
        }
    }
}
