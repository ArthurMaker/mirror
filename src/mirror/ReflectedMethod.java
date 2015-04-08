/**
 * mirror was made by Jadon Fowler.
 * This file is licensed under the MIT License.
 */
package mirror;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Jadon "Phase" Fowler on Feb 16, 2015
 */
public class ReflectedMethod implements Printable<ReflectedMethod>{
	
	private ReflectedClass<?> superClass;
	private Method m;
	
	protected ReflectedMethod(ReflectedClass<?> sc, Class<?> c, String name, Class<?>...params) {
		try {
			m = c.getMethod(name, params);
			superClass = sc;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String toString(){
		return m.getName() + ": " + Arrays.toString(m.getParameterTypes());
	}

	/**
	 * @see mirror.Printable#print()
	 */
	@Override
	public ReflectedMethod print() {
		System.out.println(toString());
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T invoke(Object... b){
		try {
			return (T) m.invoke(superClass.getObject(), b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}