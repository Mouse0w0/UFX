package com.github.mousesrc.ufx.control.window;

import com.github.mousesrc.ufx.internal.skin.window.InternalWindowSkin;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;

public class InternalWindow extends Control {
	
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
	public final ObjectProperty<Image> iconProperty() {
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
	
	private ObjectProperty<Node> content;
	public final ObjectProperty<Node> contentProperty() {
		if(content == null)
			content = new SimpleObjectProperty<>(this, "content");
		return content;
	}
	public final Node getContent() {
		return content == null ? null : content.get();
	}
	public final void setContent(Node node) {
		contentProperty().set(node);
	}
	
	private BooleanProperty showTitleBar;
	public final BooleanProperty showTitleBarProperty() {
		if(showTitleBar == null)
			showTitleBar = new SimpleBooleanProperty(this, "showTitleBar");
		return showTitleBar; 
	}
	public final boolean isShowTitleBar() {
		return showTitleBar == null ? true : showTitleBar.get();
	}
	public final void setShowTitleBar(boolean showTitleBar) {
		showTitleBarProperty().set(showTitleBar);
	}
	
	private BooleanProperty alwaysOnTop;
	public final BooleanProperty alwaysOnTopProperty() {
		if(alwaysOnTop == null)
			alwaysOnTop = new SimpleBooleanProperty(this, "alwaysOnTop");
		return alwaysOnTop;
	}
	public final boolean isAlwaysOnTop() {
		return alwaysOnTop == null ? false : alwaysOnTop.get();
	}
	public final void setAlwaysOnTop(boolean alwaysOnTop) {
		alwaysOnTopProperty().set(alwaysOnTop);
	}
	
	private BooleanProperty closable;
	public final BooleanProperty closableProperty() {
		if(closable == null)
			closable = new SimpleBooleanProperty(this, "closable");
		return closable;
	}
	public final boolean isClosable() {
		return closable == null ? true : closable.get();
	}
	public final void setClosable(boolean closable) {
		closableProperty().set(closable);
	}
	
	private BooleanProperty maximizable;
	public final BooleanProperty maximizableProperty() {
		if(maximizable == null)
			maximizable = new SimpleBooleanProperty(this, "maximizable");
		return maximizable;
	}
	public final boolean isMaximizable() {
		return maximizable == null ? true : maximizable.get();
	}
	public final void setMaximizable(boolean maximizable) {
		maximizableProperty().set(maximizable);
	}
	
	private BooleanProperty minimizable;
	public final BooleanProperty minimizableProperty() {
		if(minimizable == null)
			minimizable = new SimpleBooleanProperty(this, "minimizable");
		return minimizable;
	}
	public final boolean isMinimizable() {
		return minimizable == null ? true : minimizable.get();
	}
	public final void setMinimizable(boolean minimizable) {
		minimizableProperty().set(minimizable);
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
	
	private BooleanProperty windowResizable;
	public final BooleanProperty windowResizableProperty() {
		if(windowResizable == null)
			windowResizable = new SimpleBooleanProperty(this, "windowResizable");
		return windowResizable;
	}
	public final boolean isWindowResizable() {
		return windowResizable == null ? true : windowResizable.get();
	}
	public final void setWindowResizable(boolean resizable) {
		windowResizableProperty().set(resizable);
	}
	
	private ReadOnlyBooleanWrapper maximized;
	protected final ReadOnlyBooleanWrapper maximizedPropertyImpl() {
		if(maximized == null)
			maximized = new ReadOnlyBooleanWrapper(this, "maximized");
		return maximized;
	}
	public final ReadOnlyBooleanProperty maximizedProperty() {
		return maximizedPropertyImpl().getReadOnlyProperty();
	}
	public final boolean isMaximized() {
		return maximized == null ? false : maximized.get();
	}
	
	private ReadOnlyBooleanWrapper minimized;
	protected final ReadOnlyBooleanWrapper minimizedPropertyImpl() {
		if(minimized == null)
			minimized = new ReadOnlyBooleanWrapper(this, "minimized");
		return minimized;
	}
	public final ReadOnlyBooleanProperty minimizedProperty() {
		return minimizedPropertyImpl().getReadOnlyProperty();
	}
	public final boolean isMinimized() {
		return minimized == null ? false : minimized.get();
	}
	
	public InternalWindow() {
		getStyleClass().setAll("internal-window");
	}
	
	public void setMaximum(boolean maximum) {
		maximizedPropertyImpl().set(maximum);
	}
	
	public void setMinimum(boolean minimum) {
		if (minimum) {
			setVisible(false);
		} else {
			setVisible(true);
		}
		minimizedPropertyImpl().set(minimum);
	}
	
	public void center() {
		
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
