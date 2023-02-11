package LList;

public class TestList {
    public static void main(String[] args) {

        LinkList<String> list = new LinkList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("0", 0);

        if (list.size() == 4) {
            System.out.println("Все ок");           //проверяем размер после заполнения
        } else {
            System.out.println("Натупил");
        }
        if (list.get(1).equals("1")) {                 //проверяем метод гет
            System.out.println("Все ок");
        } else {
            System.out.println("Натупил");
        }
        list.remove(2);
        if (list.size() == 3) {                         //проверяем размер после удаления
            System.out.println("Все ок");
        } else {
            System.out.println("Натупил");
        }

        if (list.get(1).equals("1")) {                 //проверяем после смещения
            System.out.println("Все ок");
        } else {
            System.out.println("Натупил");
        }
        list.set(1, "0");
        if (list.get(1).equals("0")) {
            System.out.println("Все ок");                    //проверяем после замены
        } else {
            System.out.println("Натупил");
        }
        System.out.println("SIZE : " + list.size());
        list.add("55", 5);
        list.get(4);
        list.remove(4);
        list.set(4, "44");


    }
}
