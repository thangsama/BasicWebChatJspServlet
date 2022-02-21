# BasicWebChatJspServlet
This is so so so basic chat web 
- edit connection DB first
- DB query
         create table USER_ACCOUNT
(
USER_NAME VARCHAR(30) not null,
GENDER    VARCHAR(1) not null,
PASSWORD  VARCHAR(30) not null,
primary key (USER_NAME)
);


create table chat
(
USER_NAME VARCHAR(30) ,
Content longtext
) ;
  
  
  - Not include any " " (space) in content while typing in Message box
  
  
  FEEL FREE TO USE
