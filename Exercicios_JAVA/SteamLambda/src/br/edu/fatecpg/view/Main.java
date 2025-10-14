package br.edu.fatecpg.view;

import br.edu.fatecpg.model.Produto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Produto> produto = new ArrayList<>();
        produto.add (new Produto("Monitor",500.30,"Eletronicos"));
        produto.add (new Produto("Tenis",490.30,"Calçados"));
        produto.add (new Produto("Camiseta",100.50,"Vestuário"));
        produto.add (new Produto("Naruto",1000.50,"Brinquedo"));
        produto.add (new Produto("Mouse",390.23,"Eletronicos"));
        produto.add (new Produto("Calça",150.60,"Vestuário"));


        List<Produto> eletronicos = produto.stream()
                .filter(p-> p.getCategoria().equals("Eletronicos"))
                .toList();
        System.out.println("------Mostrando os Eletronicos------");
        eletronicos.forEach(System.out::println);

        System.out.println();

        List<Double> desconto = eletronicos.stream()
                .map( p-> p.getPreco() - (p.getPreco()  * 0.1 ))
                .sorted()
                .toList();
        System.out.println("---Desconto---");
        desconto.forEach(System.out::println);

        double Totalgasto = produto.stream()
                .filter(p-> p.getCategoria().equals("Vestuário"))
                .map(p-> p.getPreco())
                .reduce(0.0,Double::sum);

        System.out.println("--Mostrando os gastos--");
        System.out.println(Totalgasto);

        Map<String,Double> mediaCategoria = produto.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.averagingDouble(Produto::getPreco)));
        System.out.println("--Agrupando os produtos---");
        System.out.println(mediaCategoria);

    }
}
