package Dev;


public class Main {
    public static void main(String[] args) {
        Developer dev = new Frontender();

        // Проверяем, является ли объект dev экземпляром Frontender
        if (dev instanceof Frontender) {
            // Приводим dev к типу Frontender
            Frontender frontender = (Frontender) dev;
            // Вызываем метод front() у объекта типа Frontender
            frontender.front();
        }
    }
}

