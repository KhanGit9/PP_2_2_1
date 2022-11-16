package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);
      userService.add(new User("Evgeny", "Mamaev", "Genya@mail.ru", new Car("Mercedes",222)));
      userService.add(new User("Apti", "Apaev", "apaev@mail.ru", new Car("Mercedes", 211)));
      userService.add(new User("Pietro", "Maximoff", "quiksilver@mail.ru", new Car("Ferrari", 599)));
      userService.add(new User("Tony", "Stark", "ironMan@mail.ru", new Car("Zaporojec", 100)));
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }
      User user1 = userService.getUserByModel("Mercedes", 222);
      System.out.println(user1);
      context.close();
   }
}
