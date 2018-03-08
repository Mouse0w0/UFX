package com.github.mousesrc.ufx.window;

import com.github.mousesrc.ufx.internal.skin.BorderDesktopPaneSkin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class BorderDesktopPane extends Control implements WindowContainer{
	
	private final ObservableList<InternalWindow> windows = FXCollections.observableArrayList();
	public final ObservableList<InternalWindow> getWindows() {
		return windows;
	}
	
	public BorderDesktopPane() {
		getStyleClass().add("border-desktop-pane");
	}
	
	@Override
	protected Skin<?> createDefaultSkin() {
		return new BorderDesktopPaneSkin(this);
	}

}
