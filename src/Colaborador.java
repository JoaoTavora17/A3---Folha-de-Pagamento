public class Colaborador {
    private int matricula;
    private String nome;
   private final double salarioBase = 2000;

    public Colaborador(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    void exibirDados(){
        System.out.println("Matricula: " + getMatricula());
        System.out.println("Nome: " + getNome());
        System.out.println("Salário base: " + getSalarioBase());
    }
}
