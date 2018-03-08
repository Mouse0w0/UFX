package com.github.mousesrc.ufx.window;

import com.github.mousesrc.ufx.internal.skin.DesktopPaneSkin;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class DesktopPane extends Control implements WindowContainer{
	
	private BooleanProperty autoResize;
	public final BooleanProperty autoResizeProperty() {
		if(autoResize == null)
			autoResize = new SimpleBooleanProperty(this, "autoResize");
		return autoResize;
	}
	public final boolean isAutoResize() {
		return autoResize == null ? true : autoResize.get();
	}
	public final void setAutoResize(boolean value) {
		autoResizeProperty().set(value);
	}

	private final ObservableList<InternalWindow> windows = FXCollections.observableArrayList();
	public final ObservableList<InternalWindow> getWindows() {
		return windows;
	}
	
	public DesktopPane() {
		getStyleClass().add("desktop-pane");
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
