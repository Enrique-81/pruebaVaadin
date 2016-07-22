package es.cic;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.Window.WindowModeChangeEvent;
import com.vaadin.ui.Window;

public class Ventana extends Window {

	public Ventana()
	{
		Responsive.makeResponsive(this);
		center();
	
		this.setImmediate(true);
		this.setCloseShortcut(KeyCode.ESCAPE, null);
		this.setResizable(true);
		this.setClosable(true);
		this.setModal(true);
		this.setIcon(FontAwesome.ENVELOPE);
		this.setCaption(" Información XML");
	
		// this.setSizeUndefined();
		this.setHeight(80, Unit.PERCENTAGE);
		this.setWidth(80, Unit.PERCENTAGE);
	
	//	VerticalLayout subContent = this.getMensajeVL(new String(traza.getDatos()));
		
		Label subContent = new Label("asasd mensaje");
	
		
		TabSheet tab = new TabSheet();
		tab.setStyleName("padded-tabbar framed only-selected-closable compact-tabbar");
		tab.addTab(new Label("Hola"),"saludo");
		tab.setVisible(true);
	
		
		Panel p = new Panel();
		p.setSizeFull();
		p.setContent(subContent);
		
		
		
		Tab tabMensaje = tab.addTab(p, "mensaje en el panel");
		
		
		tab.addTab(Grafica.getGrafica(), "grafica");
	
		tab.setSizeFull();
		tab.setResponsive(true);
	
		this.setContent(tab);
		

	
	}
}
