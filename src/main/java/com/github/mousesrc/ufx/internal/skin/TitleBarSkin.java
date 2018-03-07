package com.github.mousesrc.ufx.internal.skin;

import com.github.mousesrc.ufx.internalWindow.TitleBar;
import com.github.mousesrc.ufx.util.FXUtils;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.image.ImageView;

public class TitleBarSkin extends SkinBase<TitleBar> {

	private Label title;
	private ImageView icon;
	private ObservableList<Node> buttons;

	public TitleBarSkin(TitleBar control) {
		super(control);
		init();
	}

	private void init() {
		icon = new ImageView(getSkinnable().getIcon());
		title = new Label(getSkinnable().getTitle(), icon);
		getChildren().add(title);
		icon.imageProperty().bind(getSkinnable().iconProperty());
		title.textProperty().bind(getSkinnable().titleProperty());
		buttons = getSkinnable().getButtons();
		buttons.addListener(new ListChangeListener<Node>() {

			@Override
			public void onChanged(Change<? extends Node> c) {
				while (c.next()) {
					getChildren().addAll(c.getAddedSubList());
					getChildren().removeAll(c.getRemoved());
				}
			}

		});
	}

	@Override
	protected double computeMinWidth(double height, double topInset, double rightInset, double bottomInset,
			double leftInset) {
		double buttonsWidth = 0;
		for (Node node : buttons)
			buttonsWidth += node.minWidth(-1);
		return leftInset + title.minWidth(-1) + buttonsWidth + rightInset;
	}

	@Override
	protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset,
			double leftInset) {
		double maxHeight = title.minHeight(-1);
		for (Node node : buttons) {
			double height = node.minHeight(-1);
			if (height > maxHeight)
				maxHeight = height;
		}
		return topInset + maxHeight + bottomInset;
	}

	@Override
	protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
		final double titleHeight = title.prefHeight(-1);
		layoutInArea(title, contentX, FXUtils.centerY(contentY, contentHeight, titleHeight),
				title.prefWidth(-1), titleHeight, 0, HPos.CENTER, VPos.CENTER);
	}

}
