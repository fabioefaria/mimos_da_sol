package br.com.mimos_da_sol.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Fabio Eduardo
 */
@Entity
@Table(name="endereco")
public class Endereco implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdEndereco", nullable=false)
    private Integer idEndereco;
    @Column(name="Bairro", length=80)
    private String bairro;
    @Column (name="NomeLogradouro", length=80)
    private String nomeLogradouro;
    @Column (name="CEP", length=9)
    private String cep;
    @Column (name="Numero")
    private Integer numero;
    @Column (name="Complemento")
    private Integer complemento;
    
    @OneToOne(optional=true, fetch= FetchType.LAZY)
    @ForeignKey(name="EnderecoPessoa")
    @JoinColumn(name = "IdPessoa", referencedColumnName = "IdPessoa")
    private Pessoa pessoa;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoTipoLogradouro")
    @JoinColumn(name = "IdTipoLogradouro", referencedColumnName = "IdTipoLogradouro")
    private TipoLogradouro tipologradouro;
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoEstado")
    @JoinColumn(name = "IdEstado", nullable = false)
    private Estado estado;
        
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoTipoEndereco")
    @JoinColumn(name = "IdTipoEndereco", referencedColumnName="IdTipoEndereco")
    private TipoEndereco tipoendereco;
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoCidade")
    @JoinColumn(name = "IdCidade", referencedColumnName="IdCidade")
    private Cidade cidade;   

    public Endereco() {
        this.cidade = new Cidade();
        this.estado = new Estado();
        this.tipologradouro = new TipoLogradouro();
        this.tipoendereco = new TipoEndereco();
        this.pessoa = new Pessoa();
    }    
    
}
