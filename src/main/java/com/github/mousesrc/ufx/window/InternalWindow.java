package com.github.mousesrc.ufx.window;

import com.github.mousesrc.ufx.internal.skin.InternalWindowSkin;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class InternalWindow extends Control{
	
	private ObjectProperty<Node> content;
	public final ObjectProperty<Node> contentProperty() {
		if(content == null)
			content = new SimpleObjectProperty<>(this,"content");
		return content;
	}
	public final Node getContent() {
		return content == null ? null : content.get();
	}
	public final void setContent(Node node) {
		contentProperty().set(node);
	}
	
	private BooleanProperty movable;
	public final BooleanProperty movableProperty() {
		if(movable == null)
			movable = new SimpleBooleanProperty(this, "movable");
		return movable;
	}
	public final boolean isMovable() {
		return movable == null ? true : movable.get();
	}
	public final void setMovable(boolean movable) {
		movableProperty().set(movable);
	}
	
	public InternalWindow() {
		getStyleClass().add("internal-window");
	}
	
	public void close() {
		Parent parent = getParent();
		if (parent instanceof WindowContainer)
			((WindowContainer) parent).getWindows().remove(this);
	}

	@Override
	protected Skin<?> createDefaultSkin() {
		return new InternalWindowSkin(this);
	}

}
