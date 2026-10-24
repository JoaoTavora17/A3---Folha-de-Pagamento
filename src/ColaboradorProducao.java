public class ColaboradorProducao extends Colaborador{
    private int quantidadedePecas;
    private double valorporPeca,produtividade;
    public ColaboradorProducao(String nome, int matricula) {
        super(nome, matricula);
    }

    public int getQuantidadedePecas() {
        return quantidadedePecas;
    }

    public void setQuantidadedePecas(int quantidadedePecas) {
        this.quantidadedePecas = quantidadedePecas;
    }

    public double getValorporPeca() {
        return valorporPeca;
    }

    public void setValorporPeca(double valorporPeca) {
        this.valorporPeca = valorporPeca;
    }
    public double calcularProdutividade(){
        return quantidadedePecas*valorporPeca;
    }

    public double getProdutividade() {
        return produtividade = calcularProdutividade();
    }

   public double calcularsalarioFinal(){
       return getSalarioBase()+getProdutividade();

    }
}
