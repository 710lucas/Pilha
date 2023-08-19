public class Pilha<Elemento> {

    Elemento[] pilha;
    int quantidadeElementos;

    public Pilha(int tamanho){
        pilha = (Elemento[]) new Object[tamanho];
        quantidadeElementos = 0;
    }

    public void empilhar(Elemento elemento){
        if(quantidadeElementos+1 >= pilha.length){
            redimensionar(pilha.length*2);
        }
        pilha[quantidadeElementos] = elemento;
        quantidadeElementos++;
    }

    public Elemento desempilhar(){
        Elemento elemento = pilha[quantidadeElementos-1];
        quantidadeElementos--;
        pilha[quantidadeElementos] = null;
        if(quantidadeElementos <= pilha.length/4 && pilha.length/4 > 0)
            redimensionar(pilha.length/4);
        return elemento;
    }

    private void redimensionar(int novoTamanho) {
        System.out.println("Redimensionando para: "+novoTamanho);

        Elemento[] pilhaAntiga = pilha;

        pilha = (Elemento[]) new Object[novoTamanho];

        for(int i = 0; i<quantidadeElementos; i++){
            pilha[i] = pilhaAntiga[i];
        }

    }

    public String toString(){
        String out = "";
        for(int i = 0; i<quantidadeElementos; i++){
            out+=pilha[i].toString()+" ";
        }
        return out;
    }

    public static void main(String[] args) {
        Pilha<String> nomes = new Pilha<String>(50);
        nomes.empilhar("lucas");
        nomes.empilhar("teste");
        nomes.empilhar("1");
        System.out.println(nomes.toString());

        System.out.println(nomes.desempilhar());
        System.out.println(nomes.desempilhar());
        System.out.println(nomes.desempilhar());


    }

}
