
package br.com.commons.model;

public class Configurations {
    private Integer configuration_Id;
    private String configuration_Username;
    private String configuration_Password;
    private String configuration_Poolname;
    private String configuration_PoolJdbcurl;
    private Integer configuration_Maxpoolsize;
    private Integer configuration_Cachesize;
    private Integer configuration_Cachesizelimit;

    public Configurations() {
    }

    public Configurations(Integer configuration_Id, String configuration_Username, String configuration_Password, Integer configuration_Maxpoolsize, Integer configuration_Cachesize, Integer configuration_Cachesizelimit) {
        this.configuration_Id = configuration_Id;
        this.configuration_Username = configuration_Username;
        this.configuration_Password = configuration_Password;
        this.configuration_Maxpoolsize = configuration_Maxpoolsize;
        this.configuration_Cachesize = configuration_Cachesize;
        this.configuration_Cachesizelimit = configuration_Cachesizelimit;
    }

    public Integer getConfiguration_Id() {
        return configuration_Id;
    }

    public void setConfiguration_Id(Integer configuration_Id) {
        this.configuration_Id = configuration_Id;
    }

    public String getConfiguration_Username() {
        return configuration_Username;
    }

    public void setConfiguration_Username(String configuration_Username) {
        this.configuration_Username = configuration_Username;
    }

    public String getConfiguration_Password() {
        return configuration_Password;
    }

    public void setConfiguration_Password(String configuration_Password) {
        this.configuration_Password = configuration_Password;
    }

    public String getConfiguration_Poolname() {
        return configuration_Poolname;
    }

    public void setConfiguration_Poolname(String configuration_Poolname) {
        this.configuration_Poolname = configuration_Poolname;
    }

    public String getConfiguration_PoolJdbcurl() {
        return configuration_PoolJdbcurl;
    }

    public void setConfiguration_PoolJdbcurl(String configuration_PoolJdbcurl) {
        this.configuration_PoolJdbcurl = configuration_PoolJdbcurl;
    }

    public Integer getConfiguration_Maxpoolsize() {
        return configuration_Maxpoolsize;
    }

    public void setConfiguration_Maxpoolsize(Integer configuration_Maxpoolsize) {
        this.configuration_Maxpoolsize = configuration_Maxpoolsize;
    }

    public Integer getConfiguration_Cachesize() {
        return configuration_Cachesize;
    }

    public void setConfiguration_Cachesize(Integer configuration_Cachesize) {
        this.configuration_Cachesize = configuration_Cachesize;
    }

    public Integer getConfiguration_Cachesizelimit() {
        return configuration_Cachesizelimit;
    }

    public void setConfiguration_Cachesizelimit(Integer configuration_Cachesizelimit) {
        this.configuration_Cachesizelimit = configuration_Cachesizelimit;
    }

    
    
}
