# Architecture


## Packages and Files

### *Java*

#### application
    - Services.java

#### business 
    - AccessPaymentInfo.java
    - FindBook.java
    - PaymentProcessor

#### objects 
    - Book.java
    - User.java
    
#### persistance
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
    - HomeActivity.java
    - LoggedActivity.java
    - Messages.java
    - PaymentActivity.java
    - PersonInfo.java
    - SearchActivity.java
    - ViewBookInfoActivity.java


### *XML*

#### drawable
    - ic_launcher_background.xml
    - ic_launcher_foregrdound.xml
    - ic_menu_manage.xml
    - ic_menu_share.xml
    - ic_search.xml
    - side_nav_bar.xml

#### layout
    - activity_home.xml
    - activity_logged.xml
    - activity_payment.xml
    - activity_person_info.xml
    - activity_search.xml
    - activity_view_book_info.xml
    - app_bar_main_menu.xml
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


### Architecture Diagram
*Supplied in the ARCHITECTURE.png*