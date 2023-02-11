package LList;

public class LinkList<T> implements List<T> {
    private Node<T> head;
    private int size;

    private class Node<T> {
        public T value;                       //telo info
        public Node next;
        public Node prev;

        public Node(T value) {
            this.value = value;
            next = null;
        }

        public Node(int ind) {
        }
    }

    @Override   //RABOT
    public void add(T elem) {
        Node<T> tNode = new Node<>(elem);
        if (size == 0) {
            head = tNode;           //esli pustoy
            tNode.next = null;
            tNode.prev = head;
            size++;
        } else {
            Node<T> vst = head;
            while (vst.next != null) {
                vst = vst.next;
            }
            vst.next = tNode;         //esli poln
            tNode.prev = head;
            size++;
        }
    }

    @Override             //RABOT
    public void add(T elem, int ind) {
        if (ind > size + 1) {
            System.out.println("Индекс вышел c размера add ");
        }
        if (ind == 0 && size == 0) {                 //RABOT
            Node<T> tNode = new Node<T>(elem);       //esli pystoi
            head = tNode;
            tNode.prev = head;
            tNode.next = null;
            size++;
            return;
        }
        if (ind == 0 && size > 0) {                   //RABOT
            Node<T> tNode = new Node<>(elem);       //v nach esli poln
            Node<T> vrem = head;
            head = tNode;
            tNode.next = vrem;
            tNode.prev = null;
            size++;
            return;
        }
        if (ind > 0 && ind == size) {                      //RABOT
            Node<T> tNode = new Node<>(elem);         //vstavka v sered
            Node<T> vrem = head;
            for (int i = 0; i < ind - 1; i++) {
                vrem = vrem.next;
            }
            tNode.next = vrem.next;
            vrem.next = tNode;
            tNode.prev = vrem;
            size++;
            return;
        }
        if (ind > 0 && ind == size + 1) {                 //RABOT
            Node<T> tNode = new Node<>(elem);      //esli v konec
            Node<T> vrem = head;
            for (int i = 0; i < size - 1; i++) {
                vrem = vrem.next;
            }
            vrem.next = tNode;
            tNode.next = null;
            tNode.prev = vrem;
            size++;
            return;
        }
    }

    @Override   //RABOT
    public int size() {
        //RABOT
        return size;
    }

    @Override
    public T get(int ind) {         //RABOT
        if (ind > size) {
            System.out.println("Нет этого индекса (ошибка из get)");
            return null;
        }
        Node<T> vst = head;
        for (int i = 0; i < ind; i++) {
            vst = vst.next;
        }
        return vst.value;
    }

    @Override
    public void remove(int ind) {
        if (ind == size && size == 1) {
            System.out.println("Esli size 1 to tam legit element po 0 index");
            return;
        }
        if (ind > size) {
            System.out.println("index vne zon remove po ind");
            return;
        }
        if (size == 1 && ind == 0) {
            Node<T> vr = head;                   //RABOT
            vr.next = null;                       //ind 0 //esli size 1
            vr.prev = null;
            size--;
            return;
        }
        if (ind < size - 1 && ind > 0 && size > 3) {
            Node<T> pr = head;                     //RABOT
            Node<T> nx = head;
            for (int i = 0; i < ind + 1; i++) {       //mnogo data s sered
                if (i < ind - 1) {
                    pr = pr.next;
                }
                nx = nx.next;
            }
            pr.next = nx;
            nx.prev = pr;
            size--;
            return;
        }
        if (ind < size - 1 && ind > 0 && size > 2) {
            Node<T> pr = head;                     //RABOT +- razm3
            Node<T> nx = head;
            for (int i = 0; i < ind + 1; i++) {       //mnogo data s sered
                nx = nx.next;
            }
            pr.next = nx;
            nx.prev = pr;
            size--;
            return;
        }
        if (ind > 0 && ind < size) {      //RABOT
            Node<T> vr = head;               //mnogo data posled ind
            if (size > 2) {
                for (int i = 1; i < size - 1; i++) {
                    vr = vr.next;
                }                                              //2 i>
                vr.next = null;
                size--;
                return;
            } else {                 //2
                vr.next = null;
                size--;
                return;
            }
        }
        if (ind == 0 && size > 1) {        //RABOT
            Node<T> vr = head;            //mnogo  data ind 0
            head = vr.next;
            head.prev = null;
            size--;
        }
    }

    @Override
    public void remove() {             //RABOT

        if (size == 0) {
            System.out.println("Лист пустой  Remove ");
            return;
        }
        if (size == 1) {
            head.next = null;
            head.prev = null;
            size--;
            return;
        }
        if (size > 1) {
            Node<T> vr = head;
            for (int i = 1; i < size - 1; i++) {
                vr = vr.next;
            }
            vr.next = null;
            size--;
        }
    }

    @Override
    public T set(int ind, T elem) {      //RABOT
        T rez = null;
        if (ind > size) {
            System.out.println("Индекс большой лист маленький (ошибка из set)");
            return rez;
        } else {
            Node<T> vrem = head;
            for (int i = 0; i < ind; i++) {
                vrem = vrem.next;
            }
            vrem.value = elem;
            rez = (T) vrem.value;
        }
        return rez;
    }

    @Override           //RABOT
    public void print() {
        if (size == 0) {
            System.out.println(" list pustoi Print");
            return;
        }                                                   //RABOT
        Node<T> tek = head;
        while (tek != null) {
            System.out.print(tek.value + "   ");
            tek = tek.next;
        }
        System.out.println('\n');
    }
}
