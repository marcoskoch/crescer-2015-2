

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class InventarioTest
{
    @Test
    public void inventarioListaItensSeparadosPorVirgula() {
        Inventario inventario = new Inventario();
        Item item1 = new Item("Cura", 15), item2 = new Item("Espada", 2);
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        String listaItens = inventario.getDescricoesItens();
        assertEquals("Cura, Espada", listaItens);
    }
}
