package logic.gameelements;

import controller.Visitor;

public interface GameElement {
    public void accept(Visitor visitor);
}
