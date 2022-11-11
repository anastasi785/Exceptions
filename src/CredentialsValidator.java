import java.util.Objects;

public class CredentialsValidator {
    private static final String INVALID_lENGTH="Длина может быть от 1 до 20";
    private static final String INVALID_SYMBOL=
            "Строка должна содержать только латинские буквы, цифры или знак подчёркивания";
    private static final String PASSWORDS_NOT_MATCH="Пароль и подтверждение пароля не совпадают";

    public static boolean validateCredentials(String login,
                                              String password,
                                              String confirmPassword){
        if (isLenghtNotRange(login,1,20)){
            throw new WrongLoginException(INVALID_lENGTH);
        }
        if(isSymbolNotValid(login)){
            throw new WrongLoginException(INVALID_SYMBOL);
        }
        if (isLenghtNotRange(password,1,20)){
            throw new WrongPasswordException(INVALID_lENGTH);
        }
        if(isSymbolNotValid(password)){
            throw new WrongPasswordException(INVALID_SYMBOL);
        }
        if(!Objects.equals(password,confirmPassword)){
            throw new WrongPasswordException(PASSWORDS_NOT_MATCH);
        }
        return true;

    }
    private static boolean isValid(String value){
        if (value==null||value.isEmpty()){
            return false;
        }
        return value.matches("^[a-zA-Z0-9]{1,20}");
    }
    private static boolean isLenghtNotRange(String value,int min,int max){
        if(value==null){
            return true;
        }
        int length=value.length();
        return length<min||length>max;
    }
    private static boolean isSymbolNotValid(String value){
        if(value==null||value.isEmpty()){
            return true;
        }
        for (char c:value.toCharArray()){
            boolean symbolMatches=(c>='a'&&c<='z')
                    ||(c>='A'&&c<='Z')
                    ||(Character.isDigit(c))
                    ||(c=='_');
            if(!symbolMatches){
                return true;

            }
        }
        return false;
    }

}
