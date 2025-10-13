# BookApp
This is a Book Library app that i create to learn about spring framework


Information for connection database
anhtu@anhtu-victus:~$ docker run -d \
--name pg-lib \
-e POSTGRES_USER=anhtu \
-e POSTGRES_PASSWORD=123456 \
-e POSTGRES_DB=bookApp \
-p 5432:5432 \
-v pg_lib_data:/var/lib/postgresql/data \
postgres:16



# Scene:
The library want to allow user, reader borrow and read books available in its own

Users: have corresponding role like manager (manage borrow and return book), admin (import book), user (borrow, return, watch book). 

Books: have a lot of types like fiction, non-fiction, Romance, Fantasy, Horror, Historical Fiction,....

OrderDetails: contain information of book_id, user_id, quantity, unit_price, total

Orders: contain who order and which books that they ordered

Returned: marked books that returned

Read_Books: contain lots of books were read by users

Borrows: contain which books were borrowed by who

Deposits: deposit on account of users

Deposit_method: choose which method was used to deposit

Feed_back_Product: contain lots of feedback of customers that borrow book or purchased something 

Request_borrow: contain lots of requests that users send to server and wait for accepted of manager library 

Permission_Role: contain which endpoint for which role with method and descriptions attached

Role: contain roles available of this system (or this project, or this library)

Cart: contain which users add which products with their account

CartDetail: contain lots of products that users add on their cart with product's information such as: product_id, unit_price, quantity, total_price of its products



