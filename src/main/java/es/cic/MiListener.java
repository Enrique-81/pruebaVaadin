package es.cic;

import com.vaadin.ui.Window;
import com.vaadin.ui.Window.ResizeEvent;
import com.vaadin.ui.Window.ResizeListener;

public class MiListener implements ResizeListener {

	public Window ventana;
	@Override
	public void windowResized(ResizeEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public MiListener(Window ventana)
	{
		this.ventana = ventana;
	}

}
