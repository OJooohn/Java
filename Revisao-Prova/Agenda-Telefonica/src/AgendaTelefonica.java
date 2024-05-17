import java.util.ArrayList;
import java.util.List;

public class AgendaTelefonica implements OperacoesAgenda{

    private List<Contato> contatos = new ArrayList<>();

    @Override
    public void adicionar(int tipo, String nome, String numero, String email, String dataNascimento) {
        if(tipo == 1)
            contatos.add(new ContatoProfissional(nome, numero, email));
        if(tipo == 2)
            contatos.add(new ContatoPessoal(nome, numero, dataNascimento));
    }

    @Override
    public void remover(int indice) {
        contatos.remove(indice);
    }

    @Override
    public void listar(boolean listarTodos, int indice) {
        if(listarTodos){
            for(Contato c : contatos){
                System.out.println(c.toString());
            }
        } else {
            System.out.println(contatos.get(indice));
        }
    }

    @Override
    public int buscar(String numero) {
        for(int i = 0; i < contatos.size(); i++){
            Contato c = contatos.get(i);
            if(numero.equals(c.getNumero())){
                return i;
            }
        }

        return -1;
    }

}
