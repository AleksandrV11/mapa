package TreeZad;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree<T extends Comparable<T>> implements myTree<T> {

    Node<T> root;

    private class Node<T> {
        T elem;
        Node<T> left = null;
        Node<T> right = null;


        public Node(T elem, Node left, Node right) {
            this.elem = elem;
            this.left = left;
            this.right = right;
        }

        public Node(T root) {
            this.elem = root;
        }


    }

    @Override
    public void add(T elem) {
        if (root == null) {             //Если дерево пустое то ложим первый елем
            root = new Node<>(elem);
        } else {
            addRab(root, elem);     // запускаем метод добавления с 2 го елемента
        }
    }


    private void addRab(Node<T> tek, T elem) {
        if (elem.compareTo(tek.elem) < 0) {         //уходим в лево
            if (tek.left == null) {
                tek.left = new Node(elem);
            } else {
                addRab(tek.left, elem);
            }
        }
        if (elem.compareTo(tek.elem) > 0) {         //уходим в право
            if (tek.right == null) {
                tek.right = new Node(elem);
            } else {
                addRab(tek.right, elem);
            }
        }
    }

    private Node delElem(T key) {                        //ищем удал елем

        Node<T> dell = root;
        while (dell != null) {
            if (key.compareTo(dell.elem) < 0) {       //уходим в лево
                dell = dell.left;
            }
            if (key.compareTo(dell.elem) > 0) {         //уходим в право
                dell = dell.right;
            }
            if (key.compareTo(dell.elem) == 0) {         //возвращ елем
                return dell;
            }
        }
        return null;
    }

    private Node rodElem(T key) {     //ищем родителя удал елем

        Node<T> rodDel = root;
        Node<T> dell = root;
        while (dell != null) {

            if (key.compareTo(dell.elem) < 0) {         //уходим в лево
                rodDel = dell;
                dell = dell.left;
            }
            if (key.compareTo(dell.elem) > 0) {         //уходим в право
                rodDel = dell;
                dell = dell.right;
            }
            if (key.compareTo(dell.elem) == 0) {         //возвращ родит елем
                return rodDel;
            }
        }
        return null;
    }

    public void del(T key) {
        //  T elem = key;
        Node<T> rod = rodElem(key);
        Node<T> elDel = delElem(key);

        if (key.compareTo(root.elem) == 0) {          //если удаляемый елемент корень
            root = null;
        }
        //если у родителя два наследн и удаляем листья
        if (elDel.left == null && elDel.right == null) {
            if (rod.left != null && rod.right != null) {  //у род 2 наследн
                del1(key);
                return;
            }
            //если у родителя один наследн
            if (rod.left != null && rod.right == null) {  //удал елем с лево
                rod.left = null;
            }
            if (rod.left == null && rod.right != null) {  //удал елем с право
                rod.right = null;
            }
            return;
        }
        //  удал промежеточн елем с одним потомком
        if (rod.left != null || rod.right != null) {
            if (elDel.left == null && elDel.right != null) {
                del2(key);
                return;
            }
            if (elDel.left != null && elDel.right == null) {
                del2(key);
                return;
            }
        }
        if (elDel.left != null && elDel.right != null) { //если у удал елем есть два наследн
            del3(key);
        }
    }

    private void del1(T key) {           //удаление листьев
        Node<T> pred = rodElem(key);
        if (pred.left.elem == key) {
            pred.left = null;
        } else {
            pred.right = null;
        }
    }

    // рred-предидущий удалению(родитель)   elDel-удаляемый элем-
    private void del2(T key) {      //удаление промеж узла с одним потомком
        Node<T> pred = rodElem(key);
        Node<T> elDel = delElem(key);
        if (pred.left == elDel) {               //удаляемый элемент с лево от родителя
            if (elDel.left == null) {            //у удаляемого есть только правый наследник
                pred.left = elDel.right;       // тогда цепляем правого
            }
            if (elDel.right == null) {       //у удаляемого есть только левый наследник
                pred.left = elDel.left;       // тогда цепляем левого
            }
        }
        if (pred.right == elDel) {               //удаляемый элемент с права от родителя
            if (elDel.left == null) {        //у удаляемого есть только правый наследник
                pred.right = elDel.right;     // тогда цепляем правого
            }
            if (elDel.right == null) {    //у удаляемого есть только левый наследник
                pred.right = elDel.left;     // тогда цепляем левого
            }
        }
    }

    private void del3(T key) {   //удаление промеж узла с двумя потомками

        Node<T> pred = rodElem(key);
        Node<T> elDel = delElem(key);
        Node<T> pr = elDel.right;
        Node<T> sr;
        Node<T> prNasl;

        if (pr.left != null) {              //если у  pr есть лев  наследн
            sr = minim(pr);     // уже есть елемент для вставки
            prNasl = prNasl(pr);
            // надо определить с какой сторон удаляем елем от Р
            if (pred.elem.compareTo(key) > 0) {  // елем с лево
                //если вставка листовая
                if (sr.right == null) {    //если предидущий перед переносимым имеет левого наследника
                    prNasl.left = null;
                    sr.right = pr; //прикручив вставки прав поддерево
                    sr.left = elDel.left;// прикрутили лев часть от удаляем елемк вставки
                    pred.left = sr;   //прикруч миним к предку
                    return;
                } else {
                    prNasl.left = sr.right; //прикруч к предидущ вставки ,прав поддерево
                    sr.right = pr;
                    sr.left = elDel.left;// прикрутили лев часть от удаляем елемк вставки
                    pred.left = sr;   //прикруч миним к предку
                    return;
                }
            }
            if (pred.elem.compareTo(key) < 0) {  // елем с право
                //если вставка листовая
                if (sr.right == null) {    //если предидущий перед переносимым имеет правого наследника
                    prNasl.left = null;
                    sr.right = pr; //прикручив вставки прав поддерево
                    sr.left = elDel.left;// прикрутили лев часть от удаляем елемк вставки
                    pred.right = sr;   //прикруч миним к предку
                    return;
                } else {
                    prNasl.left = sr.right; //прикруч к предидущ вставки ,прав поддерево
                    sr.right = pr;
                    sr.left = elDel.left;// прикрутили лев часть от удаляем елемк вставки
                    pred.left = sr;   //прикруч миним к предку

                }
            }
        }
        //  если наследник правого потомка ==null
        if (pr.left == null) {
            if (pred.elem.compareTo(key) < 0) {  // елем с право от предка
                pr.left = elDel.left;                //к прав ветки удал елемента цепляем левую ветку елемента
                pred.right = pr;              //обходим удаляемый елемент
            }
            if (pred.elem.compareTo(key) > 0) {   //елемент с лево от предка
                pr.left = elDel.left;                  //к прав ветки удал елемента цепляем левую ветку елемен
                pred.left = pr;                    //обходим удаляемый елемент
            }
        }
    }

    private Node minim(Node<T> tek) {  //наход миним

        while (tek.left != null) {  //цикл пока есть лев наследн
            tek = tek.left;
            minim(tek);     //замена на существующий наследник
        }
        return tek;
    }


    private Node prNasl(Node<T> tek) {  //предидущ переносимого елем
        Node<T> vr = tek;
        while (tek.left != null) {  //цикл пока есть лев наследн
            vr = tek;
            tek = tek.left;//
            minim(tek);     //замена на существующий наследник
        }
        return vr;
    }

    @Override
    public void printTreeDepth() {    //обход в глубину РЕКУРСИВНЫЙ
        TreeDepth(root);
    }

    public void TreeDepth(Node<T> tek) {           //обход в глубину РЕКУРСИВНЫЙ
        if (tek == null) {
            return;
        }
        if (tek.left != null) {
            TreeDepth(tek.left);
        }
        System.out.print(" " + tek.elem + "    ");
        if (tek.right != null) {
            TreeDepth(tek.right);
        }
    }

    @Override
    public void printTreeWidthQueue() {           // очередь обход в ширину
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            System.out.print(" " + node.elem + "    ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    @Override
    public void printTreeDepthStack() {           // итеративн обход в глубину
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> node = stack.pop();
            System.out.print(" " + node.elem + "    ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}



