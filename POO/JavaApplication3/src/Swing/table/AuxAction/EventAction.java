package Swing.table.AuxAction;

import Swing.table.Objeto.Data;

public interface EventAction {

    public void delete(Data student);

    public void update(Data student);
    
    public void view(Data student);
}
