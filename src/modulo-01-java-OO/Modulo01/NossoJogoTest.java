

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class NossoJogoTest
{
  @Test
  public void contadorDeElfosComUmElfo() {
      NossoJogo jogo = new NossoJogo();
      jogo.zerarContador();
      Elfo celeborn = new Elfo("Celeborn");
      assertEquals(1, NossoJogo.CONTADOR_ELFOS);
  }
  
  @Test
  public void contadorDeElfosCom7Elfo() {
      NossoJogo jogo = new NossoJogo();
      jogo.zerarContador();
      Elfo celeborn = new Elfo("Celeborn");
      Elfo celeborn2 = new ElfoVerde("Celeborn");
      Elfo celeborn3 = new Elfo("Celeborn");
      Elfo celeborn4 = new Elfo("Celeborn");
      Elfo celeborn5 = new Elfo("Celeborn");
      Elfo celeborn6 = new ElfoNoturno("Celeborn");
      Elfo celeborn7 = new Elfo("Celeborn");
      assertEquals(7, NossoJogo.CONTADOR_ELFOS);
  }
}
