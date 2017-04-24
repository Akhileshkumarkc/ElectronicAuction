create table axk167131.AuctionEventModel (auctionId number(10,0) not null, actualEndDate timestamp, description varchar2(255 char), minBidIncrement double precision, name varchar2(255 char), reserveAmount double precision, scheduledEndDate timestamp, startDateTime timestamp, startingBid double precision, status number(10,0) not null, item_Itemid number(10,0), primary key (auctionId))
create table axk167131.BidModel (BidId number(10,0) not null, amount double precision, dateTime timestamp, transactionId varchar2(255 char), userId number(10,0) not null, primary key (BidId))
create table axk167131.Bids (AuctionId number(10,0) not null, bidModels_BidId number(10,0) not null, BidId number(19,0) not null, primary key (BidId))
create table axk167131.ItemModel (Itemid number(10,0) not null, category varchar2(255 char), description varchar2(255 char), imageURL varchar2(255 char), name varchar2(255 char), primary key (Itemid))
create table axk167131.login (LoginId number(10,0) not null, password varchar2(255 char), username varchar2(255 char), primary key (LoginId))
create table axk167131.USER_HISTORY (USER_ID number(10,0) not null, userHistory_userHistoryId number(10,0) not null, LOGIN_HISTORY_ID number(19,0) not null, primary key (LOGIN_HISTORY_ID))
create table axk167131.UserDetailsModel (userId number(10,0) not null, company varchar2(255 char), email varchar2(255 char), firstName varchar2(255 char), lastName varchar2(255 char), phoneNumber varchar2(255 char), ship_city varchar2(255 char), ship_house_no varchar2(255 char), ship_pincode varchar2(255 char), ship_state varchar2(255 char), ship_street_name varchar2(255 char), user_city varchar2(255 char), user_house_no varchar2(255 char), user_pincode varchar2(255 char), user_state varchar2(255 char), user_street_name varchar2(255 char), loginInfo_LoginId number(10,0), primary key (userId))
create table axk167131.UserLoginHistoryModel (userHistoryId number(10,0) not null, location varchar2(255 char), loginDate date, primary key (userHistoryId))
alter table axk167131.Bids drop constraint UK_9oc72g4w25qetffc7yjmxdti8
alter table axk167131.Bids add constraint UK_9oc72g4w25qetffc7yjmxdti8 unique (bidModels_BidId)
alter table axk167131.login drop constraint UK_3svxcq6q51yfdg253l6x3dget
alter table axk167131.login add constraint UK_3svxcq6q51yfdg253l6x3dget unique (username)
alter table axk167131.USER_HISTORY drop constraint UK_4go5cl031qa5jc6n6eshm8tvb
alter table axk167131.USER_HISTORY add constraint UK_4go5cl031qa5jc6n6eshm8tvb unique (userHistory_userHistoryId)
alter table axk167131.AuctionEventModel add constraint FK9s8qduh6sebreq1j1trwqxkcf foreign key (item_Itemid) references axk167131.ItemModel
alter table axk167131.Bids add constraint FKrgqixuiubbr9m9ea7e2s71djp foreign key (bidModels_BidId) references axk167131.BidModel
alter table axk167131.Bids add constraint FK93icc0qxj1gc4qe9svga9w0qt foreign key (AuctionId) references axk167131.AuctionEventModel
alter table axk167131.USER_HISTORY add constraint FKiuex4aw83oknmo5oq2s8b7bhw foreign key (userHistory_userHistoryId) references axk167131.UserLoginHistoryModel
alter table axk167131.USER_HISTORY add constraint FKln3h26o4wxnda8e4o39f29stw foreign key (USER_ID) references axk167131.UserDetailsModel
alter table axk167131.UserDetailsModel add constraint FKfec8gmrkytmugadonlf9i33en foreign key (loginInfo_LoginId) references axk167131.login