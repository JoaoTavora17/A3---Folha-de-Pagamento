public class ColaboradorComissionado extends Colaborador {
    private double valorVendas;
    private int percentualComissao;
    double comissao;

    public ColaboradorComissionado(String nome, int matricula) {
        super(nome, matricula);
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public int getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(int percentualComissao) {
        this.percentualComissao = percentualComissao;
    }
    public double calcularComissao(){
        return valorVendas*percentualComissao/100;
    }

    public double getComissao() {
        return comissao = calcularComissao();
    }

    public double calcularSalarioFinal(){
        return getSalarioBase()+getComissao();
    }
}
