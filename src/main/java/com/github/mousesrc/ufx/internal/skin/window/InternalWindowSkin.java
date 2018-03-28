package com.github.mousesrc.ufx.internal.skin.window;

import com.github.mousesrc.ufx.control.window.InternalWindow;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class InternalWindowSkin extends SkinBase<InternalWindow>{

	private Node content;
	protected TitleBar titleBar;
	
	public InternalWindowSkin(InternalWindow control) {
		super(control);
		init();
	}
	
	private void init() {
		
	}
	
	@Override
	protected double computeMinWidth(double height, double topInset, double rightInset, double bottomInset,
			double leftInset) {
		return leftInset
				+ Math.min(content == null ? 0 : content.minWidth(-1), titleBar == null ? 0 : titleBar.minWidth(-1))
				+ rightInset;
	}

	@Override
	protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset,
			double leftInset) {
		return topInset + (titleBar == null ? 0 : titleBar.minHeight(-1))
				+ (content == null ? 0 : content.minHeight(-1)) + bottomInset;
	}
	
	@Override
	protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset,
			double leftInset) {
		return computeMinWidth(height, topInset, rightInset, bottomInset, leftInset);
	}
	
	@Override
	protected double computePrefHeight(double width, double topInset, double rightInset, double bottomInset,
			double leftInset) {
		return computeMinHeight(width, topInset, rightInset, bottomInset, leftInset);
	}
	
	@Override
	protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
		double titleBarHeight = 0;
		if (titleBar != null && titleBar.isManaged()) {
			titleBarHeight = titleBar.prefHeight(-1);
			layoutInArea(titleBar, contentX, contentY, contentWidth, titleBarHeight, -1, HPos.CENTER, VPos.CENTER);
		}
		if (content != null && content.isManaged())
			layoutInArea(titleBar, contentX, contentY, contentWidth, contentHeight - titleBarHeight, -1, HPos.CENTER,
					VPos.CENTER);
	}
	
	private class TitleBar extends Region {
		
		private HBox rightNodes;
		
		public TitleBar() {
			getStyleClass().setAll("title-bar");
		}
		
		@Override
		protected double computeMinWidth(double height) {
			return super.computeMinWidth(height);
		}
		
		@Override
		protected double computeMinHeight(double width) {
			return super.computeMinHeight(width);
		}
	}
}
