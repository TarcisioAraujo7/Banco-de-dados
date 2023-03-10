public class Conexão{
    static String driverJDBC = "org.postgresql.Driver";
    static String url = "";
    static String user = "";
    static String senha = "";

    public static void main(String[] args){
        String instrucaoSQL = "SELECT * FROM usuario";
        try {
            Class.forName(driverJDBC);
            Connection conexao = DriverManager.getConnection(url,user,senha);
            Statement st = conexao.createStatement();
            ResultSet result = st.executeQuery(instrucaoSQL);

            System.out.println(result);

            result.close();
            st.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}