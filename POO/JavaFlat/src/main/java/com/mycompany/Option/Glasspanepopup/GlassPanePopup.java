package com.mycompany.Option.Glasspanepopup;

import com.mycompany.Option.Option;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class GlassPanePopup {

    //-----------------------------------------------------------------------------------------------
    private static GlassPanePopup instance;
    //-----------------------------------------------------------------------------------------------

    private final Integer LAYER = JLayeredPane.MODAL_LAYER + 1;
    private Map<RootPaneContainer, ModalContainerLayer> map;

    //-----------------------------------------------------------------------------------------------
    private Option defaultOption;
    //-----------------------------------------------------------------------------------------------

    private GlassPanePopup() {
        map = new HashMap<>();
        
        defaultOption = Option.getDefault();
    }

    private static GlassPanePopup getInstance() {
        if (instance == null) {
            instance = new GlassPanePopup();
        }
        
        return instance;
    }

    //-----------------------------------------------------------------------------------------------
    public static void showModal(Component parentComponent, Component modal) {
        showModal(parentComponent, modal, getDefaultOption());
    }

    public static void showModal(Component parentComponent, Component modal, String id) {
        showModal(parentComponent, modal, getDefaultOption(), id);
    }

    public static void showModal(Component parentComponent, Component modal, Option option) {
        showModal(parentComponent, modal, option, null);
    }

    public static void showModal(Component parentComponent, Component modal, Option option, String id) {
        if (getInstance().isIdExist(id)) {
            throw new IllegalArgumentException("id '" + id + "' already exist");
        }
       
        
        SwingUtilities.invokeLater(() -> {
            ModalContainerLayer modalContainerLayer = getInstance().getModalContainerLayered(getRootPaneContainer(parentComponent));
            modalContainerLayer.addModal(modal, option, id);
            modalContainerLayer.repaint();
            modalContainerLayer.revalidate();
        });
    }
    //-----------------------------------------------------------------------------------------------

    public static void closeModal(String id) {
        RootPaneContainer rootPaneContainer = getInstance().getRootPaneContainerById(id);
        if (rootPaneContainer == null) {
            throw new IllegalArgumentException("id '" + id + "' not found");
        }
        ModalContainerLayer modalContainerLayer = getInstance().getModalContainerLayered(rootPaneContainer);
        modalContainerLayer.closeModal(id);
    }


    public static void closeAllModal() {
        for (Map.Entry<RootPaneContainer, ModalContainerLayer> entry : getInstance().map.entrySet()) {
            entry.getValue().closeAllModal();
        }
    }

    public static boolean isIdExist(String id) {
        for (Map.Entry<RootPaneContainer, ModalContainerLayer> entry : getInstance().map.entrySet()) {
            if (entry.getValue().checkId(id)) {
                return true;
            }
        }
        return false;
    }

    public static void setDefaultOption(Option option) {
        getInstance().defaultOption = option;
    }

    public static Option getDefaultOption() {
        return getInstance().defaultOption;
    }

    public static Option createOption() {
        return getInstance().defaultOption.copy();
    }

    protected static void closeModalAsRemove(String id) {
        RootPaneContainer rootPaneContainer = getInstance().getRootPaneContainerById(id);
        if (rootPaneContainer == null) {
            throw new IllegalArgumentException("id '" + id + "' not found");
        }
        ModalContainerLayer modalContainerLayer = getInstance().getModalContainerLayered(rootPaneContainer);
        modalContainerLayer.closeAsRemove(id);
    }

    public static RootPaneContainer getRootPaneContainer(Component component) {
        if (component == null) {
            throw new IllegalArgumentException("parent component must not null");
        }
        if (component instanceof JFrame || component instanceof JDialog || component instanceof JInternalFrame) {
            return (RootPaneContainer) component;
        }
        return getRootPaneContainer(component.getParent());
    }

    private RootPaneContainer getRootPaneContainerById(String id) {
        for (Map.Entry<RootPaneContainer, ModalContainerLayer> entry : map.entrySet()) {
            if (entry.getValue().checkId(id)) {
                return entry.getKey();
            }
        }
        return null;
    }


    /**
     * Get modal container layered or create new for windows
     */
    private ModalContainerLayer getModalContainerLayered(RootPaneContainer rootPaneContainer) {
        ModalContainerLayer modalContainerLayer;
        if (map.containsKey(rootPaneContainer)) {
            modalContainerLayer = map.get(rootPaneContainer);
        } else {
            JLayeredPane windowLayeredPane = rootPaneContainer.getLayeredPane();
            modalContainerLayer = createModalContainerLayered(rootPaneContainer);
            windowLayeredPane.add(modalContainerLayer, LAYER);
            Component snapshot = modalContainerLayer.createLayeredSnapshot();
            windowLayeredPane.add(snapshot, LAYER - 1);
            FrameModalLayout frameModalLayout = new FrameModalLayout(modalContainerLayer, rootPaneContainer.getContentPane(), snapshot);
            windowLayeredPane.setLayout(frameModalLayout);
            map.put(rootPaneContainer, modalContainerLayer);
            modalContainerLayer.setPropertyData(installProperty(rootPaneContainer.getRootPane()));
        }
        return modalContainerLayer;
    }

    private Object installProperty(JRootPane rootPane) {
        PropertyChangeListener propertyChangeListener = e -> {
            if (e.getNewValue() == null && e.getOldValue() instanceof RootPaneContainer) {
                uninstall((RootPaneContainer) e.getOldValue());
            }
        };
        rootPane.addPropertyChangeListener("ancestor", propertyChangeListener);
        return propertyChangeListener;
    }

    private void uninstall(RootPaneContainer rootPaneContainer) {
        if (map.containsKey(rootPaneContainer)) {
            ModalContainerLayer modalContainerLayer = map.get(rootPaneContainer);
            JLayeredPane windowLayeredPane = rootPaneContainer.getLayeredPane();
            rootPaneContainer.getRootPane().removePropertyChangeListener("ancestor", (PropertyChangeListener) modalContainerLayer.getPropertyData());

            // uninstall layout
            LayoutManager oldLayout = windowLayeredPane.getLayout();
            if (oldLayout != null) {
                if (oldLayout instanceof FrameModalLayout) {
                    FrameModalLayout frameModalLayout = (FrameModalLayout) oldLayout;
                    if (frameModalLayout.getOldOtherComponentLayout() != null) {
                        windowLayeredPane.setLayout(frameModalLayout.getOldOtherComponentLayout());
                    } else {
                        windowLayeredPane.setLayout(null);
                    }
                }
            }

            // remove
            map.remove(rootPaneContainer);
            windowLayeredPane.remove(modalContainerLayer);
            Component componentSnapshot = modalContainerLayer.getComponentSnapshot();
            if (componentSnapshot != null) {
                windowLayeredPane.remove(modalContainerLayer.getComponentSnapshot());
            }
            modalContainerLayer.remove();
        }
    }

    private ModalContainerLayer createModalContainerLayered(RootPaneContainer rootPaneContainer) {
        ModalContainerLayer layeredPane = new ModalContainerLayer(rootPaneContainer);
        layeredPane.setVisible(false);
        return layeredPane;
    }
}
