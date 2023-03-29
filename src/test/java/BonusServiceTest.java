import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {
    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызвали целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ОР и ФР):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        //подготавлтваем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        //производим проверку (сравниваем ОР и ФР):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1000;
        boolean unregistered = false;
        long expected = 10;

        // вызвали целевой метод:
        long actual = service.calculateUnregistered(amount, unregistered);

        // производим проверку (сравниваем ОР и ФР):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        long amount = 1_000_000;
        boolean unregistered = false;
        long expected = 500;

        // вызвали целевой метод:
        long actual = service.calculateUnregistered(amount, unregistered);

        // производим проверку (сравниваем ОР и ФР):
        Assertions.assertEquals(expected, actual);
    }
}
