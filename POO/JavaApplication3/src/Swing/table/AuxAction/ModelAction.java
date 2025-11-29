package Swing.table.AuxAction;

import Swing.table.AuxAction.EventAction;
import Swing.table.Objeto.Data;

public class ModelAction {

    public Data getDatos() {
        return Datos;
    }

    public void setDatos(Data data) {
        this.Datos = data;
    }

    public EventAction getEvent() {
        return event;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

    public ModelAction(Data student, EventAction event) {
        this.Datos = student;
        this.event = event;
    }

    public ModelAction() {
    }

    private Data Datos;
    private EventAction event;
}
