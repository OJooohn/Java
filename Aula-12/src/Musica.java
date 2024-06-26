public class Musica implements Comparable<Musica> {

    private String titulo;
    private String autor;
    private int ano;

    Musica(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    String getTitulo() {
        return this.titulo;
    }

    String getAutor() {
        return this.autor;
    }

    int getAno() {
        return this.ano;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        // return super.toString();

        return this.getTitulo();
        // return "[ " + this.getAno() + "] - " + this.getTitulo() + " - " +
        // this.getAutor();
    }

    @Override
    public int compareTo(Musica o) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'compareTo'");

        // return this.titulo.compareTo(o.getTitulo());
        // return this.autor.compareTo(o.getAutor());
        int compare = Integer.compare(ano, o.getAno());

        if (compare != 0)
            return compare;

        return 0;

    }

}
