INSERT INTO product (id, name, description, weight, size, model, brand, manufacturer, techSpecs, shortDescription, promoText, ean, upc, isbn, mpn, sku, groupingId, language, created_by, created_date, last_modified_by, last_modified_date) VALUES 
(1, 'First Test product name', 'First description', '1999 g', '110x60x60 cm', 'KajSharpTV000001', 'Sharp', 'Sharp', 'SMART HUB', 'Televisions from Sharp', 'Discounted price!!', 'ean10100000000000001', 'upc10100000000000001', 'isn10100000000000001', 'mpn10100000000000001', 'SKU1-TV000001', null, null, 'Amol Zambare', '2023-06-05 15:37:14', 'Amol Zambare', '2023-06-05 15:37:14');

INSERT INTO product (id, name, description, weight, size, model, brand, manufacturer, techSpecs, shortDescription, promoText, ean, upc, isbn, mpn, sku, groupingId, language, created_by, created_date, last_modified_by, last_modified_date) VALUES 
(2, 'Second Test product name', 'Second description', '500 g', '120x70x70 cm', 'SamsungMobile000001', 'Samsung', 'Samsung', 'SMART Mobile', 'Mobile from Samsung', 'Reduced price!!', 'ean101000000000000011', 'upc101000000000000011', 'isn101000000000000011', 'mpn101000000000000011', 'SKU1-TV0000011', null, null, 'Amol Zambare', '2023-06-05 15:37:20', 'Amol Zambare', '2023-06-05 15:37:20');

INSERT INTO product (id, name, description, weight, size, model, brand, manufacturer, techSpecs, shortDescription, promoText, ean, upc, isbn, mpn, sku, groupingId, language, created_by, created_date, last_modified_by, last_modified_date) VALUES 
(3, 'Third Test product name', 'Third description', '1500 g', '130x80x80 cm', 'SonyTV000001', 'Sony', 'Sony', 'SMART TV', 'Televisions from Sony', 'Reduced price!!', 'ean101000000000000012', 'upc101000000000000012', 'isn101000000000000012', 'mpn101000000000000012', 'SKU1-TV0000012', null, null, 'Amol Zambare', '2023-06-05 15:37:20', 'Amol Zambare', '2023-06-05 15:37:20');

INSERT INTO product_image (id, fk_productid, value, height, width, created_by, created_date, last_modified_by, last_modified_date) 
VALUES (1, 1, 'image1.jpg', 20, 20, 'Amol Zambare', '2023-06-05 15:37:19', 'Amol Zambare', '2023-06-05 15:37:19');
INSERT INTO product_image (id, fk_productid, value, height, width, created_by, created_date, last_modified_by, last_modified_date) 
VALUES (2, 1, 'image2.jpg', 200, 200, 'Amol Zambare', '2023-06-05 15:37:19', 'Amol Zambare', '2023-06-05 15:37:19');

INSERT INTO product_image (id, fk_productid, value, height, width, created_by, created_date, last_modified_by, last_modified_date) 
VALUES (3, 2, 'image2.jpg', 200, 200, 'Amol Zambare', '2023-06-05 15:37:20', 'Amol Zambare', '2023-06-05 15:37:20');

INSERT INTO product_image (id, fk_productid, value, height, width, created_by, created_date, last_modified_by, last_modified_date) 
VALUES (4, 3, 'image2.jpg', 200, 200, 'Amol Zambare', '2023-06-05 15:37:20', 'Amol Zambare', '2023-06-05 15:37:20');
