# Schrodingers-9 Library

## Architecture

We used a 3-tier architecture for our project

#### Architecture Diagram
*Supplied in the [ARCHITECTURE.png](https://code.cs.umanitoba.ca/comp3350-winter2019/schrodingers-library/blob/master/documents/ARCHITECTURE.png)*

### Packages and Files

#### **Java**

##### application
    - Services.java
    - Main.java

##### business 
    - AccessBooks.java
    - AccessPaymentInfo.java
    - AccesUserInfo.java
    - CardException.java
    - CreateAccount.java
    - PaymentProcessor
    - UserException.java
    - UserLogin.java
    - UserValidator.java
    

##### objects 
    - Book.java
    - User.java
    - Ratings.java
    
##### persistance
###### hsqldb
    - BooksPersistenceHSQLDB.java
    - PaymentPersistenceHSQLDB.java
    - PersistenceException.java
    - UsersPersistenceHSQLDB.java
    - RatingPersistenceHSQLDB.java
    
###### Stubs
    - BooksPersistenceStub.java
    - UsersPersistenceStub.java
    - PaymentPersistenceStub.java
    
###### Interfaces
    - BooksPersistence.java
    - PaymentPersistence.java
    - UsersPersistence.java
    - RatingPersistence.java

##### presentation 
    - BookAdapter.java
    - CLI.java
    - CreateAccountActivity.java
    - HomeActivity.java
    - LoggedActivity.java
    - LoginActivity.java
    - Messages.java
    - NotLoggedActivity.java
    - PaymentActivity.java
    - PersonInfo.java
    - SearchActivity.java
    - ViewBookInfoActivity.java


#### **XML**

##### drawable
    - ic_launcher_background.xml
    - ic_launcher_foregrdound.xml
    - ic_menu_manage.xml
    - ic_menu_share.xml
    - ic_search.xml
    - side_nav_bar.xml
    - annabellefightslife.png
    - dangerouscrusaders.png
    - emberofthechildren.png
    - escapefromthehill.png
    - herebychoice.png
    - nowaybutdown.png
    - otherworld.png
    - survivalofthefittest.png
    - thebadboy.png
    - thedealer.png
    - theedgeoftheuniverse.png
    - thefourthwind.png
    - theperfectchild.png
    - theredcordofmarriage.png
    - theredplanet.png
    - therisingcaptive.png
    - thewaywegetby.png
    - thirteenreasonstoforgetyou.png
    - twilightfortress.png
    - whereiscecilia.png
    - whirlwind.png
##### layout
    - activity_create_account.xml
    - activity_home.xml
    - activity_logged.xml
    - activity_not_logged.xml
    - activity_payment.xml
    - activity_person_info.xml
    - activity_search.xml
    - activity_view_book_info.xml
    - app_bar_main_menu.xml
    - book_catalog.xml
    - content_main_menu.xml
    - content_search.xml
    - content_view_book_info.xml
    - item.xml
    - nav_header_main_menu.xml
    
##### menu
    - activity_main_menu_drawer.xml
    - main_menu.xml
    
##### values
    - colors.xml
    - dimens.xml
    - strings.xml
    
##### styles
    - styles.xml
    
#### **assets**
##### db
    - SC.script