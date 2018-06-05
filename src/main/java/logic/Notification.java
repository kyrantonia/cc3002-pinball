package logic;

import logic.table.Visitor;

public interface Notification {
    public void accept(Visitor visitor);

}
