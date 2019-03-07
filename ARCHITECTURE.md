# Architecture


## Packages and Files

### **Java**

#### application
    - Services.java
    - Main.java

#### business 
    - AccessBooks.java
    - AccessPaymentInfo.java
    - AccesUserInfo.java
    - CardException.java
    - CreateAccount.java
    - PaymentProcessor
    - UserLogin.java
    - UserValidator.java

#### objects 
    - Book.java
    - User.java
    
#### persistance
##### hsqldb
    - BooksPersistenceHSQLDB.java
    - PaymentPersistenceHSQLDB.java
    - PersistenceException.java
    - UsersPersistenceHSQLDB.java
    
##### Stubs
    - BooksPersistenceStub.java
    - UsersPersistenceStub.java
    - PaymentPersistenceStub.java
    
##### Interfaces
    - BooksPersistence.java
    - PaymentPersistence.java
    - PaymentProcessorInt.java
    - UsersPersistence.java

#### presentation 
    - BookAdapter.java
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


### **XML**

#### drawable
    - ic_launcher_background.xml
    - ic_launcher_foregrdound.xml
    - ic_menu_manage.xml
    - ic_menu_share.xml
    - ic_search.xml
    - side_nav_bar.xml

#### layout
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
    
#### menu
    - activity_main_menu_drawer.xml
    - main_menu.xml
    
#### values
    - colors.xml
    - dimens.xml
    - strings.xml
    
#### styles
    - styles.xml
    
### **assets**
#### db
    - SC.script

### Architecture Diagram
*Supplied in the ARCHITECTURE.png*