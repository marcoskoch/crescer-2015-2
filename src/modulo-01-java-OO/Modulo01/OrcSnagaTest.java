

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OrcSnagaTest
{
  @Test
  public void criaSnaga(){
      OrcSnaga orcSnaga = new OrcSnaga();

      int vidaEsperada = 70;
      Inventario inventarioEsperado = new Inventario();
      inventarioEsperado.adicionarItem(new Item(1, "Arco"));
      inventarioEsperado.adicionarItem(new Item(5, "Flecha"));

      assertEquals(vidaEsperada, orcSnaga.getVida());
      assertEquals(inventarioEsperado, orcSnaga.getInventario());
  }

  @Test
  public void orcSnagaRecebeDanoDeAnao(){
      OrcSnaga orc = new OrcSnaga();

      orc.levarAtaqueDeAnao();

      assertEquals(60, orc.getVida());
  }

  @Test
  public void orcSnagaRecebeDanoDeElfo(){
      OrcSnaga orc = new OrcSnaga();

      orc.levarAtaqueDeElfo();

      assertEquals(60, orc.getVida());
  }

  @Test
  public void orcSnagaFicaSemFlechasParaAtirarEFoge(){
      OrcSnaga orc = new OrcSnaga();
      Elfo elfo = new Elfo(null);

      for(int i = 0; i < 6; i++){
          orc.atacarElfo(elfo);
      }

      assertEquals(Status.FUGINDO, orc.getStatus());
  }

  @Test
  public void orcSnagaAtiraFlechaEmElfoEFicaCom4Flechas(){

      OrcSnaga orc = new OrcSnaga();
      Elfo elfo = new Elfo(null);

      orc.atacarElfo(elfo);

      int qtdFlechas = orc.getInventario().getItemPorDescricao("Flecha").getQuantidade();

      assertEquals(4, qtdFlechas);

  }


}
