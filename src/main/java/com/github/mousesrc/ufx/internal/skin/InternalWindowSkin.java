package com.github.mousesrc.ufx.internal.skin;

import com.github.mousesrc.ufx.window.InternalWindow;

import javafx.scene.control.SkinBase;

public class InternalWindowSkin extends SkinBase<InternalWindow>{

	public InternalWindowSkin(InternalWindow control) {
		super(control);
	}
	
	@Override
	protected double computeMinWidth(double height, double topInset, double rightInset, double bottomInset,
			double leftInset) {
		// TODO 自动生成的方法存根
		return super.computeMinWidth(height, topInset, rightInset, bottomInset, leftInset);
	}
	
	@Override
	protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset,
			double leftInset) {
		// TODO 自动生成的方法存根
		return super.computeMinHeight(width, topInset, rightInset, bottomInset, leftInset);
	}
}
