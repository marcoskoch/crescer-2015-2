

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OrcUrukHaiTest
{
  @Test
  public void criaUrukHai(){
      OrcUrukHai orcUrukHai = new OrcUrukHai();

      int vidaEsperada = 150;
      Inventario inventarioEsperado = new Inventario();
      inventarioEsperado.adicionarItem(new Item(1, "Escudo Uruk-Hai"));
      inventarioEsperado.adicionarItem(new Item(1, "Espada"));

      assertEquals(vidaEsperada, orcUrukHai.getVida());
      assertEquals(inventarioEsperado, orcUrukHai.getInventario());
  }

  @Test
  public void orcUrukHaiRecebeDanoDeAnao(){
      OrcUrukHai orc = new OrcUrukHai();

      orc.levarAtaqueDeAnao();

      assertEquals(144, orc.getVida());
  }

  @Test
  public void orcUrukHaiRecebeDanoDeElfo(){
      OrcUrukHai orc = new OrcUrukHai();

      orc.levarAtaqueDeElfo();

      assertEquals(144, orc.getVida());
  }


}
