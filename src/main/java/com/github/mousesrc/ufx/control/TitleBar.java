package com.github.mousesrc.ufx.control;

import java.util.LinkedList;

import com.github.mousesrc.ufx.internal.control.skin.TitleBarSkin;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;

public class TitleBar extends Control {
	
	private StringProperty title;
	public final StringProperty titleProperty() {
		if(title == null)
			title = new SimpleStringProperty(this, "title");
		return title;
	}
	public final String getTitle() {
		return title == null ? null : title.get();
	}
	public final void setTitle(String title) {
		titleProperty().set(title);
	}
	
	private ObjectProperty<Image> icon;
	public final ObjectProperty<Image> iconProperty(){
		if(icon == null)
			icon = new SimpleObjectProperty<>(this, "icon");
		return icon;
	}
	public final Image getIcon() {
		return icon == null ? null : icon.get();
	}
	public final void setIcon(Image icon) {
		iconProperty().set(icon);
	}
	
	private final ObservableList<Node> buttons = FXCollections.observableList(new LinkedList<>());
	public ObservableList<Node> getButtons() {
		return buttons;
	}
	
	public TitleBar() {
		getStyleClass().add("title-bar");
	}
	
	@Override
	protected Skin<?> createDefaultSkin() {
		return new TitleBarSkin(this);
	}
}
