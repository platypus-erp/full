package org.platypus.erp.module.base.services;

import java.lang.FunctionalInterface;
import java.lang.String;
import java.util.List;
import org.platypus.api.annotations.Service;
import org.platypus.erp.module.base.models.Users;

public interface BaseService {
   @Service.Multi
   List<String> myBusinessMethod(List<String> record, String tt);

   @FunctionalInterface
   @Service(Users.class)
   interface MyBusinessMethod {
      @Service.Multi
      List<String> myBusinessMethod(List<String> record, String tt, Super sup);

      @FunctionalInterface
      @Service.Super
      interface Super {
         @Service.Multi
         List<String> myBusinessMethod(List<String> record, String tt);
      }
   }
}
