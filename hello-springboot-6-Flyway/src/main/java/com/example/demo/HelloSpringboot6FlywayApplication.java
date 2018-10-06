package com.example.demo;
import org.flywaydb.core.Flyway;
public class HelloSpringboot6FlywayApplication
{
	public static void main(String[] args)
	{		
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:h2:file:./target/foobar", "sa", null);
       
        flyway.migrate();
	}
}
