public class ItemListaDuplamenteEncadeada<T> {

    T dado;
    ItemListaDuplamenteEncadeada<T> anterior;
    ItemListaDuplamenteEncadeada<T> proximo;

    public ItemListaDuplamenteEncadeada<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(ItemListaDuplamenteEncadeada<T> anterior) {
        this.anterior = anterior;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public ItemListaDuplamenteEncadeada<T> getProximo() {
        return proximo;
    }

    public void setProximo(ItemListaDuplamenteEncadeada<T> proximo) {
        this.proximo = proximo;
    }
}
