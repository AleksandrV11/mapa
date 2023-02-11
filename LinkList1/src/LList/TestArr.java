package LList;

public class TestArr {
    public static void main(String[] args) {

        ArrList<Integer> arrList = new ArrList<>();
        arrList.add(3);
        arrList.add(4);
        arrList.add(5);

        if (arrList.size() == 3) {
            System.out.println("Все ок");           //проверяем размер после заполнения
        } else {
            System.out.println("Натупил");
        }
        if (arrList.get(0) == 3) {                 //проверяем метод гет
            System.out.println("Все ок");
        } else {
            System.out.println("Натупил");
        }
        arrList.remove(1);
        if (arrList.size() == 2) {                    //проверяем размер после удаления
            System.out.println("Все ок");
        } else {
            System.out.println("Натупил");
        }
        if (arrList.get(1) == 5) {                 //проверяем после смещения
            System.out.println("Все ок");
        } else {
            System.out.println("Натупил");
        }
        arrList.set(1, 0);
        if (arrList.get(1) == 0) {
            System.out.println("Все ок");                    //проверяем после замены
        } else {
            System.out.println("Натупил");
        }

    }
}


