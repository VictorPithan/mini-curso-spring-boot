package br.com.victorpithan.minicursojavaspringsolid.services.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message, int id) {
        super(message + " Id -> " + id);
    }

    public NotFoundException(int id) {
        super("Recurso não encontrado. Id -> " + id);
    }

}
