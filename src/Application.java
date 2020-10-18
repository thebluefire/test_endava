import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) throws ParseException {

        Timestamp timestamp;
        ArrayList<User> users = new ArrayList<>();

        /*эти пользователи были зарегистрированы 1 сентября 2020*/
        users.add(new User("Maria", "Abalina", 18, Status.NEW, "Amari@gmail.com", Timestamp.valueOf("2020-09-01 09:01:15")));
        users.add(new User("Serghei", "Scurtu", 22, Status.INACTIVE, "serii1999@mail.ru", Timestamp.valueOf("2020-09-01 09:01:15")));
        users.add(new User("Vasile", "Postovanu", 18, Status.NEW, "vp12345@gmail.com", Timestamp.valueOf("2020-09-01 09:01:15")));
        users.add(new User("Katalina", "Petrova", 25, Status.INACTIVE, "kati1995@mail.ru", Timestamp.valueOf("2020-09-01 09:01:15")));

        /*эти пользователи регистрируются в момент работы программы*/
        users.add(new User("Alexander", "Ivanov", 21, Status.ACTIVE, "ardabada@mail.ru", new Timestamp(System.currentTimeMillis())));
        users.add(new User("Victoria", "Rascovan", 25, Status.INACTIVE, "vika1995@yahoo.ru", new Timestamp(System.currentTimeMillis())));
        users.add(new User("Alexei", "Babin", 35, Status.NEW, "alexbabins@gmail.com", new Timestamp(System.currentTimeMillis())));


        System.out.println("Изначальный список");
        printUsers(users);

        newToActive(users);
        System.out.println("Список после изменения статуса с нового на активный");
        printUsers(users);

        inactiveToBlocked(users);
        System.out.println("Список после изменения статуса с неактивного на заблокированный");
        printUsers(users);

    }

    public static void newToActive(ArrayList<User> users){
        for (User user : users){
            long millisFromYesterday = 12 * 60 * 60 * 1000;
            if (user.getStatus() == Status.NEW &&
                    Timestamp.from(Instant.now()).getTime() - user.getTimestamp().getTime() > millisFromYesterday){
                user.setStatus(Status.ACTIVE);
            }
        }
    }

    public static void inactiveToBlocked(ArrayList<User> users){
        for (User user : users){
            long millisFromLastMonth = 30 * 12 * 60 * 60 * 1000;
            if (user.getStatus() == Status.INACTIVE &&
                    Timestamp.from(Instant.now()).getTime() - user.getTimestamp().getTime() > millisFromLastMonth){
                user.setStatus(Status.BLOCKED);
            }
        }
    }

    public static void printUsers(ArrayList<User> users){
        for (User user : users){
            System.out.println(user);
        }
    }
}
