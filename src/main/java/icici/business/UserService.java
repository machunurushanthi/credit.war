package icici.business;

import icici.business.model.User;

public interface UserService extends CRUDService<Long, User> {
   User findByUsername(String username) throws BusinessException;

   User findByEmail(String email) throws BusinessException;
}
