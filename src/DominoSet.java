//Класс набора домино из 28 костей с уникальным номером
import java.util.Random;
public class DominoSet {
    private final Domino[] set; //Переменная под массив костей
    public DominoSet() { //Конструктор, создаёт набор домино
        int i; //Счетчик номера домино в наборе
        set = new Domino[28]; //Массив объектов домино, т.е. набор
        for(i = 0; i < set.length; i++)
            set[i] = new Domino(i);
    }
    public void print() { //Выводит кости из набора в строчку
        for(Domino d : set)
            d.print();
        System.out.println();
    }
    public Domino[] getSet() { //Возвращает набор-массив костей
        return set;
    }
    public void ranDom(Sequence seq) { //Заполняет последовательность, вытягивая рандомную кость из набора,
        //в параметре передаём последовательность для заполнения
        int n; //Номер рандомно взятого домино из набора
        int i = 0; //Счетчик, сколько уже домино было добавлено из набора в последовательность
        Random r = new Random(); //Рандомное число
        while (i < set.length) { //Берём рандомную кость из набора, если она ещё не вытаскивалась, добавляем её
            //в последовательность, повторяем пока не будет добавлена каждая кость
            n = r.nextInt(28);
            if (set[n].getNext() == -1) {
                seq.add(set[n]);
                i++;
            }
        }
    }
}