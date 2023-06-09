
CREATE TABLE categories (id bigint NOT NULL AUTO_INCREMENT, name varchar(512), tdCategoryName varchar(512),
created_by varchar(256), created_date datetime, last_modified_by varchar(256), last_modified_date datetime, 
PRIMARY KEY (id));

CREATE TABLE currency (id bigint NOT NULL AUTO_INCREMENT, currency varchar(512), 
created_by varchar(256), created_date datetime, last_modified_by varchar(256), last_modified_date datetime, PRIMARY KEY (id));

CREATE TABLE fields (id bigint NOT NULL AUTO_INCREMENT, name varchar(256), 
created_by varchar(256), created_date datetime, last_modified_by varchar(256), last_modified_date datetime, PRIMARY KEY (id));

CREATE TABLE product (id bigint NOT NULL AUTO_INCREMENT, name varchar(512) NOT NULL, description text, weight varchar(16), 
size varchar(16), model varchar(128), brand varchar(256), manufacturer varchar(256), techSpecs varchar(256), 
shortDescription varchar(512), promoText varchar(512), ean varchar(128), upc varchar(128), isbn varchar(128), 
mpn varchar(128), sku varchar(256), groupingId varchar(512), language varchar(128), 
created_by varchar(256), created_date datetime, last_modified_by varchar(256), last_modified_date datetime, PRIMARY KEY (id));

CREATE TABLE product_category_mapping (id bigint NOT NULL AUTO_INCREMENT, fk_productid bigint NOT NULL, 
fk_categoryid bigint NOT NULL, 
created_by varchar(256), created_date datetime, last_modified_by varchar(256), last_modified_date datetime, PRIMARY KEY (id), 
CONSTRAINT productcategorymapping_fk2 FOREIGN KEY (fk_categoryid) REFERENCES `categories` (`id`) , 
CONSTRAINT productcategorymapping_fk3 FOREIGN KEY (fk_productid) REFERENCES `product` (`id`));

CREATE TABLE product_field_mapping (id bigint NOT NULL AUTO_INCREMENT, fk_productid bigint NOT NULL, 
fk_fieldid bigint NOT NULL, value varchar(512), created_by varchar(256), created_date datetime, last_modified_by varchar(256), last_modified_date datetime,
PRIMARY KEY (id), 
CONSTRAINT productfieldmapping_fk1 FOREIGN KEY (fk_productid) REFERENCES `product` (`id`) , 
CONSTRAINT productfieldmapping_fk2 FOREIGN KEY (fk_fieldid) REFERENCES `fields` (`id`));

CREATE TABLE product_image (id bigint NOT NULL AUTO_INCREMENT, fk_productid bigint NOT NULL, value varchar(512), 
height int, width int, created_by varchar(256), created_date datetime, last_modified_by varchar(256), last_modified_date datetime, 
PRIMARY KEY (id), CONSTRAINT productimage_fk1 
FOREIGN KEY (fk_productid) REFERENCES `product` (`id`));

CREATE TABLE product_offers (id bigint NOT NULL AUTO_INCREMENT, fk_productid bigint NOT NULL, feedId bigint, 
productUrl varchar(512), programName varchar(512), programLogo varchar(512), warranty varchar(512), inStock int, 
availability varchar(512), deliveryTime varchar(512), shippingCost varchar(512), offerid varchar(256), 
sourceProductId varchar(512), modifiedDate bigint, dateFormat varchar(256), conditions varchar(512),
created_by varchar(256), created_date datetime, last_modified_by varchar(256), last_modified_date datetime, 
PRIMARY KEY (id), CONSTRAINT productoffers_fk1 FOREIGN KEY (fk_productid) REFERENCES `product` (`id`));

CREATE TABLE product_offer_price (id bigint NOT NULL AUTO_INCREMENT, fk_offerid bigint NOT NULL, fk_currencyid bigint, 
value decimal, date bigint, dateFormat varchar(512), 
created_by varchar(256), created_date datetime, last_modified_by varchar(256), last_modified_date datetime,
PRIMARY KEY (id), 
CONSTRAINT productofferprice_fk1 FOREIGN KEY (fk_offerid) REFERENCES `product_offers` (`id`));


