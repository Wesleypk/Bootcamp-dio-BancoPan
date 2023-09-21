package one.digital.inovation;

public class ArvoreBinaria<T extends Comparable<T>> {
    private BinNo<T> raiz;
    private T conteudo;

  public ArvoreBinaria(){
      this.raiz = null;
  }

  public void inserir(T conteudo){
      BinNo<T> novoNo = new BinNo<>(conteudo);
      raiz = inserir(raiz, novoNo);

    }
  private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo ){
            if(atual == null){
               return novoNo;
            } else if(atual.getConteudo().compareTo(novoNo.getConteudo()) < 0){
                atual.setNoEsq(inserir(atual.getNoEsq(),novoNo));
            }else {
                atual.setNoDir(inserir(atual.getNoDir(),novoNo));
            }
            return atual;
      }
  public void exibirInOrdem(){
      System.out.println("\n Imprimindo InOrder");
      exibirInOrdem(this.raiz);
  }
  private void exibirInOrdem(BinNo atual) {
      if (atual != null) {
          exibirInOrdem(atual.getNoEsq());
          System.out.print(atual.getConteudo() + ", ");
          exibirInOrdem(atual.getNoDir());
      }
  }

    public void exibirPosOrdem(){
        System.out.print("\n Imprimindo PosOrdem");
        exibirInOrdem(this.raiz);
    }
    private void exibirPosOrdem(BinNo atual) {
        if (atual != null) {
            exibirPosOrdem(atual.getNoEsq());
            exibirPosOrdem(atual.getNoDir());
            System.out.print(atual.getConteudo() + ", ");
        }
    }
    public void exibirPreOrdem(){
        System.out.print("\n Imprimindo PreOrdem");
        exibirInOrdem(this.raiz);
    }
    private void exibirPreOrdem(BinNo atual) {
        if (atual != null) {
            System.out.println(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());
        }
    }
    public void remover(T conteudo){
      try{
          BinNo<T> atual = this.raiz;
          BinNo<T> pai = null;
          BinNo<T> filho = null;
          BinNo<T> temp = null;

         // Parte do método que encontra o Nó da arvore a ser removido.
          while (atual != null && !atual.getConteudo().equals(conteudo)){
              pai =atual;
              if(conteudo.compareTo(atual.getConteudo())<0){
                  atual=atual.getNoEsq();
              }else {
                  atual = atual.getNoDir();
              }
              }
          if(atual == null) {
              System.out.println("Conteudo nao encontrado. Bloco Try");
          }

          // Parte do método que reorganiza os nós se o nó removido for a raiz.
          if(pai == null){ // Neste caso não "Pai" está vazio pois não há nó pai para a Raiz.
              if(atual.getNoDir()== null){
                  this.raiz=atual.getNoEsq();

              } else if(atual.getNoEsq()==null){
                  this.raiz=atual.getNoDir();

              }else { // Caso haja nó filho para ambos lado esquerdo e direito.
                  for(temp = atual, filho = atual.getNoEsq();
                       filho.getNoDir() != null;
                       temp = filho, filho = filho.getNoEsq()
                       ){
                      if(filho != atual.getNoEsq()){
                          temp.setNoDir(filho.getNoEsq());
                          filho.setNoEsq(raiz.getNoEsq());
                      }
                  }
                  filho.setNoDir(raiz.getNoDir());
                  raiz=filho;
              }

          }else if(atual.getNoDir()==null){
              if(pai.getNoEsq()==atual){
                  pai.setNoEsq(atual.getNoEsq());

              } else {
                  pai.setNoDir(atual.getNoEsq());
              }

          } else if (atual.getNoEsq()==null) {
              if(pai.getNoEsq()==atual){
                  pai.setNoEsq(atual.getNoDir());

              } else {
                  pai.setNoDir(atual.getNoDir());
              }

          }else{
              for(
                      temp = atual, filho = atual.getNoEsq();
                      filho.getNoDir() != null;
                      temp = filho, filho = filho.getNoDir()
              ){
                  if(filho != atual.getNoEsq()){
                      temp.setNoDir(filho.getNoEsq());
                      filho.setNoEsq(atual.getNoEsq());
                  }
                  filho.setNoDir(atual.getNoDir());
                  if(pai.getNoEsq() == atual){
                      pai.setNoEsq(filho);
                  }else{
                      pai.setNoDir(filho);

                  }
              }
          }

      }
      catch (NullPointerException erro){
          System.out.println("Conteudo nao encontrado. Bloco Catch");

        }
    }

}

//Integer.parseInt(JOptionPane.showInputDialog("Digite um Numero"));