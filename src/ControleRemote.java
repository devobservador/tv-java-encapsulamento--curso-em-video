import java.util.Scanner;

public class ControleRemote implements Controlador {


    // definindo os atributos

    private int volume;
    private boolean ligado;
    private boolean tocando;

    // Criando o construtor

    public ControleRemote(){
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
    }

    // criando o nosso método get

    private int getVolume(){
        return volume;
    }

    private  boolean getLigado(){
        return ligado;
    }
    private boolean getTocando(){
        return tocando;
    }

    // criando o nosso set

    private void setVolume(int volume){
        this.volume= volume;

    }

    private void  setLigado(boolean ligado){
        this.ligado = ligado;

    }

    private void setTocando(boolean tocando){
        this.tocando = tocando;

    }


    @Override
    public void ligar() {
        this.setLigado(true);



    }

    @Override
    public void Desligar() {
        this.setLigado(false);


    }



    @Override
    public void AbrirMenu() {
        setLigado(true);
        setTocando(true);
        if(this.getLigado()==true ) {

            System.out.println("-----------MENU---------------");System.out.println("Tv está ligada ? " + getLigado());
            System.out.println("Está tocando ? " + getTocando());
            System.out.print("Volume :" + getVolume());
            for (int i = 1; i <= getVolume(); i += 10) {
                System.out.print("|");

            }
            System.out.println();
            }else{
            System.out.println("-------------MENU------------------");
                System.out.println("Impossivel habilitar o menu, ligue o controle!!");
        }


    }

    @Override
    public void FecharMenu(){
        if (this.getLigado()==false){
            System.out.println("Encerrando menu");

        }
    }

    @Override
    public void MaisVolume() {
       if(this.getLigado()==true){
           setVolume(getVolume()+10);

       }else {
           System.out.println(" Ligue o controle para aumentar o volume");
       }
    }

    @Override
    public void MenosVolumer() {

        if(this.getLigado()==true){
            this.setVolume(this.getVolume()-10);

        }else {
            System.out.println("Controle precisa estar ligado para diminuir o volume");
        }



    }

    @Override
    public void LigarMudo() {
        if(this.getLigado()==true  && this.getVolume()>0){
            this.setVolume(0);
            setVolume(this.getVolume());
            System.out.println("Tv muda . Volume atual:"+getVolume());
        }else{
            System.out.println("Controle precisa estar ligado para habilitar o modo mudo !");
    }
    }

    @Override
    public void DesligarMudo() {
        if(this.getLigado()==true && this.getVolume()==0){
            this.setVolume(10);
            setVolume(this.getVolume());
            System.out.println("Saindo do modo mudo. Volume atual: " +getVolume());
        }
    }

    @Override
    public void Play() {
        if(this.getLigado() && !(this.getTocando())){
            setTocando(true);
            setTocando(this.getTocando());
            System.out.println(getTocando());
        }

    }

    @Override
    public void Pause() {
        if(this.getLigado() && this.getTocando()){
            setTocando(true);
            setTocando(this.getTocando());
            System.out.println(getTocando());
        }
    }
    @Override
    public void AcessandoStremears(){
        this.setLigado(true);
        this.setTocando(true);

        if(this.getLigado() && this.getTocando()){
            Scanner entradas = new Scanner(System.in);
            System.out.println("-----------Serviços-------------------");
            System.out.println("Acesse os seu serviços !! digite 1 para [Netflix] , digite 2 para [Spotify] ou 3 para [Youtube] ");
            int EscolhaDoServicos = entradas.nextInt();

            switch (EscolhaDoServicos){
                case 1:{
                    System.out.println("Acessando a Neflix...");
                    break;
                } case 2:{
                    System.out.println("Acessando  o Spotify....");
                    break;
                } case 3:{
                    System.out.println("Acessando o Yotube....");
                    break;
                } default:
                    System.out.println("[ERRO !! OPÇÃO NÃO ENCONTRADA ] Digite novamente");
                    while (EscolhaDoServicos!=1 && EscolhaDoServicos!=2 && EscolhaDoServicos!=3) {
                    System.out.println("Acesse os seu serviços !! digite 1 para [Netflix] , digite 2 para [Spotify] ou 3 para [Youtube] ");
                     EscolhaDoServicos = entradas.nextInt();

                }
                    switch (EscolhaDoServicos){
                        case 1:
                            System.out.println("Acessando a Netflix...");
                            break;
                        case 2:
                            System.out.println("Acessando o Spotify...");
                            break;
                        case 3:
                            System.out.println("Acessando o Youtube...");
                            break;
                    }


            }

        }

    }
}
