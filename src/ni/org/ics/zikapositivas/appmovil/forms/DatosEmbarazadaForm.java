package ni.org.ics.zikapositivas.appmovil.forms;


import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.wizard.model.AbstractWizardModel;
import ni.org.ics.zikapositivas.appmovil.wizard.model.DatePage;
import ni.org.ics.zikapositivas.appmovil.wizard.model.NumberPage;
import ni.org.ics.zikapositivas.appmovil.wizard.model.PageList;
import ni.org.ics.zikapositivas.appmovil.wizard.model.SingleFixedChoicePage;
import ni.org.ics.zikapositivas.appmovil.wizard.model.TextPage;
import android.content.Context;

public class DatosEmbarazadaForm extends AbstractWizardModel {
	int index = 0;
	private DatosEmbarazadaFormLabels labels;
	public static final String nombreForm = Constants.FORM_DATOS_EMB;
    public DatosEmbarazadaForm(Context context) {
        super(context);
    }

    @Override
    protected PageList onNewRootPageList() {
    	labels = new DatosEmbarazadaFormLabels();	
    	return new PageList(
        		new SingleFixedChoicePage(this, labels.getCs(), labels.getCsHint(),Constants.WIZARD)
                .setChoices("Sócrates Flores", "Francisco Buitrago", "Villa Venezuela")
                .setRequired(true),
        		new TextPage(this, labels.getNombre1(), labels.getNombre1Hint(),Constants.WIZARD)
        			.setPatternValidation(true, ".{2,50}").setRequired(true),
        		new TextPage(this, labels.getNombre2(), labels.getNombre2Hint(),Constants.WIZARD)
        			.setPatternValidation(true, ".{2,50}").setRequired(false), 
        		new TextPage(this, labels.getApellido1(), labels.getApellido1Hint(),Constants.WIZARD)
        			.setPatternValidation(true, ".{2,50}").setRequired(true),
        		new TextPage(this, labels.getApellido2(), labels.getApellido2Hint(),Constants.WIZARD)
        			.setPatternValidation(true, ".{2,50}").setRequired(false),
        		new TextPage(this, labels.getDireccion(), labels.getDireccionHint(),Constants.WIZARD)
        			.setPatternValidation(true, ".{5,50}").setRequired(true),
            	new DatePage(this, labels.getFechaNac(), labels.getFechaNacHint(),Constants.WIZARD)
        			.setRequired(false),        			
        		new NumberPage(this, labels.getTelefonoContacto(), labels.getTelefonoContactoHint(),Constants.WIZARD)
        			.setPatternValidation(true, "^$|^[8|5|7|2]{1}\\d{7}$").setRequired(false)
        );
    }

	public DatosEmbarazadaFormLabels getLabels() {
		return labels;
	}

	public void setLabels(DatosEmbarazadaFormLabels labels) {
		this.labels = labels;
	}
    
    
}
