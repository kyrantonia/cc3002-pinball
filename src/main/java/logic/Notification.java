package logic;

import logic.table.Visitor;

/**
 * Representa la notificación que se recibe en el update de Table
 * @author Kyra
 */
public interface Notification {
    /**
     * Método utilizado en visitor pattern,
     * el cual permite que un visitor llame al método que ejecuta la acción deseada
     * @param visitor Visitor
     */
    public void accept(Visitor visitor);

}
