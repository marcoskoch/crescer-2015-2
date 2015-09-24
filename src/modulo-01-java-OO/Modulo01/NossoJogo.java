public class NossoJogo {
    public final static String NOME = "Bahhh of the rings";
    public static int CONTADOR_ELFOS = 0;

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Olá " + args[0] +", bem vindo ao " + NOME);
        }
    }
    
    public void zerarContador(){
        this.CONTADOR_ELFOS = 0;
    }
}