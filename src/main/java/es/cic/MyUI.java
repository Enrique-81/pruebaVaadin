package es.cic;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.communication.PushMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 */
@Theme("mytheme")
@Widgetset("es.cic.MyAppWidgetset")
@Push
public class MyUI extends UI {
	
	Label label = new Label( "Now : " );

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
//                layout.addComponent(new Label("Thank you for clicking"));
            	UI.getCurrent().addWindow(new Ventana());
            }
        });
        layout.addComponent(button);
        
        
        this.access(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				push();
			}
		});

    }
    
    

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    
    private Window getVentana()
    {
    	Window w = new Window();
    	w.setModal(true);
    	w.setResizable(true);
    	w.center();
    	w.setHeight(80, Unit.PERCENTAGE);
    	w.setWidth(80, Unit.PERCENTAGE);
    	
    	TabSheet tabsheet = new TabSheet();
    	w.setContent(tabsheet);
    	
//    	tabsheet.setHeight(50, Unit.PERCENTAGE);
    	tabsheet.addTab(new Label("uno"),"uno");
    	Label doslabel = new Label("dos");
    	final Panel panel = new Panel();
		panel.setSizeFull();
		panel.setContent(doslabel);
    	tabsheet.addTab(panel,"dos");
    	return w;
    }
    
    
    

}
