package viagens.web.api.handler;

public class NotFoundException extends BusinessException {

    public NotFoundException(Long id) {
        super("Id %d não encontrado", id);
    }
}
