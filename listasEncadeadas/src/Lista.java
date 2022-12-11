public class Lista<T> {

    ItemListaEncadeada<T> primeiroItem;
    ItemListaEncadeada<T> ultimoItem;

    int tamanho = 0;

    public Lista() {

    }

    public T add(T dado) {

        if (ultimoItem == null){
            this.primeiroItem = new ItemListaEncadeada<>();
            primeiroItem.setDado(dado);
            ultimoItem = primeiroItem;
        } else {
            ItemListaEncadeada<T> item = new ItemListaEncadeada<>();
            item.setDado(dado);
            ultimoItem.setProximo(item);
            ultimoItem = item;
        }


//        System.out.println(primeiroItem.getDado());
//        System.out.println(ultimoItem==null? "" : ultimoItem.getDado());
//        System.out.println(primeiroItem);
//        System.out.println(ultimoItem);
//        System.out.println();
//        System.out.println();
//        System.out.println();
        tamanho++;
        return dado;
    }

    private ItemListaEncadeada<T> getItem(int posicao) throws Exception {
        if (posicao < 0 || posicao >= tamanho) {
            throw new Exception("Posição negativa ou maior que o tamanho da lista");
        }

        if (posicao == 0){
            return primeiroItem;
        }

        ItemListaEncadeada<T> item = primeiroItem;
        for (int i = 0; i < posicao; i++){
            item = item.getProximo();

        }
        return item;
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

        ItemListaEncadeada<T> itemAnterior = this.getItem(posicao-1);
        ItemListaEncadeada<T> itemAtual = itemAnterior.getProximo();

        if (itemAtual == ultimoItem) {
            ultimoItem = itemAnterior;
            itemAnterior.setProximo(null);
        } else {
            itemAnterior.setProximo(itemAtual.getProximo());
        }

        return itemAtual.getDado();
    }
    public void printList() {
        ItemListaEncadeada<T> item = primeiroItem;

        System.out.println("\n");
        System.out.println("primeiroItem: " +  primeiroItem.getDado());
        System.out.println("ultimoItem: "  + ultimoItem.getDado());

        while (item.getProximo() != null) {
            System.out.println(item.getDado());
            item = item.getProximo();
        }

        System.out.println(item.getDado());
    }



    public static void main(String[] args) throws Exception {
        Lista<String> lista = new Lista<>();
        lista.add("Pos 1");
        lista.add("Pos 2");
        lista.add("Pos 3");
        lista.add("Pos 4");

        lista.printList();

        lista.remove(3);

        lista.printList();





    }

}
