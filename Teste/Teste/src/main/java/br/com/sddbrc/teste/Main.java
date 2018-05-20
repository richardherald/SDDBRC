package br.com.sddbrc.teste;

public class Main {
    
    private static Platform platform = new Platform();
    private static JDBC jdbc = new JDBC();
    
    public static void main(String[] args) throws Exception {
        platform.stressPlataformaInsert(25);
//        jdbc.stressJDBCInsert(100);
    }
}
