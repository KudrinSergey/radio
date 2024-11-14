import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {
    Radio radio = new Radio();
    @Test
    public void testInitialStationAndVolume() {
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testSetStationValid() {
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testSetStationInvalidLow() {
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testSetStationInvalidHigh() {
        radio.setCurrentStation(11);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testNextStation() {
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStation() {
        radio.setCurrentStation(1);
        radio.prev();
        assertEquals(0, radio.getCurrentStation());
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testIncreaseVolume() {
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
        for (int i = 0; i < 99; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolume() {
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
        radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        radio.decreaseVolume();
        assertEquals(99, radio.getCurrentVolume());
    }
}
