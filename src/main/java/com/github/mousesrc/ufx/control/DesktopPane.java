package com.github.mousesrc.ufx.control;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;

public class DesktopPane extends Control{
	
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
}
