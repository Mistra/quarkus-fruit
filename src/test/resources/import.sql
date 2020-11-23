INSERT INTO fruit(id, name) VALUES (1, 'Mango');
INSERT INTO fruit(id, name) VALUES (2, 'Apple');
INSERT INTO fruit(id, name) VALUES (3, 'Banana');

INSERT INTO basket(id, name) VALUES (1, 'Exotic');
INSERT INTO basket(id, name) VALUES (2, 'Seasonal');

INSERT INTO basket_fruit(id, basket_id, fruit_id) VALUES (1, 1, 1);
INSERT INTO basket_fruit(id, basket_id, fruit_id) VALUES (2, 1, 3);
INSERT INTO basket_fruit(id, basket_id, fruit_id) VALUES (3, 2, 2);
INSERT INTO basket_fruit(id, basket_id, fruit_id) VALUES (4, 2, 3);