import model.devices.output.LCDDisplay;
import org.junit.Test;

import static org.junit.Assert.*;

public class LCDDisplayTest {

    @Test
    public void shouldCheckIfMessageIsEmpty() {

        LCDDisplay lcdDisplay=new LCDDisplay();
       String message= lcdDisplay.showMessage();
        // when
        boolean empty =message.isEmpty();
        // then
        assertEquals(empty,true);
    }

    @Test
    public void shouldCheckIfMessageIsNotEmpty() {
        LCDDisplay lcdDisplay=new LCDDisplay();
        String message= lcdDisplay.showMessage();
        // when
        boolean empty = message.isEmpty();
        // then
        assertEquals(empty,false);
    }
}