package br.com.sddbrc.teste.model;

import java.sql.Timestamp;

public class PessoaM {

    private Integer pessoa_Id;
    private String pessoa_Nome;
    private String pessoa_Cpf;
    private String pessoa_sexo;
    private Timestamp pessoa_DataNascimento;
    private String pessoa_Email;

    public PessoaM(Integer pessoa_Id, String pessoa_Nome, String pessoa_Cpf, String pessoa_sexo, Timestamp pessoa_DataNascimento, String pessoa_Email) {
        this.pessoa_Id = pessoa_Id;
        this.pessoa_Nome = pessoa_Nome;
        this.pessoa_Cpf = pessoa_Cpf;
        this.pessoa_sexo = pessoa_sexo;
        this.pessoa_DataNascimento = pessoa_DataNascimento;
        this.pessoa_Email = pessoa_Email;
    }
    
    

    /**
     * @return the pessoa_Id
     */
    public Integer getPessoa_Id() {
        return pessoa_Id;
    }

    /**
     * @param pessoa_Id the pessoa_Id to set
     */
    public void setPessoa_Id(Integer pessoa_Id) {
        this.pessoa_Id = pessoa_Id;
    }

    /**
     * @return the pessoa_Nome
     */
    public String getPessoa_Nome() {
        return pessoa_Nome;
    }

    /**
     * @param pessoa_Nome the pessoa_Nome to set
     */
    public void setPessoa_Nome(String pessoa_Nome) {
        this.pessoa_Nome = pessoa_Nome;
    }

    /**
     * @return the pessoa_Cpf
     */
    public String getPessoa_Cpf() {
        return pessoa_Cpf;
    }

    /**
     * @param pessoa_Cpf the pessoa_Cpf to set
     */
    public void setPessoa_Cpf(String pessoa_Cpf) {
        this.pessoa_Cpf = pessoa_Cpf;
    }

    /**
     * @return the pessoa_sexo
     */
    public String getPessoa_sexo() {
        return pessoa_sexo;
    }

    /**
     * @param pessoa_sexo the pessoa_sexo to set
     */
    public void setPessoa_sexo(String pessoa_sexo) {
        this.pessoa_sexo = pessoa_sexo;
    }

    /**
     * @return the pessoa_DataNascimento
     */
    public Timestamp getPessoa_DataNascimento() {
        return pessoa_DataNascimento;
    }

    /**
     * @param pessoa_DataNascimento the pessoa_DataNascimento to set
     */
    public void setPessoa_DataNascimento(Timestamp pessoa_DataNascimento) {
        this.pessoa_DataNascimento = pessoa_DataNascimento;
    }

    /**
     * @return the pessoa_Email
     */
    public String getPessoa_Email() {
        return pessoa_Email;
    }

    /**
     * @param pessoa_Email the pessoa_Email to set
     */
    public void setPessoa_Email(String pessoa_Email) {
        this.pessoa_Email = pessoa_Email;
    }

}
