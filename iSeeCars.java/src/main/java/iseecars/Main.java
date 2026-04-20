package iseecars;

import iseecars.manager.BrandManager;
import iseecars.manager.CarManager;
import iseecars.manager.ModelManager;
import iseecars.service.InputService;
import iseecars.service.MenuService;

public class Main {
   public static void main(String[] args){
       //--------------MANAGERS-----------------
       ModelManager modelManager = new ModelManager();
       CarManager carManager = new CarManager(modelManager);
       BrandManager brandManager = new BrandManager();


       //---------------SERVICES----------------
       InputService inputService = new InputService(modelManager,carManager);

       MenuService menuService = new MenuService(
               modelManager,
               carManager,
               brandManager,
               inputService
       );
       //-------------START APPLICATION--------------
       menuService.readMenu();
   }

}
