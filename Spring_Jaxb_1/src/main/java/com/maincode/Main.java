package com.maincode;

import java.io.FileWriter;
import javax.xml.transform.stream.StreamResult;
import com.assignmentspringjaxb1.StudentJAXB1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;

public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext beanfactoryobj12 = new ClassPathXmlApplicationContext("assignment.xml");

        Marshaller marshaller = (Marshaller) beanfactoryobj12.getBean("jaxbMarshallerBean");

        StudentJAXB1 student = new StudentJAXB1();
        student.setId(5);
        student.setAge(16);
        student.setFirstname("Ramone");
        student.setLastname("Diaz");

        marshaller.marshal(student, new StreamResult(new FileWriter("fispersonjaxb.xml")));
        System.out.println("XML Created Successfully");
    }
}
