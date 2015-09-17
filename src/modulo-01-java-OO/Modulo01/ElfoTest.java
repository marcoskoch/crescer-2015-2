

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoTest
{
    @Test
    public void elfoFlechasDefault(){
    	Elfo legolas = new Elfo("legolas");
    	assertEquals(42, legolas.getFlechas());
    }
}
