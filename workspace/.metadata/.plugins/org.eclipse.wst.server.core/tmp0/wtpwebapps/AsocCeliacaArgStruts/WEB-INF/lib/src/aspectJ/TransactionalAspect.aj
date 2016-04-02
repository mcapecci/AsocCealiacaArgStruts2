package aspectJ;

import java.lang.reflect.Field;

import javax.persistence.*;

import org.aspectj.lang.reflect.MethodSignature;

import clasesDelSistema.EMF;

public aspect TransactionalAspect {
	
	

	Object around(): execution(@Transactional * * (..)){
		
		System.out.println("Se ejecutara el metodo :: " + thisJoinPoint.getSignature());		
		
		Object obj = null;
		MethodSignature metodo = (MethodSignature) thisJoinPoint.getSignature();
		Transactional anotacion = metodo.getMethod().getAnnotation(Transactional.class);
		EntityManagerFactory emf = EMF.getEMF();
		EntityManager em = emf.createEntityManager();
		
		try {
			Object dao = thisJoinPoint.getTarget();
			for (Field field : dao.getClass().getFields()) {
				if (field.getType().equals(javax.persistence.EntityManager.class)){						
					field.set(dao, em);					
				}
			}	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}	
		
		if(anotacion.readOnly().equals("false")){			
			System.out.println(" -- metodo de escritura. se abren transacciones --");
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			obj = proceed();
			etx.commit();			
		}
		else{
			System.out.println(" -- metodo read only. NO se abren transacciones --");
			obj = proceed();
		}
		
		em.close();
		System.out.println("Finalizo la ejecucion del metodo :: " + thisJoinPoint.getSignature());
		
		return obj;
	}
}
