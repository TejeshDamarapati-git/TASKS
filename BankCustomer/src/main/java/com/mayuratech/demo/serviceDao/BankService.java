package com.mayuratech.demo.serviceDao;

import java.util.Properties;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.mayuratech.demo.entity.BankCustomer;

public class BankService {
	
	private static SessionFactory sessionfactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionfactory==null) {
			try{
				Configuration config=new Configuration();
				Properties properties = new Properties();
				properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				properties.put(Environment.URL, "jdbc:mysql://10.0.2.134:3306/my_customerdb");
				properties.put(Environment.USER, "tejeshd");
				properties.put(Environment.PASS, "Tejesh@SQL_DB");
				properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				properties.put(Environment.SHOW_SQL,"true");
				properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				properties.put(Environment.HBM2DDL_AUTO,"update");
				
				config.setProperties(properties);
				config.addAnnotatedClass(BankCustomer.class);
				
				StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
				
				sessionfactory=config.buildSessionFactory(build);	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionfactory;
	}

}