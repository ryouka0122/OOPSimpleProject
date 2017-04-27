package jp.co.arsware.oopsample.events;

import java.awt.Frame;
import java.awt.event.ActionListener;

public abstract class ButtonEvent implements ActionListener {

	Frame parent;

	public ButtonEvent(Frame parent) {
		this.parent = parent;
	}

}
