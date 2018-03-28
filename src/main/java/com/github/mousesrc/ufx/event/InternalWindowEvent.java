package com.github.mousesrc.ufx.event;

import com.github.mousesrc.ufx.control.window.InternalWindow;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.stage.WindowEvent;

public class InternalWindowEvent extends Event {
	
	public static final EventType<InternalWindowEvent> ANY = new EventType<>(Event.ANY, "INTERNAL_WINDOW");
	
	public static final EventType<InternalWindowEvent> CLOSING = new EventType<>(ANY, "INTERNAL_WINDOW_CLOSING");
	
	public static final EventType<InternalWindowEvent> CLOSED = new EventType<>(ANY, "INTERNAL_WINDOW_CLOSED");
	
	public static final EventType<InternalWindowEvent> MOVING = new EventType<>(ANY, "INTERNAL_WINDOW_MOVING");
	
	public static final EventType<InternalWindowEvent> MOVED = new EventType<>(ANY, "INTERNAL_WINDOW_MOVED");
	
	public static final EventType<InternalWindowEvent> RESIZING = new EventType<>(ANY, "INTERNAL_WINDOW_RESIZING");
	
	public static final EventType<InternalWindowEvent> RESIZED = new EventType<>(ANY, "INTERNAL_WINDOW_RESIZED");

	public InternalWindowEvent(InternalWindow source, EventType<InternalWindowEvent> eventType) {
		super(source, source, eventType);
	}

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("InternalWindowEvent [");

        sb.append("source = ").append(getSource());
        sb.append(", target = ").append(getTarget());
        sb.append(", eventType = ").append(getEventType());
        sb.append(", consumed = ").append(isConsumed());

        return sb.append("]").toString();
    }

    @Override
    public InternalWindowEvent copyFor(Object newSource, EventTarget newTarget) {
        return (InternalWindowEvent) super.copyFor(newSource, newTarget);
    }

	public InternalWindowEvent copyFor(Object newSource, EventTarget newTarget, EventType<WindowEvent> type) {
		InternalWindowEvent e = copyFor(newSource, newTarget);
		e.eventType = type;
		return e;
	}

	@Override
	public EventType<InternalWindowEvent> getEventType() {
		return (EventType<InternalWindowEvent>) super.getEventType();
	}
}
