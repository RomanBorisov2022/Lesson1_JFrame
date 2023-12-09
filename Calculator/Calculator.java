package Calculator;

public class Calculator {

    public static <T extends Number> T sum(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        }
        throw new IllegalArgumentException("Неподдерживаемый тип данных");
    }

    public static <T extends Number> T multiply(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() * b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
        }
        throw new IllegalArgumentException("Неподдерживаемый тип данных");
    }

    public static <T extends Number> double divide(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static <T extends Number> T subtract(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() - b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
        }
        throw new IllegalArgumentException("Неподдерживаемый тип данных");
    }
}