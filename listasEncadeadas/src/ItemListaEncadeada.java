public class ItemListaEncadeada<T> {

    T dado;
    ItemListaEncadeada<T> proximo;

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public ItemListaEncadeada<T> getProximo() {
        return proximo;
    }

    public void setProximo(ItemListaEncadeada<T> proximo) {
        this.proximo = proximo;
    }
}
