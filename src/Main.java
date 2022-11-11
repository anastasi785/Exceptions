public class Main {
    public static void main(String[] args) {
        System.out.println(checkCredentials("login","password","password"));
        System.out.println(checkCredentials("LOGIN","PASSWORD","PASSWORD"));
        System.out.println(checkCredentials("LOgin_","paSSwO_rd","paSSwO_rd"));
        System.out.println(checkCredentials("Login!","password","password"));


    }
    public static boolean checkCredentials(String login,String password,String confirmPassword){
        try{
            return  CredentialsValidator.validateCredentials(login,password,confirmPassword);
        } catch (WrongLoginException e){
            System.out.println("ошибка при валидации логина "+e.getMessage());
            return false;
        }catch (WrongPasswordException e){
            System.out.println("Ошибка при валидации пароля "+e.getMessage());
            return false;
        }
    }
}