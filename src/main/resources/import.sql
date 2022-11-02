insert into users (user_id, username, password, email, role) values ('a', 'jonny', 'pass', 'bow682@gmail.com', 'BUYER');
insert into users (user_id, username, password, email, role) values ('b', 'lesly', 'pass', 'lesly@email.com',  'ADMIN');
insert into users (user_id, username, password, email, role) values ('c', 'roger', 'pass', 'roger@email.com',  'ADMIN');
insert into users (user_id, username, password, email, role) values ('d', 'lily',  'pass', 'lily@email.com',   'ADMIN');

insert into items (item_id, image, name, price, material) values ('1', '', 'Pickaxe', 2.99, 'IRON');
insert into items (item_id, image, name, price, material) values ('2', '', 'Shovel', 2.99, 'GOLD');
insert into items (item_id, image, name, price, material) values ('3', '', 'Axe', 2.99, 'DIAMOND');
insert into items (item_id, image, name, price, material) values ('4', '', 'Helmet', 2.99, 'NETHERITE');

insert into orders (order_id, user_id, item_id, quantity) values ('1', 'a', '1', 1);
insert into orders (order_id, user_id, item_id, quantity) values ('2', 'b', '2', 1);