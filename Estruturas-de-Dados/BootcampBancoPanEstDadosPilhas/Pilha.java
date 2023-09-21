package BootcampBancoPanEstDadosPilhas;

public class Pilha {

    private No refNoEntradaPilha;

    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    public void push(No novoNo) {
        //Guarda a referência do topo.
        No refAuxiliar = refNoEntradaPilha;
        // Seta novoNo como nova referencia de topo
        refNoEntradaPilha = novoNo;
        //Seta a antiga referencia de topo como nó anterior ao atual topo
        refNoEntradaPilha.setReNo(refAuxiliar);
    }

    public No pop() {
        if (!this.isEmpty()) {
        No noPoped = refNoEntradaPilha;
        refNoEntradaPilha = refNoEntradaPilha.getRefNo();
        return noPoped;
        }
        return null;
    }

        public No top () {
            return refNoEntradaPilha;
        }


        public boolean isEmpty () {
            return refNoEntradaPilha == null ? true : false;
        }



}

