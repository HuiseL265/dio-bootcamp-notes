package Colecoes.Map;

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {

        System.out.println("\nOrdem aleatoria");

        Map<String, Livro> meusLivros = new HashMap<>(){{
           put("Hawking, Stephen", new Livro("Uma Breve Historia do Tempo",356));
           put("Duhigg, Charles", new Livro("O Poder do Habito",408));
           put("Harari, Yubal Noah", new Livro("21 lições para o seculo 21",234));
        }};

        for(Map.Entry<String,Livro> livro: meusLivros.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue());
        }

        System.out.println("\nOrdem de insercao");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve Historia do Tempo",356));
            put("Duhigg, Charles", new Livro("O Poder do Habito",408));
            put("Harari, Yubal Noah", new Livro("21 lições para o seculo 21",234));
        }};

        for(Map.Entry<String,Livro> livro : meusLivros1.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue());
        }

        System.out.println("\nOrdem alfabetica dos autores");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for(Map.Entry<String,Livro> livro : meusLivros2.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue());
        }

        System.out.println("\nOrdem alfabetica nomes dos livros");

        Set<Map.Entry<String,Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for(Map.Entry<String,Livro> livro : meusLivros3){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String,Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}