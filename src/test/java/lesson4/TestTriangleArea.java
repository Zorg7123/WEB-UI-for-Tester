package lesson4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTriangleArea {

    private static Logger logger = LoggerFactory.getLogger(TestTriangleArea.class);

    // 3 позитивных случая
    @ParameterizedTest
    @CsvSource({"1, 1, 1, 0.4330127018922193", "2, 2, 2, 1.7320508075688772", "3, 4, 5, 6.0"})
    void testCorrectTriangleArea(int a, int b, int c, double expectedArea) {
        logger.info("стороны треугольника: " + a + "," + b + "," + c + ", ожидаемая площадь: " + expectedArea);
        assertEquals(trianglearea.calcTriangleArea(a, b, c), expectedArea);
    }

    //3 негативных случая
    @ParameterizedTest
    @CsvSource({"1, 1, 1, 1.0", "2, 2, 2, 2.0", "3, 4, 5, 3.0"})
    void testIncorrectTriangleArea(int a, int b, int c, double expectedArea) {
        logger.warn("Стороны треугольника: " + a + "," + b + "," + c + ", ожидаемая площадь: " + expectedArea);
        assertNotEquals(trianglearea.calcTriangleArea(a, b, c), expectedArea);
    }

    // Проверки исключений
    @ParameterizedTest
    @CsvSource({"0, 0, 0", "-2, -2, -2"})
    void testExceptionIncorrectSides(int a, int b, int c) {
        logger.error("Стороны треугольника: " + a + "," + b + "," + c + ", ожидается ArithmeticException");
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> trianglearea.calcTriangleArea(a, b, c));
    }

    // Нулевые длины сторон
    @ParameterizedTest
    @CsvSource({", , ", "1, , ", ", 2, ", ", , 3"})
    void testExceptionNullSides(Integer a, Integer b, Integer c) {
        logger.error("Стороны треугольника: " + a + "," + b + "," + c + ", ожидается NullPointerException");
        assertThatNullPointerException().isThrownBy(() -> trianglearea.calcTriangleArea(a, b, c));
    }
}
