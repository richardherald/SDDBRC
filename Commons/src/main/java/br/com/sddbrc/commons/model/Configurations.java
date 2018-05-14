package br.com.sddbrc.commons.model;

public class Configurations {

    private Integer configuration_Id;
    private String configuration_Username;
    private String configuration_Password;
    private String configuration_Poolname;
    private String configuration_Jdbcurl;
    private Integer configuration_Maxpoolsize;
    private Integer configuration_Cachesize;
    private Integer configuration_Cachesizelimit;
    private String configuration_DriverClassName;

    public Configurations() {
    }

    public Configurations(Integer configuration_Id, String configuration_Username, String configuration_Password, String configuration_Poolname, String configuration_Jdbcurl, Integer configuration_Maxpoolsize, Integer configuration_Cachesize, Integer configuration_Cachesizelimit, String configuration_DriverClassName) {
        this.configuration_Id = configuration_Id;
        this.configuration_Username = configuration_Username;
        this.configuration_Password = configuration_Password;
        this.configuration_Poolname = configuration_Poolname;
        this.configuration_Jdbcurl = configuration_Jdbcurl;
        this.configuration_Maxpoolsize = configuration_Maxpoolsize;
        this.configuration_Cachesize = configuration_Cachesize;
        this.configuration_Cachesizelimit = configuration_Cachesizelimit;
        this.configuration_DriverClassName = configuration_DriverClassName;
    }

    /**
     * @return the configuration_Id
     */
    public Integer getConfiguration_Id() {
        return configuration_Id;
    }

    /**
     * @param configuration_Id the configuration_Id to set
     */
    public void setConfiguration_Id(Integer configuration_Id) {
        this.configuration_Id = configuration_Id;
    }

    /**
     * @return the configuration_Username
     */
    public String getConfiguration_Username() {
        return configuration_Username;
    }

    /**
     * @param configuration_Username the configuration_Username to set
     */
    public void setConfiguration_Username(String configuration_Username) {
        this.configuration_Username = configuration_Username;
    }

    /**
     * @return the configuration_Password
     */
    public String getConfiguration_Password() {
        return configuration_Password;
    }

    /**
     * @param configuration_Password the configuration_Password to set
     */
    public void setConfiguration_Password(String configuration_Password) {
        this.configuration_Password = configuration_Password;
    }

    /**
     * @return the configuration_Poolname
     */
    public String getConfiguration_Poolname() {
        return configuration_Poolname;
    }

    /**
     * @param configuration_Poolname the configuration_Poolname to set
     */
    public void setConfiguration_Poolname(String configuration_Poolname) {
        this.configuration_Poolname = configuration_Poolname;
    }

    /**
     * @return the configuration_Jdbcurl
     */
    public String getConfiguration_Jdbcurl() {
        return configuration_Jdbcurl;
    }

    /**
     * @param configuration_Jdbcurl the configuration_Jdbcurl to set
     */
    public void setConfiguration_Jdbcurl(String configuration_Jdbcurl) {
        this.configuration_Jdbcurl = configuration_Jdbcurl;
    }

    /**
     * @return the configuration_Maxpoolsize
     */
    public Integer getConfiguration_Maxpoolsize() {
        return configuration_Maxpoolsize;
    }

    /**
     * @param configuration_Maxpoolsize the configuration_Maxpoolsize to set
     */
    public void setConfiguration_Maxpoolsize(Integer configuration_Maxpoolsize) {
        this.configuration_Maxpoolsize = configuration_Maxpoolsize;
    }

    /**
     * @return the configuration_Cachesize
     */
    public Integer getConfiguration_Cachesize() {
        return configuration_Cachesize;
    }

    /**
     * @param configuration_Cachesize the configuration_Cachesize to set
     */
    public void setConfiguration_Cachesize(Integer configuration_Cachesize) {
        this.configuration_Cachesize = configuration_Cachesize;
    }

    /**
     * @return the configuration_Cachesizelimit
     */
    public Integer getConfiguration_Cachesizelimit() {
        return configuration_Cachesizelimit;
    }

    /**
     * @param configuration_Cachesizelimit the configuration_Cachesizelimit to
     * set
     */
    public void setConfiguration_Cachesizelimit(Integer configuration_Cachesizelimit) {
        this.configuration_Cachesizelimit = configuration_Cachesizelimit;
    }

    /**
     * @return the configuration_DriverClassName
     */
    public String getConfiguration_DriverClassName() {
        return configuration_DriverClassName;
    }

    /**
     * @param configuration_DriverClassName the configuration_DriverClassName to
     * set
     */
    public void setConfiguration_DriverClassName(String configuration_DriverClassName) {
        this.configuration_DriverClassName = configuration_DriverClassName;
    }

}
