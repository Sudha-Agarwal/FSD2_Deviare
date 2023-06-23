package runner;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import persistence.Recipe;

public class RecipeRunner {

	public static void main(String[] args) {
		Configuration configObj = new Configuration();

		configObj.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

		SessionFactory sessionFactoryObj = configObj.buildSessionFactory(serviceRegistry);
		Transaction tr =null;
		Session sessionObj =null;
		try {
			sessionObj = sessionFactoryObj.openSession();
			tr = sessionObj.beginTransaction();
			
			Recipe recipe = new Recipe();
			recipe.setName("Chocolate Cake");
			
			//creating a list of ingredients
			List<String> ingredients = new ArrayList<>();
			ingredients.add("Flour");
			ingredients.add("Sugar");
			ingredients.add("Cocoa Powder");
		    ingredients.add("Baking Powder");
			
		    recipe.setIngredients(ingredients);
		    sessionObj.save(recipe);
			System.out.println("records saved successfully");

			tr.commit();

		}
		catch(Exception e) {
			if(tr!=null) {
				tr.rollback();
			}
			e.printStackTrace();

		}
		finally {
			if(sessionObj != null) {
				sessionObj.close();
			}
		}	

	}
}

