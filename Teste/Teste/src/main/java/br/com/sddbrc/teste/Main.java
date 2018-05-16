package br.com.sddbrc.teste;

public class Main {
    
    private static Platform platform = new Platform();
    private static JDBC jdbc = new JDBC();
    
    public static void main(String[] args) throws Exception {
        platform.stressPlataformaInsert(1000);
//        jdbc.stressJDBCInsert(1000);
    }
}
