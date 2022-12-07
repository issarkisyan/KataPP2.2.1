package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);



      Car car1 = new Car("Kia77", 54);
      Car car2 = new Car("Kia11", 95);
      Car car3 = new Car("Kia88", 67);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user1.setCar(car1);
      user3.setCar(car2);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      //userService.add(new User("User2", "Lastname2", "user2@mail.ru").setCar(car1));
      //userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      //userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      //userService.add(new Car("Kia77", 54));
      //userService.add(new Car("Kia88", 67));
      System.out.println(userService.getByModelAndSeries("Kia77",54));
      System.out.println(userService.getByModelAndSeries("Kia11",95));
      //System.out.println(userService.getByModelAndSeries("Kia88",67));
/*
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();

 */
   }


}
