INSERT INTO fruit(id, name) VALUES (1, 'Mango');
INSERT INTO fruit(id, name) VALUES (2, 'Apple');
INSERT INTO fruit(id, name) VALUES (3, 'Banana');
INSERT INTO fruit(id, name) VALUES (4, 'Pear');
INSERT INTO fruit(id, name) VALUES (5, 'Papaya');
INSERT INTO fruit(id, name) VALUES (6, 'Coconut');
INSERT INTO fruit(id, name) VALUES (7, 'Orange');
INSERT INTO fruit(id, name) VALUES (8, 'Mandarin');
INSERT INTO fruit(id, name) VALUES (9, 'Prune');
INSERT INTO fruit(id, name) VALUES (10, 'Cherry');
INSERT INTO fruit(id, name) VALUES (11, 'Melon');
INSERT INTO fruit(id, name) VALUES (12, 'Nut');
INSERT INTO fruit(id, name) VALUES (13, 'Passion Fruit');

INSERT INTO basket(id, name) VALUES (1, 'Exotic');
INSERT INTO basket(id, name) VALUES (2, 'Seasonal');

INSERT INTO basket_fruit(id, basket_id, fruit_id) VALUES (1, 1, 1);
INSERT INTO basket_fruit(id, basket_id, fruit_id) VALUES (2, 1, 3);

INSERT INTO basket_fruit(id, basket_id, fruit_id) VALUES (3, 2, 2);
INSERT INTO basket_fruit(id, basket_id, fruit_id) VALUES (4, 2, 3);

INSERT INTO basket_fruit(id, basket_id, fruit_id) VALUES (5, 1, 5);
INSERT INTO basket_fruit(id, basket_id, fruit_id) VALUES (6, 1, 6);
INSERT INTO basket_fruit(id, basket_id, fruit_id) VALUES (7, 1, 11);
INSERT INTO basket_fruit(id, basket_id, fruit_id) VALUES (8, 1, 12);
INSERT INTO basket_fruit(id, basket_id, fruit_id) VALUES (9, 1, 13);