import java.util.ArrayList;
import java.util.List;

public class Agenda {

  private String nomeAgenda;

  Agenda(String nomeAgenda){
    this.nomeAgenda = nomeAgenda;
  }

  String getNomeAgenda(){
    return nomeAgenda;
  }

  List<Contato> contatos = new ArrayList<Contato>();

  void novoContato(String nome, String telefone){
    contatos.add(new Contato(nome, telefone));
  }

  void excluirContato(int i){
    contatos.remove(i);
  }
  
}
