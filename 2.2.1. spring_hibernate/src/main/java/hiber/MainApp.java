package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Artem", "Arsenyev", "user1@mail.ru");
      User user2 = new User("Petr", "Petrov", "user2@mail.ru");
      User user3 = new User("Dmitriy", "Frolov", "user3@mail.ru");
      User user4 = new User("Ivan", "Ivanov", "user4@mail.ru");

      Car car1 = new Car("BMW", 5);
      Car car2 = new Car("Audi", 4);
      Car car3 = new Car("Mercedes", 220);
      Car car4 = new Car("BMW", 6);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user + " " + user.getCar());

         System.out.println(userService.getUserById("BMW", 5));
      }

      context.close();
   }
}
