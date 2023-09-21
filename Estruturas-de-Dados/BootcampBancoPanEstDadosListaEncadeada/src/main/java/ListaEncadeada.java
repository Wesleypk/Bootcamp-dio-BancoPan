
public class ListaEncadeada<T> {

    No<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    public int Size() {
        int tamanhoLista = 0;
        No<T> referenciaAuxiliar = referenciaEntrada;
        while (true) {
            if (referenciaAuxiliar != null){
                tamanhoLista++;
                if(referenciaAuxiliar.getProximoNo() != null){
                    referenciaAuxiliar = referenciaAuxiliar.getProximoNo();
                }
                else break;
            }
        else break;
        }
        return tamanhoLista;
    }


    public boolean IsEmpty() {
        return referenciaEntrada == null ? true : false;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No <T> noAuxiliar = referenciaEntrada;
        for (int i=0; i<this.Size();i++){
            strRetorno += "[Nó {conteudo=" +noAuxiliar.getConteudo() +"}] ------>";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        strRetorno += "*null*";

        return strRetorno;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(this.IsEmpty()){
            referenciaEntrada = novoNo;
            return;
        }

        No<T> noAuxiliar = referenciaEntrada;
        for(int i = 0;i < this.Size()-1; i++){
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        noAuxiliar.setProximoNo(novoNo);
    }
    private T Remove(int index){
        No <T> noPivor = this.getNo(index);
        if(index == 0){
            referenciaEntrada = noPivor.getProximoNo();
            return noPivor.getConteudo();
        }
        No <T> noAnterior = getNo(index -1);
        noAnterior.setProximoNo(noPivor.getProximoNo());
        return noPivor.getConteudo();

    }
    private No<T> getNo(int index){
        validaIndice(index);
        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;
        for(int i=0; i <= index; i++){
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }

    private T get(int index){
        return getNo(index).getConteudo();

    }
    private void validaIndice(int index){
        if(index >= Size()){
            int ultimoIndice = Size()-1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no indice" + index +"desta lista. O ultimo indice é: " + ultimoIndice +".");
        }
    }
}