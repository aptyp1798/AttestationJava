import java.util.*;

public class StoreLaptop{
    public static void main(String[] args){
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
        criteria.put(5, "Применить фильтры");
        criteria.put(0, "Выход");

        Map<Integer, Object> filters = new HashMap<>();

        while (true) {

            System.out.println("Текущие критерии фильтра:");
            System.out.println("RAM: " + filters.get(1));
            System.out.println("MemoryHD: " + filters.get(2));
            System.out.println("OS: " + filters.get(3));
            System.out.println("Color: " + filters.get(4) + "\n");

            System.out.println("Введите цифру, соответствующую критерию: ");
            for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

            int num = sc.nextInt();
            sc.nextLine();

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
                    System.out.println("Введите желаемый цвет ноутбука:");
                    String filterColor = sc.nextLine();
                    filters.put(4, filterColor);
                    break;
                case 5:
                    Set<Laptop> laptopResult = new HashSet<>(laptopSet);
                    sortPrintLaptop(filters, laptopSet, laptopResult);
                    System.out.println(" ");
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    public static void sortPrintLaptop(Map<Integer, Object> filters, Set<Laptop> laptopSet, Set<Laptop> laptopResult) {
        if (filters.isEmpty()) {
            System.out.println("Вы не ввели ни одного критерия поиска, предлагаем весь ассортимент:");
            System.out.println(laptopResult);
        } else {
            for (Laptop laptop : laptopSet) {
                for (Map.Entry<Integer, Object> entry : filters.entrySet()) {
                    switch (entry.getKey()) {
                        case 1:
                            if (laptop.getRam() < (int) entry.getValue()) {
                                laptopResult.remove(laptop);
                            }
                            break;
                        case 2:
                            if (laptop.getMemoryHD() < (int) entry.getValue()) {
                                laptopResult.remove(laptop);
                            }
                            break;
                        case 3:
                            if (!laptop.getOS().equals(entry.getValue())) {
                                laptopResult.remove(laptop);
                            }
                            break;
                        case 4:
                            if (!laptop.getColor().equals(entry.getValue())) {
                                laptopResult.remove(laptop);
                            }
                            break;
                    }
                }
            }
            if (laptopResult.isEmpty()) {
                System.out.println("По выбранным вами критериям подходящих ноутбуков не найдено!");
            } else {
                System.out.println("Список ноутбуков подходящие вашим критериям: " + laptopResult);
            }
        }
    }
}


