package bean;
// Generated 18/12/2023 10:00:26 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CompraprodutoFgv generated by hbm2java
 */
@Entity
@Table(name = "compraproduto_fgv",
         catalog = "db_felipe_ronceti"
)
public class CompraprodutoFgv implements java.io.Serializable {

    private Integer idcompraprodutoFgv;
    private CompraFgv compraFgv;
    private ProdutoFgv produtoFgv;
    private Integer quantidadeFgv;
    private double valorUnitarioFgv;

    public CompraprodutoFgv() {
    }

    public CompraprodutoFgv(CompraFgv compraFgv, ProdutoFgv produtoFgv) {
        this.compraFgv = compraFgv;
        this.produtoFgv = produtoFgv;
    }

    public CompraprodutoFgv(CompraFgv compraFgv, ProdutoFgv produtoFgv, Integer quantidadeFgv, double valorUnitarioFgv) {
        this.compraFgv = compraFgv;
        this.produtoFgv = produtoFgv;
        this.quantidadeFgv = quantidadeFgv;
        this.valorUnitarioFgv = valorUnitarioFgv;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idcompraproduto_fgv", unique = true, nullable = false)
    public Integer getIdcompraprodutoFgv() {
        return this.idcompraprodutoFgv;
    }

    public void setIdcompraprodutoFgv(Integer idcompraprodutoFgv) {
        this.idcompraprodutoFgv = idcompraprodutoFgv;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compra_fgv", nullable = false)
    public CompraFgv getCompraFgv() {
        return this.compraFgv;
    }

    public void setCompraFgv(CompraFgv compraFgv) {
        this.compraFgv = compraFgv;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_fgv", nullable = false)
    public ProdutoFgv getProdutoFgv() {
        return this.produtoFgv;
    }

    public void setProdutoFgv(ProdutoFgv produtoFgv) {
        this.produtoFgv = produtoFgv;
    }

    @Column(name = "quantidade_fgv")
    public Integer getQuantidadeFgv() {
        return this.quantidadeFgv;
    }

    public void setQuantidadeFgv(Integer quantidadeFgv) {
        this.quantidadeFgv = quantidadeFgv;
    }

    @Column(name = "valorUnitario_fgv", precision = 10)
    public double getValorUnitarioFgv() {
        return this.valorUnitarioFgv;
    }

    public void setValorUnitarioFgv(double valorUnitarioFgv) {
        this.valorUnitarioFgv = valorUnitarioFgv;
    }

}
