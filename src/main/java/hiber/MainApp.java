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

      Car carUser1 = new Car("Toyota", 15);
      Car carUser2 = new Car("Audi", 22);
      Car carUser3 = new Car("BMW", 3);
      Car carUser4 = new Car("Mazda", 5);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",carUser1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",carUser2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",carUser3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",carUser4));


//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Car = "+user.getCar());
//         System.out.println();
//      }
      System.out.println("____________________________");
      System.out.println(userService.getUserAtCar("Toyota",15));
      context.close();
   }
}
