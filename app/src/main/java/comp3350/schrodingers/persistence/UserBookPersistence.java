package comp3350.schrodingers.persistence;
import java.util.List;

import comp3350.schrodingers.objects.User;
import comp3350.schrodingers.objects.UserBook;

public interface UserBookPersistence {

   UserBook insertUser(final UserBook newUser);
   List<String> addedBook(User newUser);
}
