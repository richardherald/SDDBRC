package br.com.repositorios.model;

public class ConfigBanco {

    private String configBanco_PoolName;
    private String configBanco_JdbcUrl;
    private String configBanco_Username;
    private String configBanco_Password;
    private int configBanco_MaximumPoolSize;
    private int configBanco_ConnectionTimeout;
    private int configBanco_CacheSize;
    private int configBanco_CacheSizeLimit;

    /**
     * @return the configBanco_PoolName
     */
    public String getConfigBanco_PoolName() {
        return configBanco_PoolName;
    }

    /**
     * @param configBanco_PoolName the configBanco_PoolName to set
     */
    public void setConfigBanco_PoolName(String configBanco_PoolName) {
        this.configBanco_PoolName = configBanco_PoolName;
    }

    /**
     * @return the configBanco_JdbcUrl
     */
    public String getConfigBanco_JdbcUrl() {
        return configBanco_JdbcUrl;
    }

    /**
     * @param configBanco_JdbcUrl the configBanco_JdbcUrl to set
     */
    public void setConfigBanco_JdbcUrl(String configBanco_JdbcUrl) {
        this.configBanco_JdbcUrl = configBanco_JdbcUrl;
    }

    /**
     * @return the configBanco_Username
     */
    public String getConfigBanco_Username() {
        return configBanco_Username;
    }

    /**
     * @param configBanco_Username the configBanco_Username to set
     */
    public void setConfigBanco_Username(String configBanco_Username) {
        this.configBanco_Username = configBanco_Username;
    }

    /**
     * @return the configBanco_Password
     */
    public String getConfigBanco_Password() {
        return configBanco_Password;
    }

    /**
     * @param configBanco_Password the configBanco_Password to set
     */
    public void setConfigBanco_Password(String configBanco_Password) {
        this.configBanco_Password = configBanco_Password;
    }

    /**
     * @return the configBanco_MaximumPoolSize
     */
    public int getConfigBanco_MaximumPoolSize() {
        return configBanco_MaximumPoolSize;
    }

    /**
     * @param configBanco_MaximumPoolSize the configBanco_MaximumPoolSize to set
     */
    public void setConfigBanco_MaximumPoolSize(int configBanco_MaximumPoolSize) {
        this.configBanco_MaximumPoolSize = configBanco_MaximumPoolSize;
    }

    /**
     * @return the configBanco_ConnectionTimeout
     */
    public int getConfigBanco_ConnectionTimeout() {
        return configBanco_ConnectionTimeout;
    }

    /**
     * @param configBanco_ConnectionTimeout the configBanco_ConnectionTimeout to
     * set
     */
    public void setConfigBanco_ConnectionTimeout(int configBanco_ConnectionTimeout) {
        this.configBanco_ConnectionTimeout = configBanco_ConnectionTimeout;
    }

    /**
     * @return the configBanco_CacheSize
     */
    public int getConfigBanco_CacheSize() {
        return configBanco_CacheSize;
    }

    /**
     * @param configBanco_CacheSize the configBanco_CacheSize to set
     */
    public void setConfigBanco_CacheSize(int configBanco_CacheSize) {
        this.configBanco_CacheSize = configBanco_CacheSize;
    }

    /**
     * @return the configBanco_CacheSizeLimit
     */
    public int getConfigBanco_CacheSizeLimit() {
        return configBanco_CacheSizeLimit;
    }

    /**
     * @param configBanco_CacheSizeLimit the configBanco_CacheSizeLimit to set
     */
    public void setConfigBanco_CacheSizeLimit(int configBanco_CacheSizeLimit) {
        this.configBanco_CacheSizeLimit = configBanco_CacheSizeLimit;
    }

}
