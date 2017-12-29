package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.autowire.Employee;

/*
 * i nthe spring feamwrowk sertin bean depencies in confuration filres ia good pracie to follow but the psring container is also able to qautowire the relationships between collaboring beans this means that is possible to automatically let spring recolve collabroatiors othe rbeans for your  bean by inspecting the contecnts of beanfactory/appcontext autowireing is peified per eban and thus be enabled for some beans while others are not autowired 
 * 
 * ther are 5 modes 
 * no- this opyions is defauly for spring amework and it means that autowiring is off and you have to explicitily set the dependies ing uses ing property taes in the deificions 
 * byname - this options enables the dependct injection based on the beans names when autowing a property in in the bean propery name is uesed for esarchin and meatching bean definitions in confuration file if sucha  bean is found it is injected propely if not foiund an error is raised 
 * bytype- this option anbles the dependency injection based on other beans types whe nautowiin a proery in a bean propery class type is used for esarching a matching bean deifntion in a confituation file if such a bean it is foudn its injected if  not found an erro is raised 
 * constructor-  autowiring by constructor is simmilar to by type but applied to construcyor arguments 
 */
public class AutoWireTest {

	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("beans.xml");
		Employee e = (Employee) context.getBean("employee");
		Employee e2 = (Employee) context.getBean("employee");
		e.setName("this is a name");
		e.getName();
		e.getDepartment();
	}

}
