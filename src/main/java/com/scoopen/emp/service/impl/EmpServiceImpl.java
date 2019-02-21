package com.scoopen.emp.service.impl;

import java.awt.print.Printable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.scoopen.constant.AppLevelsConstants;
import com.scoopen.constant.AppLevelsConstants.EmpFields;
import com.scoopen.conversion.Convesion;
import com.scoopen.emp.service.EmpService;
import com.scoopen.entites.EmpEntites;
import com.scoopen.pojoes.EmpPojoes;
import com.scp.util.HibernateUtil;

public class EmpServiceImpl implements EmpService {

	static SessionFactory sessionfactory = null;
	static {
		sessionfactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public boolean addEmp(EmpPojoes emp) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			int id = (Integer) session.save(Convesion.mapPojoToEntity(emp));
			session.flush();
			transaction.commit();
			return id != 0;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean deleteEmp(int empID) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			EmpEntites dbEntity = session.get(EmpEntites.class, empID);
			if (dbEntity == null) {
				return false;
			}
			session.delete(dbEntity);
			session.flush();
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

		return true;
	}

	@Override
	public EmpPojoes getEmp(int empID) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();

			return Convesion.mapEntityToPojoes(session.get((EmpEntites.class), empID));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();

		}
		return null;
	}

	@Override
	public boolean updateEmp(EmpPojoes empup) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			// Convesion.mapEntityToPojoes(session.get((EmpEntites.class),empID));
			EmpEntites empen = Convesion.mapPojoToEntity(empup);
			session.merge(empen);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}

		return true;
	}

	@Override
	public List<EmpPojoes> getAllEmp() {

		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			List<EmpEntites> listofEmp = session.createQuery("from EmpEntites").list();

			return Convesion.mapListofEntitesToListofPojoes(listofEmp);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<EmpPojoes> searchEmp(HashMap<AppLevelsConstants.EmpFields ,String > hmap) {
               
		Session session = null;
		Transaction transaction = null;

		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			
			 Set<Entry<EmpFields, String>> str=hmap.entrySet(); 
			Iterator itr=str.iterator();
			 while(itr.hasNext()){
				 Entry<EmpFields, String> q= (Entry<EmpFields, String>) itr.next() ;
				 q.getValue();
				 q.getKey();
			 }
					
			 
			@SuppressWarnings("deprecation")
			Criteria criteria=session.createCriteria(EmpEntites.class);
			//criteria.add(Restrictions.eq(hmap.entrySet().iterator().next().getKey(), value));
			//criteria.add(Restrictions.eq(propertyName, value));
		}
		catch (Exception e) {
			 e.printStackTrace();
		}

	return null;
}

}
