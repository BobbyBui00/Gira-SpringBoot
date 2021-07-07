package cybersoft.javabackend.java11.gira.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class MapDtoToModel<E extends Object, T extends Object> {
	
	public T map(E dto, T model) {
		
		Method[] dtoMethods = dto.getClass().getMethods();
		List<String> dtoGetters = new LinkedList<String>();
		List<String> modelSetters = new LinkedList<String>();
		
		// extract all getters from dto methods
		for (Method method : dtoMethods) {
			if(!method.getName().equals("getClass") && method.getName().startsWith("get")) {
				dtoGetters.add(method.getName());
			}
		}
		
		// parse dto getters to model setters
		for (String getter : dtoGetters) {
			modelSetters.add(getter.replaceFirst("get", "set"));
		}
		
		// map dto properties to model properties
		for (String getter : dtoGetters) {	
			
			try {
				// get dto properties value
				Object dtoValue = dto.getClass().getMethod(getter).invoke(dto);
				
				// parse dto getter to model setter
				String modelSetter = getter.replaceFirst("get", "set");
				
				// get properties value
				Class<?>[] classes = model.getClass().getMethod(modelSetter).getParameterTypes();
				
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return model;
	}
	
}
