package com.github.mousesrc.ufx.control;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.control.Control;

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
	
	public InternalWindow() {
		getStyleClass().add("internal-window");
	}

}
