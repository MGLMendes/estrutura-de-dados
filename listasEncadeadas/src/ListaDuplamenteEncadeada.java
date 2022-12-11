public class ListaDuplamenteEncadeada<T> {

    ItemListaDuplamenteEncadeada<T> primeiroItem;
    ItemListaDuplamenteEncadeada<T> ultimoItem;

    int tamanho = 0;

    public ListaDuplamenteEncadeada() {

    }

    public T add(T dado) {

        if (ultimoItem == null){
            this.primeiroItem = new ItemListaDuplamenteEncadeada<>();
            primeiroItem.setDado(dado);
            ultimoItem = primeiroItem;
        } else {
            ItemListaDuplamenteEncadeada<T> item = new ItemListaDuplamenteEncadeada<>();
            item.setDado(dado);
            ultimoItem.setProximo(item);
            item.setAnterior(ultimoItem);
            ultimoItem = item;
        }

        tamanho++;
        return dado;
    }

    private ItemListaDuplamenteEncadeada<T> getLista(int posicao) throws Exception {
        if (posicao < 0 || posicao >= tamanho) {
            throw new Exception("Posição negativa ou maior que o tamanho da lista");
        }

        if (posicao == 0){
            return primeiroItem;
        }

        ItemListaDuplamenteEncadeada<T> item = primeiroItem;
        for (int i = 0; i < posicao; i++){
            item = item.getProximo();

        }
        return item;
    }

    private T get(int posicao) throws Exception {
        if (posicao < 0 || posicao >= tamanho) {
            throw new Exception("Posição negativa ou maior que o tamanho da lista");
        }

        if (posicao == 0){
            return primeiroItem.getDado();
        }

        T dado;

        if (posicao <= tamanho/2) {
            dado = ordemCerta(posicao);
        } else {
            dado = ordemInversa(posicao);
        }

        return dado;

    }

    private T ordemCerta(int posicao) {
        ItemListaDuplamenteEncadeada<T> item = primeiroItem;
        for (int i = 0; i < posicao; i++){
            item = item.getProximo();

        }
        return item.getDado();
    }



    private T ordemInversa(int posicao) {
        ItemListaDuplamenteEncadeada<T> item = ultimoItem;
        for (int i = tamanho; i > posicao + 1; i--){
            System.out.println("i: "+i);
            System.out.println("Item antes: " + item.getDado());
            item = item.getAnterior();
            System.out.println("Item depois: " + item.getDado());
            System.out.println();
        }
        return item.getDado();
    }

    public T remove(int posicao) throws Exception {
        if (posicao < 0 || posicao >= tamanho) {
            throw new Exception("Posição negativa ou maior que o tamanho da lista");
        }

        if (posicao == 0){
            T dado = primeiroItem.getDado();
            primeiroItem = primeiroItem.getProximo();
            return dado;
        }

        ItemListaDuplamenteEncadeada<T> itemAtual = this.getLista(posicao);
        ItemListaDuplamenteEncadeada<T> itemAnterior = itemAtual.getAnterior();

        if (itemAtual == ultimoItem) {
            ultimoItem = itemAnterior;
            itemAnterior.setProximo(null);
        } else {
            itemAnterior.setProximo(itemAtual.getProximo());
        }

        return itemAtual.getDado();
    }
    public void printList() {
        ItemListaDuplamenteEncadeada<T> item = primeiroItem;

        System.out.println("\n");
        System.out.println("primeiroItem: " +  primeiroItem.getDado());
        System.out.println("ultimoItem: "  + ultimoItem.getDado());

        while (item.getProximo() != null) {
            System.out.println(item.getDado());
            item = item.getProximo();
        }

        System.out.println(item.getDado());
    }

    public void printListReverse() {
        ItemListaDuplamenteEncadeada<T> item = ultimoItem;

        System.out.println("\n");
        System.out.println("primeiroItem: " +  ultimoItem.getDado());
        System.out.println("ultimoItem: "  + primeiroItem.getDado());

        while (item.getAnterior() != null) {
            System.out.println(item.getDado());
            item = item.getAnterior();
        }

        System.out.println(item.getDado());
    }



    public static void main(String[] args) throws Exception {
        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<>();
        lista.add("Pos 1");
        lista.add("Pos 2");
        lista.add("Pos 3");
        lista.add("Pos 4");
        lista.add("Pos 5");
        lista.add("Pos 6");
        lista.add("Pos 7");
        lista.add("Pos 8");
        lista.add("Pos 9");
        lista.add("Pos 10");
        lista.add("Pos 11");


        System.out.println(lista.get(6));





    }

}
