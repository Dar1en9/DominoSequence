//Класс объекта домино
public class Domino {
    private int n, next; //n - уникальный номер домино в наборе, next - номер следующего домино в последовательности
    public Domino(int n) { //Конструктор, в параметре передаем уник. номер кости, задает домино как объект
        this.n = n;
        next = -1;
    }
    public int getN() { //Возвращает значение уникального номера заданной кости
        return n;
    }
    public void next(int next) { //В параметре передаем нужный номер кости, метод задаёт для домино номер следующего
        this.next = next;
    }
    public int getNext() { //Возвращает значение уникального номера следующей кости
        return next;
    }
    public void print() { //Выводит домино как кость с двумя числами на ней исходя из уникального номера
        System.out.print("[" + n % 7 + " | " + (n + n / 7) % 7 + "] ");
    }
}

