package com.github.mousesrc.ufx.control.window;

import com.github.mousesrc.ufx.internal.skin.window.DesktopPaneSkin;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class DesktopPane extends Control implements WindowContainer {

	private final ObservableList<InternalWindow> windows = FXCollections.observableArrayList();
	public final ObservableList<InternalWindow> getWindows() {
		return windows;
	}
	
	public DesktopPane() {
		getStyleClass().setAll("desktop-pane");
	}
	
	@Override
	protected Skin<?> createDefaultSkin() {
		return new DesktopPaneSkin(this);
	}
	
	public static class Divider extends Control {
		
	    private ObjectProperty<Orientation> orientation;
	    public final void setOrientation(Orientation value) {
	        orientationProperty().set(value);
	    };
	    public final Orientation getOrientation() {
	        return orientation == null ? Orientation.HORIZONTAL : orientation.get();
	    }
	    public final ObjectProperty<Orientation> orientationProperty() {
	        if (orientation == null)
	            orientation = new SimpleObjectProperty<>(this, "orientation");
	        return orientation;
	    }
	    
		private final ObservableList<InternalWindow> leftAndTopWindows = FXCollections.observableArrayList();
		public ObservableList<InternalWindow> getLeftAndTopWindows() {
			return leftAndTopWindows;
		}
		
		private final ObservableList<InternalWindow> rightAndBottomWindows = FXCollections.observableArrayList();
		public ObservableList<InternalWindow> getRightAndBottomWindows() {
			return rightAndBottomWindows;
		}
		
		public Divider() {
			getStyleClass().add("divider");
		}
	}
}
