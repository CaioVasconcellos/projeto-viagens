package viagens.web.api.handler;

public class RequiredFieldException extends BusinessException{

    public RequiredFieldException(String campo) {
        super("Campo %s obrigatório", campo);
    }
}
