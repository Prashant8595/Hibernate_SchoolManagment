package com.School.dao;


import com.School.model.Student;
import com.School.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDao{
        public  void saveStudent(String  firstName,String Lastname,String Email){
            Session session= HibernateUtil.getSession();
            Transaction transaction=null;
            try {
                transaction = session.beginTransaction();
                Student student=new Student();
                student.setFirstName(firstName);
                student.setLastName(Lastname);
                student.setEmail(Email);


                session.save(student);
                transaction.commit();
                System.out.println("Record inserted sucessessfully");
            }catch (HibernateException e){
                e.printStackTrace();
            }
            finally {
                session.close();
            }
        }

        public List<Student> getStudent(){
            Session session=HibernateUtil.getSession();
            Query query=session.createQuery("from Student");
            List<Student> students=query.list();
            session.close();
            return students;

        }

        public  int updateStudent(Student s){
            if(s.getId()<=0){
                return 0;
            }
            Session session=HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String hql="update Student set firstName =:first_Name, lastName =:last_Name, email =:email where id = :id";
            Query query=session.createQuery(hql);
            query.setParameter("id",s.getId());
            query.setParameter("first_Name",s.getFirstName());
            query.setParameter("last_Name",s.getLastName());
            query.setParameter("email",s.getEmail());

            int rowCount= query.executeUpdate();

            System.out.println("Rows affected: "+rowCount);
            tx.commit();
            session.close();
            return rowCount;


        }

        public int deleteStudent(int id){
            Session session=HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            String hql="delete from Student where id = :id";
            Query query= session.createQuery(hql);
            query.setParameter("id",id);
            int rowCount= query.executeUpdate();

            System.out.println("Rows affected: "+rowCount);
            tx.commit();
            session.close();
            return rowCount;


        }
}
