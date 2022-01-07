package icici.business.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import icici.business.BusinessException;
import icici.business.UserService;
import icici.business.model.User;

@Service
public class JPAUserService extends JPACRUDService<Long, User> implements UserService {

   @Override
   @Transactional
   public User findByUsername(String username) throws BusinessException {
      try{
         Query query = em.createQuery("from User u where u.username = :username");
         query.setParameter("username", username);
         return (User) query.getSingleResult();
      } catch (NoResultException e) {
         throw new BusinessException("No Result", e);
      }
   }
   
   @Override
   @Transactional
   public User findByEmail(String email) throws BusinessException {
      try{
         Query query = em.createQuery("from User u where u.email = :email");
         query.setParameter("email", email);
         return (User) query.getSingleResult();
      } catch (NoResultException e) {
         throw new BusinessException("No Result", e);
      }
   }
   
}
