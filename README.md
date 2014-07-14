chemistryPDF
============
/*
Simple bridge between Apache PDFBox and classes or ORm model, which instances we wont to print on pdf. Ideal to put Hibernate model objects, or object of any instance to pdf. 

Example:
1. define bridge class, TorCmrCmnRun is OR model class
*/
package com.tockacrta.trailOer.reports.model;

import com.tccrt.chemistryPdf.model.Atom;
import com.tockacrta.trailOer.model.TorCmrCmnRun;
import com.tockacrta.trailOer.model.TorCompetitor;

public class TorCmrCmnRunAtom extends Atom<TorCmrCmnRun> {

	public TorCmrCmnRunAtom(TorCmrCmnRun value) {
		super(value);
		setFormat("%s, %s %s");
	}

	@Override
	protected Object formatOutput(String format, TorCmrCmnRun value) {
		TorCompetitor competitor=getValue().getTorCmrCmn().getTorCompetitor();
		// first and last are required
		String midName="";
		if (competitor.getMidName()!=null) {
			midName=competitor.getMidName();
		}
		return String.format(format, competitor.getFirstName(), competitor.getLastName(), midName);
	}
	
	
}
/*
2. In your app,define usage of PDDOcumentImpl (I use spring so I will gove you spring xml config example)
- define copmund and document factoriy

    <bean id="startListCompund" class="com.tccrt.chemistryPdf.model.Compound" lazy-init="true">
    	<constructor-arg index="0" value="Start list"></constructor-arg>
		<property name="absPositioning" value="true"></property>
		<property name="x" value="100F"></property>
		<property name="y" value="700F"></property>
	</bean>    
    
    <bean id="startList" class="com.tccrt.chemistryPdf.document.impl.PDDocumentImpl" lazy-init="true">
    	<property name="fileName" value="startList.pdf"></property>
    	<property name="fileLocation" value="/home/boris/temp/"></property>
    	<property name="chemistry">
    		<map>
    			<entry key="startListCompund" value-ref="startListCompund"></entry>
    		</map>
    	</property>
    </bean>

    <bean id="documentFactory" class="com.tccrt.chemistryPdf.document.impl.DocumentFactoryImpl" lazy-init="true">
    	<property name="documentMapCache">
    		<map>
    			<entry key="startList" value-ref="startList"></entry>
    		</map>
    	</property>
    </bean>
*/

/*
3. use it in your coode (get documentFactory from spring context first, example is defined outside)
*/
    BaseDocument startList= documentFactory.getDocument("startList");
		Compound startListCompund= (Compound) startList.getChemistry().get("startListCompund");  	
		//
    	HashMap<String, Boolean> sorts=new HashMap<String, Boolean>();
    	sorts.put("ccr.startTime", true);
    	// get data in for loop
    	for (TorCmrCmnRun ccr : serviceFactory.getTorCmrCmnRunService().getByExample(example, 0, 0, sorts)) {
    	  // Create atom
    		TorCmrCmnRunAtom atom=new TorCmrCmnRunAtom(ccr);
    		atom.setAbsPositioning(false);
    		atom.setX(0F);
    		atom.setY(-15F);  // relativ
    		// And add it to main compound of document (as defined i spring xml)
    		startListCompund.add(atom);
		}    	
    	startList.init();
    	startList.spill();
    	startList.save();  // name is defined in spring xml
