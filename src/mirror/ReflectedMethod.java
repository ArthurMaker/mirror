/**
 * mirror was made by Jadon Fowler.
 * This file is licensed under the MIT License.
 */
package mirror;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Jadon "Phase" Fowler on Feb 16, 2015
 */
public class ReflectedMethod implements Printable<ReflectedMethod>{
	
	Method m;
	
	protected ReflectedMethod(Class<?> c, String name, Class<?>...params) {
		try {
			m = c.getMethod(name, params);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
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
	
	

}