public class Jogador {
  
  private String nome;
  private int pontuacao;
  private int nivel;

  Jogador(String nome, int pontuacao, int nivel){
    this.nome = nome;
    this.pontuacao = pontuacao;
    this.nivel = nivel;
  }

  String getNome(){
    return nome;
  }

  int getPontuacao(){
    return pontuacao;
  }

  int getNivel(){
    return nivel;
  }

  void setPontuacao(int pontuacao){
    this.pontuacao = pontuacao;
  }

  void setNivel(int nivel){
    this.nivel = nivel;
  }

  void atualizarPontuacao(int pontuacao){
    this.setPontuacao(pontuacao);
  }

  void atualizarNivel(int nivel){
    this.setNivel(nivel);
  }

  void listar(){
    System.out.println("-- Nome: " + this.getNome());
    System.out.println("-- Pontuaçao: " + this.getPontuacao());
    System.out.println("-- Nível: " + this.getNivel());
    System.out.println("\n ======================= \n");
  }

}
