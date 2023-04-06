import java.util.Random;
import java.util.Scanner;

public class Test {
    /*
    План
    1) do-while
    2) Повторения
     */

    /*
    Теория
    Условные операторы - для управления ходом исполнения программы.
    Цикл - многократно выполнять действия

    Условные операторы:
    if-else
    switch

    Циклы:
    while
    for
    do-while

    do-while - цикл с предусловием, т.е. он будет исполнен хотя бы один раз. В любом случае будет иметь хотя бы одну итерацию

    итерация - шаг.

    do{
    Действия
    }
    while(условие);

    условие работы любого цикла - true, завершения - false;

    управляет циклом логическое выражения


    Ссылочные типы против примитивных - метод equals():

     */

    /*
    Заключение
    SOLID - аббревиатура, которая указывает на правильные принципы программирования, одним из них является антипаттерн -
    "Божественный метод" - метод, который выполняет более одной задачи - правильно делать метод, который выполняет
    всего одну задачу
    Правило:
    Одна задача - один метод.
    Это делается для достижения гибкости и читаемости кода

     */

    /*
    Задачи со звездочкой
    1) Камень, ножницы, бумага реализация через класс с возможностью выбора режима игры: создать графический интерфейс и реализовать
    сохранение(строго, если чувствуете силы)
    2) Реализовать классы для работы со списками(односвязные и двусвязные) и массивом вынести контракт на эти классы
    в абстрактный базовый класс: вставка, вставка по позиции, удаление элемента, удаление всей структуры, стирание всей структуры,
    хранить размер структуры, предусмотреть наличие возможности выводы всей инициализированной структуры и поиск элемента
    3) Создать класс Account для банковского счета для обеспечения банковских операций
     */
    static Scanner scan = new Scanner(System.in);  // Глобальный сканер
    public static void main(String[] args)  {
        /*
        Задача
        Вывести числа от 1 до 10 при помощи цикла while
         */
        int i = 1;                              // Объявляем(Декларируем) локальную переменную - итератор цикла while и инициализируем его 1
        while (i <= 10){                        // Объявили цикл while с условие работы i <= 10;
            System.out.println(i);              // Выводим итератор цикла
            i++;                                // Инкрементируем итератор цикла(увеличиваем счетчик цикла 1)
        }
        /*
        Задача
        Решить первую задачу через for
         */
        for(int j = 1; j <= 10; j++){           // Объявили цикл for c итератор j и шагов в 1(инкрементом - увеличением на 1)
            System.out.println(j);              // Выводим в консоль итератор
        }
        /*
        Задача
        Вне зависимости от условия цикла вывести на консоль - "Привет"
        Решение
        Использовать цикл do-while
         */
        do{                                   // Данный цикл сначала делает, потом думает, поэтому даже если условие false
            System.out.println("Привет");     // блок do будет хотя бы один раз выполнен
        }
        while (false);                        // Условие цикла - false, работать он не должен

        /*
        Пример когда это нужно:
        В моей практике часто приходится работать с локальными базами данных в приложениях, в Android, за запись в это
        базу данных отвечает cursor(переменная) - если записей нет, то она равна 0, поэтому работать с БД нельзя - она пустая,
        но чтобы получить доступ к cursor нужно открыть БД, в таком случае будет удобен цикл do-while - сначала открыть
        БД, а затем проверить есть ли смысл перебирать записи в ней, если cursor не равен 0, то продолжаем работу цикла
         */

        Car car1 = new Car("Tesla", "Красная", 10000);
        Car car2 = new Car("Tesla", "Красная", 10000);


        if(car1 == car2){            // car1 == car2  - сравнение ссылок
            System.out.println("Все отлично! Илон Маск не обманул");
        }
        else{
            System.out.println("Нас надули");
        }

        if(car1.equals(car2)){      // equals - сравнивает объекты по значениям
            System.out.println("Все отлично! Илон Маск не обманул");
        }
        else{
            System.out.println("Нас надули");
        }

       game();
    }

    /*
    Задача
    Реализовать многорежимную игру Камень, ножницы, бумага
    Решение
    1) Определить режим игры и заодно дать возможность пользователю, корректно выйти из приложения
     */
    public static void game()  {
        while (true){
            switch (chooseMode()){
                case 1:
                    compVScomp();
                    break;
                case 2:
                    humanVShuman();
                    break;
                case 3:
                    humanVScomp();
                    break;
                case 4:
                   System.exit(0);
                   break;
                default:
                    System.out.println("Выберете режим заново");
            }
        }
    }

    public static void compVScomp(){
        String player1 = generateComp();
        String player2 = generateComp();
        String winner = checkWinner(player1, player2);
        displayWinner(player1, player2, winner);
    }

    public static void humanVScomp(){
        String player1 = userInput();
        String player2 = generateComp();
        String winner = checkWinner(player1, player2);
        displayWinner(player1, player2, winner);
    }

    public static String generateComp(){
        Random random = new Random();
        int rand = random.nextInt(3) + 1;
        String res;
        if(rand == 1){
            res = "Камень";
        }
        else if(rand == 2){
            res = "Ножницы";
        }
        else {
            res = "Бумага";
        }
        return res;
    }

    public static void humanVShuman(){
        String player1 = userInput();
        String player2 = userInput();
        String winner = checkWinner(player1, player2);
        displayWinner(player1, player2, winner);
    }

    public static void displayWinner(String player1, String player2, String winner){
        System.out.println("Player1: " + player1 + " Player2: " + player2 + " Результат: " + winner);
    }

    public static int chooseMode(){
        System.out.println("Выберите режим:\n" +
                "1 - Игра компьютера с компьютером \n" +
                "2 - Игра человека с человеком \n" +
                "3 - Игра человека с компьютером \n" +
                "4 - Выход");
        int mode = scan.nextInt();
        return mode;
    }

    /**
     * Метод для ввода ходов пользователя
     * @return ход пользователя
     */
    public static String userInput(){
        String input = "";                                 // Декларировали локальную переменную и инициализировали ее пустой строкой
        while (true){                                      // Запускаем цикл, в котором будем проверять правильность ввода
            System.out.println("Введите свой ход: ");      // Выводим приглашение ввести пользователя
            input = scan.next();                           // Считываем ответ сканером
            if(checkInput(input)){                         // Проверяем правильный ли ввод, если нет, продолжаем спрашивать ввода,
                break;                                     // если да, прекращаем цикл
            }
        }
        return input;                                      // Возвращаем ответ
    }

    /**
     * Метод для проверки корректности ввода хода
     * @param input введенное слово
     * @return результат проверки
     */
    public static boolean checkInput(String input){
        String move = input.toLowerCase();                                   // Декларируем локальную переменную и переводим переданное значение в нижний регистр
        if(move.equals("ножницы") || move.equals("камень") || move.equals("бумага")){   // Проверяем правильный ли ввод, если правильный
            return true;                                                                // возвращаем true
        }
        return false;                                                                   // Если нет, то возвращаем false
    }

    /**
     * Метод для проверки победителя
     * @param player1 ход первого игрока
     * @param player2 ход второго игрока
     * @return результат
     */
    public static String checkWinner(String player1, String player2){
         String result = "";                                                 // Объявляем локальную переменную, в которую запишем результат игры
         if(player1.equals("Ножницы") && player2.equals("Камень")){          // Начинаем проверку ходов
             result = "Победил player2";
         }
         else if(player1.equals("Ножницы") && player2.equals("Бумага")){
             result = "Победил player1";
         }
         else if(player1.equals("Камень") && player2.equals("Ножницы")){
             result = "Победил player1";
         }
         else if(player1.equals("Камень") && player2.equals("Бумага")){
             result = "Победил player2";
         }
         else if(player1.equals("Бумага") && player2.equals("Камень")){
             result = "Победил player1";
         }
         else if(player1.equals("Бумага") && player2.equals("Ножницы")){
             result = "Победил player2";
         }
         else {
             result = "Ничья";
         }
        return result;                                                        // Возвращаем результат
    }

}
