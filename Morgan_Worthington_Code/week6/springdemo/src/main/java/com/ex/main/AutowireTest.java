package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.autowire.Employee;

public class AutowireTest {

	/*
	 * In the Spring Framework, setting bean dependencies
	 * in configuration files is a good practice to follow,
	 * but the spring container is also able to autowire
	 * relationships between collaborating beans. This means 
	 * that it is possible to automatically let Spring resolve
	 * collaborators (other beans) for your bean by inspecting
	 * the contents of the BeanFactory/AppContext. Autowiring is specified
	 * per bean and can thus be enabled for some beans while
	 * others are not autowired.
	 * 
	 * There are 5 modes:
	 * no - this option is default for spring framework and it 
	 * means that autowiring is OFF. You have to explicitly set
	 * the dependencies using <property> tags in bean definitions.
	 * 
	 * byName - This option enabales dependency injection
	 * based on bean names. When autowiring a property in bean,
	 * property name is used for searching a matching bean
	 * definition in configuration file. If such bean is found,
	 * it is injected in property. If no such bean is found, an
	 * error is raised.
	 * 
	 * byType - This option enables the dependency injection
	 * based on bean types. When autowiring a property in bean,
	 * property's class type is used for searching a matching
	 * bean definition in configuration file. If such bean is
	 * found, an error is raised.
	 * 
	 * constructor - Autowiring by constructor is similar to
	 * byType, but applies to constructor arguments. In autowire
	 * enabled bean, it will look for class type of constructor
	 * arguments, and then do an autowire by type on all 
	 * constructor arguments. Please note that if there isn't 
	 * exactly one bean of the constructor argument type in the
	 * container, a fatal error is raised.
	 * 
	 * autodetect - Autowiring by autodetect uses either of two
	 * modes i.e. constructor or byType modes. First it will
	 * try to look for valid constructor with arguments, if
	 * found the constructor mode is chosen. If there is no
	 * constructor defined in bean, or explicit default no-args
	 * constructor is present, the autowire byType mode is chosen.
	 * 
	 * for more info check: https://howtodoinjava.com/spring/spring-core/spring
	 */
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		Employee e=(Employee) context.getBean("employee");
		Employee e2=(Employee) context.getBean("employee");
		e.getDept().setName("TEST DEPT");
		
		e.getName();
		e.getDept();
	}
}