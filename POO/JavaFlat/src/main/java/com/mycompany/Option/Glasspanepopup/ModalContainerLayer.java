package com.mycompany.Option.Glasspanepopup;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatTitlePane;
import com.mycompany.Option.FullContentLayout;
import com.mycompany.Option.Option;

import javax.swing.*;
import java.awt.*;
import java.awt.image.VolatileImage;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Raven
 */
public class ModalContainerLayer extends JLayeredPane {

    private final RootPaneContainer rootPaneContainer;
    private Component componentSnapshot;
    private boolean isShowSnapshot;
    private Set<ModalContainer> setModalContainer;
    private JLayeredPane layeredSnapshot;
    private Object propertyData;

    public ModalContainerLayer(RootPaneContainer rootPaneContainer) {
        this.rootPaneContainer = rootPaneContainer;
        init();
    }

    private void init() {
        setModalContainer = new HashSet<>();
        setLayout(new FullContentLayout());
    }

    public void addModal(Component modal, Option option, String id) {
        addModalWithoutShowing(modal, option, id).showModal();
    }

    public ModalContainer addModalWithoutShowing(Component modal, Option option, String id) {
        ModalContainer modalContainer = new ModalContainer(this, option, id);
        modalContainer.setComponentOrientation(modal.getComponentOrientation());
        setLayer(modalContainer, JLayeredPane.MODAL_LAYER + (option.getLayoutOption().isOnTop() ? 1 : 0));
        add(modalContainer, 0);
        modalContainer.addModal(modal);
        if (rootPaneContainer.getRootPane().getComponentOrientation().isLeftToRight() != modalContainer.getComponentOrientation().isLeftToRight()) {
            modalContainer.applyComponentOrientation(rootPaneContainer.getRootPane().getComponentOrientation());
        }
        setModalContainer.add(modalContainer);
        return modalContainer;
    }

    public void closeModal(String id) {
        ModalContainer con = getModalContainerById(id);
        con.closeModal();
    }

  
    public void closeAllModal() {
        for (ModalContainer con : setModalContainer) {
            con.closeModal();
        }
        setModalContainer.clear();
    }

    public void closeAsRemove(String id) {
        ModalContainer con = getModalContainerById(id);
        con.close();
    }

    public void closeAllAsRemove() {
        for (ModalContainer con : setModalContainer) {
            con.close();
        }
        setModalContainer.clear();
    }

    private ModalContainer getModalContainerById(String id) {
        for (ModalContainer con : setModalContainer) {
            if (con.getId() != null && con.getId().equals(id)) {
                return con;
            }
        }
        throw new IllegalArgumentException("id '" + id + "' not found");
    }

    

    protected void showSnapshot() {
        if (isShowSnapshot) {
            return;
        }
        isShowSnapshot = true;
        Component contentPane = rootPaneContainer.getContentPane();
        VolatileImage snapshot = contentPane.createVolatileImage(rootPaneContainer.getLayeredPane().getWidth(), rootPaneContainer.getLayeredPane().getHeight());
        if (snapshot == null) {
            return;
        }
        boolean isFullWindowContent = FlatClientProperties.clientPropertyBoolean(rootPaneContainer.getRootPane(), FlatClientProperties.FULL_WINDOW_CONTENT, false);
        Graphics g = snapshot.createGraphics();
        int y = contentPane.getY();
        if (!isFullWindowContent) {
            y -= getY();
        }
        g.translate(contentPane.getX(), y);
        contentPane.paint(g);
        g.dispose();

        // if rootPane use `full window content` as true, paint flatlaf title to snapshot
        if (isFullWindowContent) {
            drawTitleBarToSnapshot(snapshot);
        }
        componentSnapshot = new JComponent() {
            @Override
            public void paint(Graphics g) {
                if (snapshot.contentsLost()) {
                    return;
                }
                g.drawImage(snapshot, 0, 0, null);
                g.dispose();
            }

            @Override
            public void removeNotify() {
                super.removeNotify();
                snapshot.flush();
            }
        };
        layeredSnapshot.setVisible(true);
        contentPane.setVisible(false);

        layeredSnapshot.add(componentSnapshot);
    }

    protected void hideSnapshot() {
        layeredSnapshot.setVisible(false);
        rootPaneContainer.getContentPane().setVisible(true);

        layeredSnapshot.remove(componentSnapshot);
        isShowSnapshot = false;
    }

    private void drawTitleBarToSnapshot(VolatileImage snapshot) {
        for (Component com : rootPaneContainer.getLayeredPane().getComponents()) {
            if (com instanceof FlatTitlePane) {
                Graphics g = snapshot.createGraphics();
                g.translate(com.getX(), com.getY());
                com.paint(g);
                g.dispose();
            }
        }
    }

    public boolean checkId(String id) {
        for (ModalContainer con : setModalContainer) {
            if (con.getId() != null && con.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Set<ModalContainer> getSetModalContainer() {
        return setModalContainer;
    }

    public RootPaneContainer getRootPaneContainer() {
        return rootPaneContainer;
    }

    public JLayeredPane createLayeredSnapshot() {
        if (layeredSnapshot == null) {
            layeredSnapshot = new JLayeredPane();
            layeredSnapshot.setVisible(false);
            layeredSnapshot.setLayout(new FullContentLayout());
        }
        return layeredSnapshot;
    }

    protected void removeContainer(ModalContainer container) {
        remove(container);
        setModalContainer.remove(container);
        if (setModalContainer.isEmpty()) {
            setVisible(false);
        }
    }

    public Object getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(Object propertyData) {
        this.propertyData = propertyData;
    }

    public Component getComponentSnapshot() {
        return componentSnapshot;
    }

    public void remove() {
        closeAllAsRemove();
        componentSnapshot = null;
        setModalContainer = null;
        layeredSnapshot = null;
        propertyData = null;
    }
}
