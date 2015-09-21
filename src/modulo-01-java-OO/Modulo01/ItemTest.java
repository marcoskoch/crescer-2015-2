

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ItemTest
{
    @Test
    public void itemComDescricaoEQuantidade() {
        Item item = new Item("Espada", 15);
        assertEquals("Espada", item.getDescricao());
        assertEquals(15, item.getQuantidade());
    }
}
