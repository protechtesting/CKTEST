package utility;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;



import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

	/******************************************************** Methods Creation started ****************************************************************/

	/* transform */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		String testMethodName		= testMethod.toString();
		String partnerName			= Utils.getConfigData(0, "partner");
		String partnerPouringPounds = "pouringpounds";

		if ((testMethodName.contains("DeviceTypeApp")) && (partnerName.equalsIgnoreCase(partnerPouringPounds))) {

			annotation.setEnabled(false);

		} else {

			annotation.setEnabled(true);

		}

	}

}