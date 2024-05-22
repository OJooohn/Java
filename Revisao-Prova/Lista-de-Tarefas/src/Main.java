import GerenciamentoTarefas.CategoriaTarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static CategoriaTarefa buscarCategoria(Scanner sc, List<CategoriaTarefa> categorias){

    }

    public static void main(String[] args) {

        List<CategoriaTarefa> categorias = new ArrayList<CategoriaTarefa>();
        categorias.add(new CategoriaTarefa("trabalho"));
        categorias.add(new CategoriaTarefa("estudo"));
        categorias.add(new CategoriaTarefa("pessoal"));

    }

}