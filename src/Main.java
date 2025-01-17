/*В классическом наборе домино 28 костей. Кости представляют собой прямоугольники,
разделенные на 2 части, на каждой из них отмечены точки от 0 до 6. Каждая кость уникальна.
        Напишите программу, используя объектно-ориентированную методологию, которая создает объект
        набор домино, а затем выводит его на экран (пара целых чисел). Далее набор преобразуется в
последовательность (для каждой кости хранится местоположение следующей за ней). Для этого из
набора случайным образом выбирается кость и добавляется в конец последовательности
        (исходно последовательность пустая). Для того чтобы не проходить через всю
последовательность, при добавлении очередной кости, необходимо хранить местоположения
последней добавленной кости, для которой, в свою очередь, хранится местоположение первой.
После того как последовательность из 28 костей полностью сформирована, она выводится на
экран от первой кости последовательности до последней. Далее необходимо по заданному числу
N (задается в main()) последовательно исключить сначала кость N от начала последовательности,
потом кость N от следующей после исключенной и так далее пока из последовательности не будут
исключены все кости. При этом каждый раз на экран необходимо выводить на одной строке
исключенную на данном шаге кость, на следующей - оставшуюся после очередного исключения
последовательность от ее первой кости до последней. Если при очередном поиске исключаемой
кости дошли до конца последовательности, то поиск необходимо продолжить от начала
последовательности. Используйте для хранения набора и последовательности костей только один
массив из 28 элементов. При поиске кости и выводе на экран последовательности не должно быть
посещений исключенных из последовательности костей!
 */
public class Main {
    public static void main(String[] args) {
        int N = -1; //Каждый который элемент вытаскивается
        DominoSet set = new DominoSet(); //Объект набор
        Sequence seq = new Sequence(set); //Объект последовательность
        System.out.println("Набор:");
        set.print();
        set.ranDom(seq);
        System.out.println("Последовательность:");
        seq.print();
        System.out.println();
        excludeAll(seq, N);
    }
    public static void excludeAll(Sequence seq, int N){ //Вытаскивает домино до тех пор, пока последовательность
        //не будет пустая, в параметре передаем последовательность и каждый какой N-ный элемент вытаскиваем
        System.out.println("При N = " + N + ":");
        N--;
        int k = 28; //Кол-во оставшихся эл-тов в последовательности
        int cur = seq.getLast(); //Текущая домино, от к-ой отсчитываем следующий N-ный элемент (не считая это домино)
        Domino domino; //Переменная типа домино
        while (k != 0){ //Пока последовательность не пуста, вытаскиваем из неё домино
            domino = seq.exclude(N%(k--), cur);
            System.out.print("Вытаскиваем ");
            domino.print();
            cur = domino.getNext();
            System.out.println();
            seq.print();
        }
    }
}