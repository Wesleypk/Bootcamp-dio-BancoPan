package BootcampDioListaCircular;

public class ListaCircular<T>{
    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista ;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }
    private int size(){
        return this.tamanhoLista;
    }

    private boolean isEmpty(){
        return this.tamanhoLista == 0? true : false;
    }
    private No<T> getNo(int index){
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");
        if(index == 0){
           return this.cauda;
        }
        No<T> noAuxiliar = this.cauda;
        for(int i = 0; i < index && noAuxiliar!=null; i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    public void remove(int index){
        if (index >=this.tamanhoLista)
            throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista!");
        No <T> noAuxiliar = this.cauda;
        if(index ==0){
            this.cauda = this.cauda.getNoProximo();
            this.cabeca.setNoProximo(this.cauda);
        } else if (index == 1) {
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
            } else{
            for(int i=0; i < index -1;i ++){
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());

        }
        tamanhoLista --;

    }
    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if (this.tamanhoLista == 0) {
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoProximo(cauda);
        }else {
            novoNo.setNoProximo(this.cauda);
            this.cabeca.setNoProximo(novoNo);
            this.cauda = novoNo;
        }
        tamanhoLista++;
    }

    @Override
    public String toString() {
        String strRetorno = "";

        No<T> noAuxliar = this.cauda;

        for(int i=0; i<this.size();i++) {
            strRetorno += "[Nó{conteudo" + noAuxliar.getConteudo() + "}]  ---->";
            noAuxliar = noAuxliar.getNoProximo();
        }
        strRetorno += this.size() != 0 ? "Retorna ao Inicio" : "[   ]";


        return strRetorno;
    }
}
