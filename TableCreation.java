package com.Java_Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Demo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + "]";
	}
}


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
	<session-factory>
		<property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
		<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernate</property>
		<property name="hibernate.connection.user">root</property>
		<property name="hibernate.connection.password">abbu123</property>
		<property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
		<property name="hibernate.hbm2ddl.auto">create</property>
		<property name="hibernate.show_sql">true</property>
		<mapping class="com.Java_Hibernate.Demo"/>
	</session-factory>
</hibernate-configuration>


package com.Java_Hibernate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class App
{
    public static void main( String[] args )
    {
     	System.out.println( "Hello World!" );
     	Demo d = new Demo();     
	d.setName("Abbu");  
	Demo d1 = new Demo();   
	d1.setName("Abdul");
	Configuration con = new Configuration();
     	con.configure("com/Java_Hibernate/hibernate.cfg.xml");
     	SessionFactory sf = con.buildSessionFactory();
     	Session openSession = sf.openSession();
     	Transaction beginTransaction = openSession.beginTransaction();
     	openSession.save(d);
     	openSession.save(d1);
     	beginTransaction.commit();
    }
}

