insert into users (user_id, username, password, email, role) values ('a', 'jonny', 'pass', 'bow682@gmail.com', 'BUYER');
insert into users (user_id, username, password, email, role) values ('b', 'lesly', 'pass', 'lesly@email.com',  'ADMIN');
insert into users (user_id, username, password, email, role) values ('c', 'roger', 'pass', 'roger@email.com',  'ADMIN');
insert into users (user_id, username, password, email, role) values ('d', 'lily',  'pass', 'lily@email.com',   'ADMIN');

insert into items (item_id, image, name, price, material) values ('fghgfyy', '', 'Pickaxe', 2.99,   'IRON');
insert into items (item_id, image, name, price, material) values ('dgrth56', '', 'Pickaxe', 29.99,  'GOLD');
insert into items (item_id, image, name, price, material) values ('fghgf45', '', 'Pickaxe', 59.99,  'DIAMOND');
insert into items (item_id, image, name, price, material) values ('fghgfrt', '', 'Pickaxe', 149.99, 'NETHERITE');
insert into items (item_id, image, name, price, material) values ('fdfgdgd', '', 'Shovel', 2.99,   'IRON');
insert into items (item_id, image, name, price, material) values ('fgbfdbb', '', 'Shovel', 29.99,  'GOLD');
insert into items (item_id, image, name, price, material) values ('3453gfg', '', 'Shovel', 59.99,  'DIAMOND');
insert into items (item_id, image, name, price, material) values ('gfdgdf5', '', 'Shovel', 149.99, 'NETHERITE');
insert into items (item_id, image, name, price, material) values ('grt44fg', '', 'Leggings', 2.99,   'IRON');
insert into items (item_id, image, name, price, material) values ('gdfg555', '', 'Leggings', 29.99,  'GOLD');
insert into items (item_id, image, name, price, material) values ('34534vd', '', 'Leggings', 59.99,  'DIAMOND');
insert into items (item_id, image, name, price, material) values ('34dffdf', '', 'Leggings', 149.99, 'NETHERITE');

insert into orders (order_id, user_id, item_id, quantity) values ('1', 'a', '1', 1);
insert into orders (order_id, user_id, item_id, quantity) values ('2', 'b', '2', 1);