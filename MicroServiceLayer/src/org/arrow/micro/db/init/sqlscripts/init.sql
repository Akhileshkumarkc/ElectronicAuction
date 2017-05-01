Hibernate: create table axk167131.AuctionEventModel (auctionId number(10,0) not null, category varchar2(255 char), description varchar2(255 char), imageURL varchar2(255 char), name varchar2(255 char), scheduledEndDate timestamp, startDateTime timestamp, startingBid double precision, status number(10,0) not null, Owner_userId number(10,0), primary key (auctionId))
Hibernate: create table axk167131.BidModel (BidId number(10,0) not null, amount double precision, PUBLISHED date, transactionId varchar2(255 char), userId number(10,0), primary key (BidId))
Hibernate: create table axk167131.Bids (AuctionId number(10,0) not null, bidModels_BidId number(10,0) not null, BidId number(19,0) not null, primary key (BidId))
Hibernate: create table axk167131.login (userId number(10,0) not null, Location varchar2(255 char), lastLogin timestamp, password varchar2(255 char) not null, username varchar2(255 char) not null, primary key (userId))
Hibernate: create table axk167131.PurchasedItemModel (orderId number(10,0) not null, price double precision, AUCTION_ID number(10,0), USER_ID number(10,0), primary key (orderId))
Hibernate: create table axk167131.UserDetailsModel (company varchar2(255 char), email varchar2(255 char), firstName varchar2(255 char), lastName varchar2(255 char), phoneNumber varchar2(255 char), ship_city varchar2(255 char), ship_house_no varchar2(255 char), ship_pincode varchar2(255 char), ship_state varchar2(255 char), ship_street_name varchar2(255 char), user_city varchar2(255 char), user_house_no varchar2(255 char), user_pincode varchar2(255 char), user_state varchar2(255 char), user_street_name varchar2(255 char), loginInfo_userId number(10,0) not null, primary key (loginInfo_userId))
Hibernate: alter table axk167131.Bids drop constraint UK_9oc72g4w25qetffc7yjmxdti8
Hibernate: alter table axk167131.Bids add constraint UK_9oc72g4w25qetffc7yjmxdti8 unique (bidModels_BidId)
Hibernate: alter table axk167131.login drop constraint UK_3svxcq6q51yfdg253l6x3dget
Hibernate: alter table axk167131.login add constraint UK_3svxcq6q51yfdg253l6x3dget unique (username)
Hibernate: alter table axk167131.UserDetailsModel drop constraint UK_5gld44vfjtc02gk0uk13favw1
Hibernate: alter table axk167131.UserDetailsModel add constraint UK_5gld44vfjtc02gk0uk13favw1 unique (email)
Hibernate: alter table axk167131.UserDetailsModel drop constraint UK_ehutt22cdm8juw80kp6ek9042
Hibernate: alter table axk167131.UserDetailsModel add constraint UK_ehutt22cdm8juw80kp6ek9042 unique (phoneNumber)
Hibernate: alter table axk167131.AuctionEventModel add constraint FKbui3ieojpruid2pa0qdrlmy1s foreign key (Owner_userId) references axk167131.login
Hibernate: alter table axk167131.BidModel add constraint FKkey7oluuh4lxwdy9ywdbb53q0 foreign key (userId) references axk167131.login
Hibernate: alter table axk167131.Bids add constraint FKrgqixuiubbr9m9ea7e2s71djp foreign key (bidModels_BidId) references axk167131.BidModel
Hibernate: alter table axk167131.Bids add constraint FK93icc0qxj1gc4qe9svga9w0qt foreign key (AuctionId) references axk167131.AuctionEventModel
Hibernate: alter table axk167131.PurchasedItemModel add constraint FKoh1agv7sgupu2cu7yjn7kcwf7 foreign key (AUCTION_ID) references axk167131.AuctionEventModel
Hibernate: alter table axk167131.PurchasedItemModel add constraint FKbpqryem6r854v1denogc8kpni foreign key (USER_ID) references axk167131.UserDetailsModel
Hibernate: alter table axk167131.UserDetailsModel add constraint FKnyhqhqxa0bmv889vdg84rd9k9 foreign key (loginInfo_userId) references axk167131.login