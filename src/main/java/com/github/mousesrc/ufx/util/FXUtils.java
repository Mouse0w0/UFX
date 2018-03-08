package com.github.mousesrc.ufx.util;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Window;

public interface FXUtils {
	
	static Point2D getRelativePos(Parent parent, Node node) {
		Point2D parentScreenPos = getScreenPos(parent);
		Point2D nodeScreenPos = getScreenPos(node);
		return new Point2D(nodeScreenPos.getX() - parentScreenPos.getX(),
				nodeScreenPos.getY() - parentScreenPos.getY());
	}

	static Point2D getScreenPos(Node node) {
		Point2D localToScene = node.localToScene(0, 0);
		Scene scene = node.getScene();
		Window window = scene.getWindow();
		return new Point2D(localToScene.getX() + scene.getX() + window.getX(),
				localToScene.getY() + scene.getY() + window.getY());
	}

	static Bounds addBounds2D(Bounds bounds, double x, double y) {
		return new BoundingBox(bounds.getMinX() + x, bounds.getMinY() + y, bounds.getWidth(), bounds.getHeight());
	}

	static Bounds subtractBounds2D(Bounds bounds, double x, double y) {
		return new BoundingBox(bounds.getMinX() - x, bounds.getMinY() - y, bounds.getWidth(), bounds.getHeight());
	}
	
	static double centerX(double contentX, double contentWidth, double nodeWidth) {
		return contentX + (contentWidth - nodeWidth) / 2.;
	}
	
	static double centerY(double contentY, double contentHeight, double nodeHeight) {
		return contentY + (contentHeight - nodeHeight) / 2.;
	}
	
	static void remove(Node node) {
		Parent parent = node.getParent();
		if(parent instanceof Pane)
			((Pane) parent).getChildren().remove(node);
		else if(parent instanceof Group)
			((Group) parent).getChildren().remove(node);
	}
}
