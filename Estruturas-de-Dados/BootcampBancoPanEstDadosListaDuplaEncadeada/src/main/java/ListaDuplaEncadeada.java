public class ListaDuplaEncadeada <T> {
//package BootcampBancoPanEstDadosListaDuplaEncadeada;
    public NoDuplo<T> primeiroNo;
    public NoDuplo<T> ultimoNo;
    public int tamanhoLista = 0;

    public ListaDuplaEncadeada(){
        this.tamanhoLista = 0;
        this.ultimoNo=null;
        this.primeiroNo= null;
    }

    public NoDuplo<T> getNo(int index){
        NoDuplo <T> noAuxiliar = primeiroNo;
        for(int i=0; (i<index) && (noAuxiliar!=null);i++){
            noAuxiliar=noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();

    }
    public int size(){
        return tamanhoLista;

    }
    public void add(T elemento){
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoPrevio(ultimoNo);
        novoNo.setNoProximo(null);
        if(primeiroNo == null){
            primeiroNo = novoNo;
        }
        if (ultimoNo != null){
            ultimoNo.setNoProximo(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista++;
    }
    public void add(int index, T elemento){
        NoDuplo<T> noAuxiliaradd = getNo(index);
        NoDuplo <T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(noAuxiliaradd);

        if(novoNo.getNoProximo()!=null){

            novoNo.setNoPrevio(noAuxiliaradd.getNoPrevio());
            //novoNo.getNoProximo().setNoPrevio(novoNo);
            novoNo.getNoProximo().setNoPrevio(novoNo);
            //novoNo.setNoPrevio(noAuxiliaradd.getNoPrevio());

        }else {
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;
        }
        if (index == 0){
            primeiroNo = novoNo;
        }else {
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }
        tamanhoLista++;
    }
    public void remove(int index){
        if(index == 0){
            primeiroNo=primeiroNo.getNoProximo();
            if(primeiroNo != null){
                primeiroNo.setNoPrevio(null);
            }
        }else{
            NoDuplo<T> noAuxiliar = getNo(index);
            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
            if(noAuxiliar.getNoProximo() != null){
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());

            }else{
                ultimoNo = noAuxiliar;
            }
        }
        this.tamanhoLista--;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        NoDuplo<T> noAuxiliar = primeiroNo;
        for(int i=0; i<size();i++){
            strRetorno+= "[No{conteudo=" + noAuxiliar.getConteudo() + "}]----->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        strRetorno+="null";
        return strRetorno;
    }
}
